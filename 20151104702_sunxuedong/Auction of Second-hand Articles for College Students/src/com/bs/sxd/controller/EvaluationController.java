package com.bs.sxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.common.utils.Page;
import com.bs.sxd.po.Evaluation;
import com.bs.sxd.po.Goods;
import com.bs.sxd.po.User;
import com.bs.sxd.service.EvaluationService;



/**
 * ���ۿ�������
 * 
 * @author ��ѩ��
 *
 */
@Controller
public class EvaluationController {
	// ����ע��
		@Autowired
		private EvaluationService evaluationService;
		// �����Ʒ������Ϣ
		@RequestMapping(value = "/addreview.action", method = RequestMethod.POST)
		public String evaluation(Evaluation eval, Integer l_id, String u_name, String email, String information,String p_time) {	
			l_id = Integer.valueOf(l_id).intValue();	
			eval.setL_id(l_id);
			eval.setU_name(u_name);
			eval.setEmail(email);
			eval.setInformation(information);
			eval.setP_time(p_time);
			evaluationService.addReview(eval);
			return "commodity_information";	
		}
		//��ҳ��ѯ������Ϣ
		@RequestMapping(value = "/findeval.action")
		public String list_eval(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows_p,
				Integer l_id, Model model) {
			l_id = Integer.valueOf(l_id).intValue();	
			Page<Evaluation> eval = evaluationService.findeval_List(page, rows_p, l_id);
			// ��Ӳ���
			model.addAttribute("page", eval);
			model.addAttribute("l_id", l_id);	
			return "evaluation";
		}
}
