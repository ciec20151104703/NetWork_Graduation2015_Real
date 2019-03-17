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
	public Page<Goods> findGoods_yList(Integer page, Integer rows, Integer l_price, String l_name, String l_info,
			String l_image) {
		Goods goods = new Goods();
		// ��ǰҳ
		goods.setStart((page - 1) * rows);
		// ÿҳ��
		goods.setRows(rows);
		List<Goods> good = goodsDao.findGoods_yList(goods);
		// ����Page���ض���
				Page<Goods> result = new Page<Goods>();
				result.setPage(page);
				result.setRows(good);
				result.setSize(rows);
				return result;
	}

}
