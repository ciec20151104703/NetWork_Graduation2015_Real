package com.bs.sxd.service;
import java.util.List;
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

	

}
