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
//�¼���Ʒ
public void updategoodstype_n(Goods goods);
//ɾ����Ʒ
public void deletegoods(Integer id);
//������ʾ���������Ʒ��Ϣ
public Goods findThegoods(Integer id);
//���ڲ�ѯ������Ʒ
public List<Goods> findGoods_uList(Goods goods);
//���ڲ�ѯ������Ʒ����
public Integer selectgoodsList_uCount(Goods goods);
//ɾ��������Ʒ
public void deletemygoods(Integer id);
//�޸ĸ�����Ʒ��Ϣ
public void updatemygoods(Goods goods);
//�����Ʒ��Ϣ��������
public void addToPurchases(Goods pur);
//����Ʒ��ӵ�������ͬʱ������Ʒ״̬
public void updategoodsstatic(Integer id);
}
