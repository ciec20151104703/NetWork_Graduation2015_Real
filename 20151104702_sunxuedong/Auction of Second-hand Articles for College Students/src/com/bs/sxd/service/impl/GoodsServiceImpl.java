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
	// ע��UserDao
	@Autowired
	private GoodsDao goodsDao;
	@Override
	public void addGoods(Goods goods) {
		goodsDao.addGoods(goods);
	}
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
}
