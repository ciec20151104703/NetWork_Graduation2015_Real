package com.bs.sxd.service;
import com.bs.common.utils.Page;
import com.bs.sxd.po.Evaluation;
/**
 * Service �ӿ�
 * 
 * @author ��ѩ��
 *
 */
public interface EvaluationService {
    //�������
	public void addReview(Evaluation eval);
    //��ҳ��ѯ������Ϣ
	public Page<Evaluation> findeval_List(Integer page, Integer rows_p, Integer l_id);
}
