package com.qst.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qst.bean.RecommendBean;
import com.qst.service.RecommendService;
import com.qst.service.RecommendServiceimp;


/**
 * Servlet implementation class Recommend
 */
@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
	private static final long serialVersionUID = 5804433309240831094L;

	public Recommend() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest) request; 
		req.setCharacterEncoding("utf-8");
		
		RecommendBean rec = new RecommendBean();
		
		
		 //1、创建一个DiskFileItemFactory工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //2、创建一个文件上传解析器  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        //解决上传文件名的中文乱码  
        upload.setHeaderEncoding("UTF-8");   
        factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K  
        File linshi = new File("D:\\linshi");//当超过500K的时候，存到一个临时文件夹中  
        factory.setRepository(linshi);  
        upload.setSizeMax(1024 * 1024 * 100);//设置上传的文件总的大小不能超过5M  
        try {  
            // 1. 得到 FileItem 的集合 items  
            List<FileItem> /* FileItem */items = upload.parseRequest(request);
  
            // 2. 遍历 items:  
            for (FileItem item : items) {  
                // 若是一个一般的表单域, 打印信息  
                if (item.isFormField()) {  
                    String value = item.getString("utf-8"); 
                    if ("recName".equals(item.getFieldName())) {
                        rec.setComname(new String(item.getString("UTF-8")));
                        System.out.println(rec.getComname());
                    }else if ("price".equals(item.getFieldName())) {
                       rec.setPrice(new String(item.getString("UTF-8")));
                        System.out.println(rec.getPrice());
                    } 
                    
                    
                    
                }  
                // 若是文件域则把文件保存到 "f:\\upload\\img 目录下.  
                else {
                    String photoname = item.getName();  
                    long sizeInBytes = item.getSize();  
                    System.out.println(photoname);  
                    System.out.println(sizeInBytes);  
  
                    InputStream in = item.getInputStream();  
                    byte[] buffer = new byte[1024];  
                    int len = 0;  
  
                    photoname = "f:\\upload\\img" + photoname.substring(photoname.lastIndexOf("\\"));//文件最终上传的位置  
                    String photo = photoname.substring(photoname.lastIndexOf("\\"));
                    
                    //System.out.println();
                    OutputStream out = new FileOutputStream(photoname);
                    
  
                    
                    
                    
                    
                    while ((len = in.read(buffer)) != -1) {  
                        out.write(buffer, 0, len);  
                    }  
		
                   
            		rec.setPhoto(photo);
            		rec.setPhotoname(photoname);
		
//            		System.out.println(photoname);
            		out.close();  
            		in.close();  
                } 
    
            }
            
            

        } catch (FileUploadException e) {  
        	e.printStackTrace();  
        }  

		
		RecommendService recommendService = new RecommendServiceimp();
		
		if(recommendService.findRecommend(rec)){//如果学生已经存在就不添加
			response.sendRedirect("html/index.jsp");
			
		}else{//如果学生不存在就添加
			
			String opr = request.getParameter("opr");//根据传的opr参数决定是添加学生还是修改学生
			System.out.println(opr);
			int n = 0;
			if(opr.equals("addRec")){
				n = recommendService.addRecommend(rec);
			}else if(opr.equals("modifyrec")){
				int id = (Integer)request.getSession().getAttribute("recId");
				System.out.println(id);
				rec.setComid(id);
				
				n = recommendService.modifyRecommend(rec);
			}
			
			
			if(n>0){
				response.sendRedirect("html/index.jsp");
			}else{
				response.sendRedirect("html/index.jsp");
			}
			
		}
		
		

	}

	public void init() throws ServletException {
	}

}
