package com.imnu.controller;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.imnu.po.User;
import com.imnu.service.INFService;
import com.imnu.service.UserService;

@Controller
public class UserController {
     @Autowired
     private UserService userService;
     @Autowired
     private INFService infService;
     @RequestMapping(value = "/login.action" ,method = RequestMethod.GET)
     public String Login1() {
    	 return "login";
     }
     @RequestMapping(value = "/update.action" ,method = RequestMethod.POST)
     public String update(String u_name,String u_phone,String u_email,String u_message,HttpSession session) {
    	 User user = (User) session.getAttribute("USER_SESSION");
     	 String u_user = user.getU_user();
    	 infService.deletemy(u_email);
    	 session.removeAttribute("USER_SESSION");
    	 userService.updatemy(u_user,u_name,u_phone,u_email,u_message);
    	 User user1 = userService.findUser(u_user);
    	 session.setAttribute("USER_SESSION", user1); 
    	 return "my";
     }
     @RequestMapping(value = "/updatejd.action" ,method = RequestMethod.POST)
     public String updatejd(String u_name,String u_phone,String u_email,String u_type,String p_img,String p_dirpath,String u_Jurisdiction,String u_message) {
    	 if(u_Jurisdiction.equals("是")) {
    		 userService.updateno(u_email);
    		 infService.deleteinf(u_email);
    		 return "redirect:SelectAll.action";
    	 }else {
    		 userService.updateyes(u_email);
    		 infService.insertinf(u_name,u_phone,u_email,u_type,p_img,p_dirpath,u_message);
    		 return "redirect:SelectAll.action";
    	 }
     }
     @RequestMapping(value = "/login.action" ,method = RequestMethod.POST)
     public String Login(String u_user, String u_pwd,String u_type,Model model,HttpSession session) {
	    	User user = userService.LoginUser(u_user, u_pwd);
	    	 if(user != null) {
	    		 if(user.getU_type().equals(u_type)) {
	    			 if(user.getU_type().equals("管理员")) {
	    				 session.setAttribute("USER_SESSION", user);
			       		 return "admin-root";
	    			 }else {
	    				 session.setAttribute("USER_SESSION", user);
			       		 return "admin-index";
	    			 }  
	    		 }else {
	    			 model.addAttribute("msg","用户类型错误!");
		       		 return "login";
	    		 }
	       		 
	       	 }else {
	       		 model.addAttribute("msg","用户名或密码错误!");
	       		 return "login";
		       	 }
	    	
    	 
     }
     @RequestMapping(value = "/Exit.action" ,method = RequestMethod.POST)
     public String Exit(HttpSession session) {
    	 session.invalidate();
    	 return "redirect:login.action";
     }
	@RequestMapping(value = "/register.action" ,method = RequestMethod.GET)
     public String toregister() {
    	 return "register";
     }
     @RequestMapping(value = "/register.action" ,method = RequestMethod.POST)
     public String register(@RequestParam("uploadfile") List<MultipartFile> uploadfile,String u_user, String u_pwd,String u_name,String u_email,String u_phone,String u_type,String u_message,Model model,HttpSession session,HttpServletRequest request) throws InterruptedException
     {
    	 if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
    		 User email = userService.findEmail(u_email);
        	 User user = userService.findUser(u_user);
             if(email != null) {
            	 model.addAttribute("msg","邮箱已存在，请重新输入!");
    	   		 return "register"; 
             }else if(user != null) {
    	    	 model.addAttribute("msg","用户名已存在，请重新输入!");
    	   		 return "register";
    	   	 }else {
    	   		 //循环输出上传的文件
    	 			for (MultipartFile file : uploadfile) {
    	 				// 获取上传文件的原始名称
    	 				String originalFilename = file.getOriginalFilename();
    	 				// 设置上传文件的保存地址目录
    	 				String dirPath = 
    	                        request.getServletContext().getRealPath("/upload/");
    	 				File filePath = new File(dirPath);
    	 				// 如果保存文件的地址不存在，就先创建目录
    	 				if (!filePath.exists()) {
    	 					filePath.mkdirs();
    	 				}
    	 				// 使用UUID重新命名上传的文件名称(上传人_uuid_原始文件名称)
    	 				String newFilename = originalFilename;
    	 				try {
    	 					// 使用MultipartFile接口的方法完成文件上传到指定位置
    	 					file.transferTo(new File(dirPath + newFilename));
    	 				} catch (Exception e) {
    	 					e.printStackTrace();
    	                        return"error";
    	 				}
    	 				String p_dirpath = dirPath + newFilename;
    	 				String p_img = "upload" +"/"+ newFilename;
    	 				userService.registerUser(u_user, u_pwd,u_name,u_email,u_phone,u_type,p_img,p_dirpath,u_message);
    	 				try {
    	 					zoomImage(dirPath+newFilename,dirPath+newFilename,600,400);
    	 				} catch (Exception e) {
    	 					// TODO Auto-generated catch block
    	 					e.printStackTrace();
    	 				}
    	 			}
    	    	 
    	       	 return "login"; 
    	   	 }
    		
 			
 		}else{
 			return"error";
 		}
     }
    
     public static void zoomImage(String src,String dest,int w,int h) throws Exception {
	        
	        double wr=0,hr=0;
	        File srcFile = new File(src);
	        File destFile = new File(dest);

	        BufferedImage bufImg = ImageIO.read(srcFile); //读取图片
	        @SuppressWarnings("static-access")
			Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);//设置缩放目标图片模板
	        
	        wr=w*1.0/bufImg.getWidth();     //获取缩放比例
	        hr=h*1.0 / bufImg.getHeight();

	        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
	        Itemp = ato.filter(bufImg, null);
	        try {
	            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile); //写入缩减后的图片
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
}
