package com.bs.sxd.service;
import com.bs.common.utils.Page;
import com.bs.sxd.po.Goods;
/**
 * Service �ӿ�
 * 
 * @author ��ѩ��
 *
 */
public interface GoodsService {
	// ������Ʒ
	public void addGoods(Goods goods);
	// ��ѯ��Ʒ
	public Page<Goods> findGoods_yList(Integer page, Integer rows, Integer l_static, String l_name, String l_type);
    //�¼���Ʒ
	public void updategoodstype_n(Goods goods);
    //ɾ����Ʒ
	public void deletegoods(Integer id);
    //������ʾ���������Ʒ��Ϣ
	public Goods findThegoods(Integer id);
	//�����û���ѯ�Լ�����Ʒ
	public Page<Goods> findGoods_uList(Integer page, Integer rows, Integer l_static, String l_name, String l_type,
			Integer u_id);
	//ɾ��������Ʒ
	public void deletemygoods(Integer id);
	//�޸ĸ�����Ʒ��Ϣ
	public void updatemygoods(Goods goods);
	//�����Ʒ��Ϣ��������
	public void addToPurchases(Goods pur);
	//����Ʒ��ӵ�������ͬʱ������Ʒ״̬
	public void updategoodsstatic(Integer id);
}
