package com.bs.sxd.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.bs.common.utils.Page;
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
	public String addGoods(Goods goods, String l_name, String u_name, String l_image, Integer l_price, Integer u_id,
			String l_info, String l_type, String l_out_time, String l_in_time, String l_addr, String year, String month,
			String day) throws Exception {
		l_in_time = year + "-" + month + "-" + day;
		l_price = Integer.valueOf(l_price).intValue();
		// �������ݿ��·��
		String sqlPath = null;
		// �����ļ�����ı���·��
		String localPath = "D:\\File\\";
		// ���� �ļ���
		String filename = null;
		if (!goods.getFile().isEmpty()) {
			// ����uuid��Ϊ�ļ�����
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// ����ļ����ͣ������ж��������ͼƬ����ֹ�ϴ���
			String contentType = goods.getFile().getContentType();
			// ����ļ���׺��
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			// �õ� �ļ���
			filename = uuid + "." + suffixName;
			System.out.println(filename);
			// �ļ�����·��
			goods.getFile().transferTo(new File(localPath + filename));
		}
		// ��ͼƬ�����·�����������ݿ�
		sqlPath = "/images/" + filename;
		int l_static = 1;
		goods.setL_name(l_name);
		goods.setL_price(l_price);
		goods.setL_info(l_info);
		goods.setL_type(l_type);
		goods.setL_out_time(l_out_time);
		goods.setL_in_time(l_in_time);
		goods.setL_addr(l_addr);
		goods.setU_name(u_name);
		goods.setU_id(u_id);
		goods.setL_image(sqlPath);
		goods.setL_static(l_static);
		goodsService.addGoods(goods);
		return "person";
	}

	// ��ӵ�������purchases
	@RequestMapping(value = "/addToPurchases.action", method = RequestMethod.POST)
	public String addToPurchases( String username, String u_name, String l_static,Model model, HttpSession session) {
		System.out.println(username);
		System.out.println(u_name);
		if(username.equals(u_name) || !l_static.equals(0)){
			model.addAttribute("msg_error", "���޷������Լ�����Ʒ����Ʒ���ܱ����򣡣�");
			return "commodity_information";
			
		}else{
		Goods g = (Goods) session.getAttribute("GOODS_SESSION");
		Goods pur = new Goods();
		pur.setId(g.getId());
		pur.setL_name(g.getL_name());
		pur.setL_out_time(g.getL_out_time());
		pur.setL_in_time(g.getL_in_time());
		pur.setU_name(g.getU_name());
		pur.setL_image(g.getL_image());
		pur.setL_type(g.getL_type());
		pur.setL_price(g.getL_price());
		goodsService.addToPurchases(pur);
		goodsService.updategoodsstatic(g.getId());
		return "My_purchases";
		}
	}

	// �û� ģ������������ҳ��ѯ������Ʒ��������ҳ��
	@RequestMapping(value = "/findgoodslist.action")
	public String list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "6") Integer rows,
			String l_name, String l_type, Integer l_static, Model model) {
		if (l_name != null && l_name != "") {
			l_name = "%" + l_name + "%";
		}
		Page<Goods> goods = goodsService.findGoods_yList(page, rows, l_static, l_name, l_type);
		// ��Ӳ���
		model.addAttribute("page", goods);
		model.addAttribute("l_name", l_name);
		model.addAttribute("l_static", l_static);
		model.addAttribute("l_type", l_type);
		return "main";
	}

	// ����Աģ������������ҳ��ѯ
	@RequestMapping(value = "/findgoodslist_a.action")
	public String list_a(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows,
			String l_name, String l_type, Integer l_static, Model model) {
		if (l_name != null && l_name != "") {
			l_name = "%" + l_name + "%";
		}
		Page<Goods> goods = goodsService.findGoods_yList(page, rows, l_static, l_name, l_type);
		// ��Ӳ���
		model.addAttribute("page", goods);
		model.addAttribute("l_name", l_name);
		model.addAttribute("l_static", l_static);
		model.addAttribute("l_type", l_type);
		return "table-goods-list-admin";
	}

	// �û�ģ������������ҳ��ѯ�Լ�����Ʒ�����ڲ�ѯ�ҵ���Ʒ
	@RequestMapping(value = "/findgoodslist_u.action")
	public String list_u(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows,
			String l_name, String l_type, Integer l_static, Integer u_id, Model model) {
		if (l_name != null && l_name != "") {
			l_name = "%" + l_name + "%";
		}
		Page<Goods> goods = goodsService.findGoods_uList(page, rows, l_static, l_name, l_type, u_id);
		// ��Ӳ���
		model.addAttribute("page", goods);
		model.addAttribute("l_name", l_name);
		model.addAttribute("l_static", l_static);
		model.addAttribute("l_type", l_type);
		model.addAttribute("u_id", u_id);
		return "mygoods";
	}

	// ����Ա�޸���Ʒ״̬(�¼���Ʒ)
	@RequestMapping(value = "/updategools_xiajia.action")
	public String update_Goods(Integer l_static, Integer id, Model model) {
		Goods goods = new Goods();
		if (l_static == 1) {
			l_static = 3;
		} else {
			model.addAttribute("msg_G", "��Ʒ�Ѿ��¼ܣ������ظ���������");
			return "table-goods-list-admin";
		}
		goods.setId(id);
		goods.setL_static(l_static);
		goodsService.updategoodstype_n(goods);
		return "table-goods-list-admin";
	}

	// ����Աɾ����Ʒ
	@RequestMapping(value = "/deleteGoods.action")
	public String delete_Goods(Integer id) {
		goodsService.deletegoods(id);
		return "table-goods-list-admin";

	}

	// �û�ɾ����Ʒ
	@RequestMapping(value = "/deletemyGoods.action")
	public String deletemyGoods(Integer id, Integer l_static, Model model) {
		if (l_static == 0) {
			goodsService.deletemygoods(id);
		} else {
			model.addAttribute("msg_scyhsp", "��Ʒ��������״̬���޷�ɾ������");
		}

		return "mygoods";

	}

	// �û��޸���Ʒ״̬
	@RequestMapping(value = "/updatemygools.action")
	public String update_MyGoods(Integer id, HttpSession session) {
		Goods goods = goodsService.findThegoods(id);
		session.setAttribute("MYGOODS_SESSION", goods);
		return "Edit_Per_goods";
	}

	// �û��޸���Ʒ��Ϣ
	@RequestMapping(value = "/editmygoods.action")
	public String editgoods(Goods goods, Integer id, String l_name, String l_image, Integer l_price, String l_info,
			String l_out_time, String l_in_time, String l_addr, String year, String month, String day)
			throws Exception {
		l_in_time = year + "-" + month + "-" + day;
		l_price = Integer.valueOf(l_price).intValue();
		id = Integer.valueOf(id).intValue();
		// �������ݿ��·��
		String sqlPath = null;
		// �����ļ�����ı���·��
		String localPath = "D:\\File\\";
		// ���� �ļ���
		String filename = null;
		if (!goods.getFile().isEmpty()) {
			// ����uuid��Ϊ�ļ�����
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// ����ļ����ͣ������ж��������ͼƬ����ֹ�ϴ���
			String contentType = goods.getFile().getContentType();
			// ����ļ���׺��
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			// �õ� �ļ���
			filename = uuid + "." + suffixName;
			System.out.println(filename);
			// �ļ�����·��
			goods.getFile().transferTo(new File(localPath + filename));
		}
		// ��ͼƬ�����·�����������ݿ�
		sqlPath = "/images/" + filename;
		goods.setId(id);
		goods.setL_name(l_name);
		goods.setL_price(l_price);
		goods.setL_info(l_info);
		goods.setL_out_time(l_out_time);
		goods.setL_in_time(l_in_time);
		goods.setL_addr(l_addr);
		goods.setL_image(sqlPath);
		goodsService.updatemygoods(goods);
		return "mygoods";
	}

	@RequestMapping(value = "/mygoods.action")
	public String person() {
		return "mygoods";
	}

	@RequestMapping(value = "/My_purchases.action")
	public String My_purchases() {
		return "My_purchases";
	}
	@RequestMapping(value = "/Edit_Per_goods.action")
	public String Edit_Per_goods() {
		return "Edit_Per_goods";
	}

	// չʾ��Ʒ��Ϣ�ķ���
	@RequestMapping(value = "/commodity_information.action")
	public String commodity_information(Integer id, HttpSession session) {
		Goods goods = goodsService.findThegoods(id);
		session.setAttribute("GOODS_SESSION", goods);
		return "commodity_information";
	}
}
