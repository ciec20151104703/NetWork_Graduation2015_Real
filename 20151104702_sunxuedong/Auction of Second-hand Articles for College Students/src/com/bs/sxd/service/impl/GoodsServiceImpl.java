package com.bs.sxd.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bs.common.utils.Page;
import com.bs.sxd.dao.GoodsDao;
import com.bs.sxd.po.Goods;
import com.bs.sxd.service.GoodsService;
/**
 * �û�Service�ӿ�ʵ����
 * 
 * @author ��ѩ��
 *
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {
	// ע��GoodsDao
	@Autowired
	private GoodsDao goodsDao;
	@Override
	public void addGoods(Goods goods) {
		goodsDao.addGoods(goods);
	}
	//�û�����Ա/�û���ѯ������Ʒ
	@Override
	public Page<Goods> findGoods_yList(Integer page, Integer rows, Integer l_static, String l_name, String l_type) {
		Goods goods = new Goods();
		// ��ǰҳ
		goods.setStart((page - 1) * rows);
		// ÿҳ��
		goods.setRows(rows);
		//����������Ȼxml�ļ�ȡ����ֵ
		goods.setL_name(l_name);
		goods.setL_type(l_type);
		goods.setL_static(l_static);
		List<Goods> good = goodsDao.findGoods_yList(goods);
		// ��ѯ��Ʒ�б��ܼ�¼��
				Integer count = goodsDao.selectgoodsListCount(goods);	
		// ����Page���ض���
				Page<Goods> result = new Page<Goods>();	
				result.setPage(page);
				result.setRows(good);
				result.setSize(rows);
				result.setTotal(count);
				return result;
	}
	//�����û���ѯ������Ʒ
	@Override
	public Page<Goods> findGoods_uList(Integer page, Integer rows, Integer l_static, String l_name, String l_type,
			Integer u_id) {
		Goods goods = new Goods();
		// ��ǰҳ
		goods.setStart((page - 1) * rows);
		// ÿҳ��
		goods.setRows(rows);
		//����������Ȼxml�ļ�ȡ����ֵ
		goods.setL_name(l_name);
		goods.setL_type(l_type);
		goods.setL_static(l_static);
		goods.setU_id(u_id);
		List<Goods> good = goodsDao.findGoods_uList(goods);
		// ��ѯ��Ʒ�б��ܼ�¼��
				Integer count = goodsDao.selectgoodsList_uCount(goods);	
		// ����Page���ض���
				Page<Goods> result = new Page<Goods>();	
				result.setPage(page);
				result.setRows(good);
				result.setSize(rows);
				result.setTotal(count);
				return result;
	}	
	//�¼���Ʒ
	@Override
	public void updategoodstype_n(Goods goods) {
		goodsDao.updategoodstype_n(goods);	
	}
	//ɾ����Ʒ
	@Override
	public void deletegoods(Integer id) {
		goodsDao.deletegoods(id);	
	}
	  //������ʾ���������Ʒ��Ϣ
	@Override
	public Goods findThegoods(Integer id) {
		Goods goods = this.goodsDao.findThegoods(id);
		return goods;
	}
	//ɾ��������Ʒ
	@Override
	public void deletemygoods(Integer id) {
		goodsDao.deletemygoods(id);
		
	}
	//�޸ĸ�����Ʒ��Ϣ
	@Override
	public void updatemygoods(Goods goods) {
		goodsDao.updatemygoods(goods);
	}
	//�����Ʒ��Ϣ��������
	@Override
	public void addToPurchases(Goods pur) {
		goodsDao.addToPurchases(pur);
		
	}
	//����Ʒ��ӵ�������ͬʱ������Ʒ״̬
	@Override
	public void updategoodsstatic(Integer id) {
		goodsDao.updategoodsstatic(id);
		
	}
}
