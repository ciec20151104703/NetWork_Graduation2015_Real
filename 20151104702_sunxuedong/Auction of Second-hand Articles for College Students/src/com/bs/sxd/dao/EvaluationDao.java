package com.bs.sxd.dao;

import java.util.List;

import com.bs.sxd.po.Evaluation;

public interface EvaluationDao {
   //�������
	public void addReview(Evaluation eval);
   //��ҳ��ѯ
	public List<Evaluation> findeval_List(Evaluation eval);
   //��ѯ������Ϣ������Ϊ��ҳ�ṩ����
	public Integer selectevalListCount(Evaluation eval);

}
