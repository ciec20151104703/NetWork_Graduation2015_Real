package com.bs.sxd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
