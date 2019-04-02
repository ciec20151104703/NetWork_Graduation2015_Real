package com.bs.sxd.service;
import java.util.List;
import com.bs.common.utils.Page;
import com.bs.sxd.po.Goods;
/**
 * Service 接口
 * 
 * @author 孙雪冬
 *
 */
public interface GoodsService {
	// 增加商品
	public void addGoods(Goods goods);
	// 查询商品
	public Page<Goods> findGoods_yList(Integer page, Integer rows, Integer l_static, String l_name, String l_type);
    //下架商品
	public void updategoodstype_n(Goods goods);
    //删除商品
	public void deletegoods(Integer id);
    //用于显示购买界面商品信息
	public Goods findThegoods(Integer id);
	//用于用户查询自己的商品
	public Page<Goods> findGoods_uList(Integer page, Integer rows, Integer l_static, String l_name, String l_type,
			Integer u_id);
}
