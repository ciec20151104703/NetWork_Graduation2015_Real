package com.bs.sxd.controller;

import java.io.File;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bs.sxd.po.Goods;

import com.bs.sxd.service.GoodsService;

/**
 * ��Ʒ��������
 * 
 * @author ��ѩ��
 *
 */
@Controller
  
public class GoodsController {
	// ����ע��
		@Autowired
		private GoodsService goodsService;
	@RequestMapping(value = "/addgoods.action", method = RequestMethod.POST)
	public String addGoods(Goods goods, String l_name, String l_image, Integer l_price, String l_info, String l_type,
			String l_out_time, Date l_in_time, String l_addr,Integer u_id) throws Exception {
		System.out.println(l_name);
		l_price = Integer.valueOf(l_price).intValue();
		 //�������ݿ��·��  
        String sqlPath = null;   
        //�����ļ�����ı���·��  
        String localPath="D:\\File\\";  
        //���� �ļ���  
        String filename=null;    
        if(!goods.getFile().isEmpty()){    
            //����uuid��Ϊ�ļ�����    
            String uuid = UUID.randomUUID().toString().replaceAll("-","");    
            //����ļ����ͣ������ж��������ͼƬ����ֹ�ϴ���    
            String contentType=goods.getFile().getContentType();    
            //����ļ���׺��   
            String suffixName=contentType.substring(contentType.indexOf("/")+1);  
            //�õ� �ļ���  
            filename=uuid+"."+suffixName;   
            System.out.println(filename);  
            //�ļ�����·��  
            goods.getFile().transferTo(new File(localPath+filename));    
        }  
        //��ͼƬ�����·�����������ݿ�  
        sqlPath = "/images/"+filename;  
        System.out.println(sqlPath);  
       
        goods.setL_name(l_name);
        //goods.setL_image(l_image);
  		goods.setL_price(l_price);
  		goods.setL_info(l_info);
  		goods.setL_type(l_type);
  		goods.setL_out_time(l_out_time);
  		goods.setL_in_time(l_in_time);
  		goods.setL_addr(l_addr);
  		goods.setU_id(u_id);
        goods.setL_image(sqlPath); 
        System.out.println(goods);
        goodsService.addGoods(goods);
     
        return "person";

	    }  
	
}
