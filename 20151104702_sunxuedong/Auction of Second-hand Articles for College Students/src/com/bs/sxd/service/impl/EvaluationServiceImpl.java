package com.bs.sxd.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bs.common.utils.Page;
import com.bs.sxd.dao.EvaluationDao;
import com.bs.sxd.po.Evaluation;
import com.bs.sxd.service.EvaluationService;
/**
 * �û�Service�ӿ�ʵ����
 * 
 * @author ��ѩ��
 *
 */
@Service("evaluationService")
@Transactional
public class EvaluationServiceImpl implements EvaluationService {
	// ע��GoodsDao
	@Autowired
	private EvaluationDao evaluationDao;
	// ���������Ϣ
	@Override
	public void addReview(Evaluation eval) {
		evaluationDao.addReview(eval);
	}
	// ��ҳ��ѯ������Ϣ
	@Override
	public Page<Evaluation> findeval_List(Integer page, Integer rows_p, Integer l_id) {
		Evaluation eval = new Evaluation();
		// ��ǰҳ
		eval.setStart((page - 1) * rows_p);
		// ÿҳ��
		eval.setRows(rows_p);
		// ����������Ȼxml�ļ�ȡ����ֵ
		eval.setL_id(l_id);	
		List<Evaluation> evals = evaluationDao.findeval_List(eval);
		// ��ѯ��Ʒ�б��ܼ�¼��
		Integer count = evaluationDao.selectevalListCount(eval);
		// ����Page���ض���
		Page<Evaluation> result = new Page<Evaluation>();
		result.setPage(page);
		result.setRows_p(evals);
		result.setSize(rows_p);
		result.setTotal(count);
		return result;
	}
}
