package com.wgh.dao;

import commerce.goods;//������Ʒjavabean
import com.wgh.DB.chStr;//�����ַ�������javabean
import com.wgh.DB.connDB;//�������ݿ����javabean

public class GoodsDaoImpl implements GoodsDao {//����GoodsDaoImpl��ʹ�õĽӿ�
  connDB conn = new connDB();
  chStr chStr = new chStr();
  public int insert(goods g) {//ʵ��GoodDao�ӿ��е�insert����������Ʒ���ݱ���в������
    int ret = -1;
    try {
      String sql = "Insert into tb_goods (TypeID,GoodsName,Introduce,Price,nowPrice,picture,newgoods,sale) values(" +
          g.getTypeID() + ",'" + chStr.chStr(g.getGoodsName()) + "','" +
          chStr.chStr(g.getIntroduce()) + "'," + g.getPrice() + "," +
          g.getPrice() + ",'" + chStr.chStr(g.getPicture()) + "'," +
          g.getNewGoods() + "," + g.getSale() + ")";

      ret = conn.executeUpdate(sql);
    }
    catch (Exception e) {
      ret = 0;
    }
    conn.close();
    return ret;
  }

  public int update(goods g) {
    int ret = -1;
    try {
     String sql = "update tb_Goods set TypeID=" +g.getTypeID() +
         ",GoodsName='" + chStr.chStr(g.getGoodsName()) + "',introduce='" +
         chStr.chStr(g.getIntroduce()) + "',price=" + g.getPrice() +
         ",nowprice=" + g.getNowPrice() +",picture='" + chStr.chStr(g.getPicture())+ "',newgoods=" +
         g.getNewGoods() + ",sale=" + g.getSale() + " where ID=" + g.getID();//һ��Ҫ��where��������Ȼ�������ݿ���ȫ������
     ret = conn.executeUpdate(sql);
   }
   catch (Exception e) {
     ret = 0;
   }
   conn.close();
   return ret;
 }


  public int delete(goods g) {
    int ret=-1;
    try{
      String sql="Delete from tb_goods where ID="+g.getID();
      ret=conn.executeUpdate(sql);
    }catch(Exception e){
      ret=0;
    }
    conn.close();
    return ret;

  }

}
