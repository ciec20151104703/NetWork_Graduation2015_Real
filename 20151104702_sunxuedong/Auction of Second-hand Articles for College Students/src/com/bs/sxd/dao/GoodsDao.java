package com.bs.sxd.dao;

import java.util.List;


import com.bs.sxd.po.Goods;

public interface GoodsDao {
//�����Ʒ
 public void addGoods(Goods goods);
//��ѯ��Ʒ�б�
 public List<Goods>  findGoods_yList(Goods goods);
//����Ʒ��
public Integer selectgoodsListCount(Goods goods);
 
}
