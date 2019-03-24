package com.lyh.dao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;
 
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
 
/**
 * TODO
 * @author XWF
 */
public class BS_RXTXCom {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//���ϵͳ�˿��б�
		getSystemPort();
		//�����˿�COM2��������9600
		final SerialPort serialPort = openSerialPort("COM4",9600);
		//���ô��ڵ�listener
        BS_RXTXCom.setListenerToSerialPort(serialPort, new SerialPortEventListener() {
			@Override
			public void serialEvent(SerialPortEvent arg0) {
				if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {//����֪ͨ
					byte[] bytes = BS_RXTXCom.readData(serialPort);
					System.out.println("�յ������ݳ��ȣ�"+bytes.length);
					System.out.println("�յ������ݣ�");
					System.out.println(new String(bytes));
					String str = new String(bytes);
					String houseId = str.substring(0, str.indexOf(":"));
					float hum = Float.parseFloat(str.substring(str.indexOf("Hum:")+4, str.indexOf(",Tem:")));
					float tem = Float.parseFloat(str.substring(str.indexOf("Tem:")+4));
					System.out.println(houseId+":"+hum+":"+tem);
					Connection con;
			        String driver = "com.mysql.jdbc.Driver";
			        String url = "jdbc:mysql://localhost:3306/LaboratoryCloudMonitoringSystem";
			        String user = "root";
			        String password = "123456";
			        try {
			            Class.forName(driver);
			            con = DriverManager.getConnection(url,user,password);
			            con.createStatement();
			            String sql = "select laboratory.tem_id from laboratory,place where laboratory.place_id = place.place_id and place.house_id = ?";
			            PreparedStatement pstm =null;
			            ResultSet rs = null ;
			            pstm = con.prepareStatement(sql);
						pstm.setString(1, houseId);
						rs = pstm.executeQuery();
			            int temId = 0;
			            while(rs.next()){
			            	temId = Integer.parseInt(rs.getString("tem_id"));
			            }
			            System.out.println(temId);
			            rs.close();
			            PreparedStatement psql;
			            psql = con.prepareStatement("insert into tem_hum (tem_id, time, temperature, humidity) "
			                    + "values(?,?,?,?)");
			            psql.setInt(1, temId);  
			            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			            psql.setString(2, df.format(new Date()));
			            psql.setFloat(3, tem);
			            psql.setFloat(4, hum);
			            psql.executeUpdate();   
			            con.close();
			        } catch(ClassNotFoundException e) {   
			            e.printStackTrace();   
			            } catch(SQLException e) {
			            e.printStackTrace();  
			            }catch (Exception e) {
			            e.printStackTrace();
			        }
				}
			}
		});
        
        //closeSerialPort(serialPort);
	}
	
	/**
	 * ���ϵͳ���õĶ˿������б�
	 * @return ���ö˿������б�
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getSystemPort(){
		List<String> systemPorts = new ArrayList<>();
		//���ϵͳ���õĶ˿�
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
		while(portList.hasMoreElements()) {
			String portName = portList.nextElement().getName();//��ö˿ڵ�����
			systemPorts.add(portName);
		}
		System.out.println("ϵͳ���ö˿��б�"+systemPorts);
		return systemPorts;
	}
	
	/**
	 * ��������
	 * @param serialPortName ��������
	 * @param baudRate ������
	 * @return ���ڶ���
	 */
	public static SerialPort openSerialPort(String serialPortName,int baudRate) {
		try {
			//ͨ���˿����Ƶõ��˿�
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(serialPortName);
			//�򿪶˿ڣ����Զ������֣��򿪳�ʱʱ�䣩
			CommPort commPort = portIdentifier.open(serialPortName, 2222);
			//�ж��ǲ��Ǵ���
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                //���ô��ڲ����������ʣ�����λ8��ֹͣλ1��У��λ�ޣ�
                serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);                              
                System.out.println("�������ڳɹ����������ƣ�"+serialPortName);
                return serialPort;
            }        
            else {
                //���������͵Ķ˿�
                throw new NoSuchPortException();
            }
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �رմ���
	 * @param serialPort Ҫ�رյĴ��ڶ���
	 */
	public static void closeSerialPort(SerialPort serialPort) {
		if(serialPort != null) {
			serialPort.close();
			System.out.println("�ر��˴��ڣ�"+serialPort.getName());
			serialPort = null;
		}
	}
	
	/**
	 * �Ӵ��ڶ�ȡ����
	 * @param serialPort Ҫ��ȡ�Ĵ���
	 * @return ��ȡ������
	 */
	public static byte[] readData(SerialPort serialPort) {
		InputStream is = null;
        byte[] bytes = null;
        try {
        	is = serialPort.getInputStream();//��ô��ڵ�������
            int bufflenth = is.available();//������ݳ���
            while (bufflenth != 0) {                             
                bytes = new byte[bufflenth];//��ʼ��byte����
                is.read(bytes);
                bufflenth = is.available();
            } 
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                	is.close();
                	is = null;
                }
            } catch(IOException e) {
            	e.printStackTrace();
            }
        }
        return bytes;
	}
	
	/**
	 * ���������ü���
	 * @param serialPort
	 * @param listener
	 */
	public static void setListenerToSerialPort(SerialPort serialPort, SerialPortEventListener listener) {
		try {
			//����������¼�����
			serialPort.addEventListener(listener);
		} catch (TooManyListenersException e) {
			e.printStackTrace();
		}
		serialPort.notifyOnDataAvailable(true);//���������ݼ���
		serialPort.notifyOnBreakInterrupt(true);//�ж��¼�����
	}
	
}

