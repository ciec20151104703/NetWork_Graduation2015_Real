package com.qst.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qst.dao.BaseDao;
import com.qst.dao.RecommendDao;
import com.qst.bean.RecommendBean;

/*
 * @ Copyright (c) Create by JASON  Date:2018-02-10  All rights reserved.
 *
 * @ class description对推荐表的操作类
 *
 */
public class RecommendDaoimp extends BaseDao implements RecommendDao {

	@Override
	//获取所有推荐信息
	public List<RecommendBean> getAllRecommend() {
		List<RecommendBean> list = new ArrayList<RecommendBean>();
		String sql = "select * from Recommend ";
		Object[] params = {};
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while (rs.next()) {
				RecommendBean rec = new RecommendBean();
				rec.setComid(rs.getInt("comid"));
				rec.setComname(rs.getString("comname"));
				rec.setPrice(rs.getString("price"));
				rec.setPhotoname(rs.getString("photoname"));
				list.add(rec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	//获取指定推荐商品信息
	public RecommendBean getRecommendMoreInfo(RecommendBean rec) {
		RecommendBean recommend = new RecommendBean();
		String sql = "select * from Recommend where `comid`=?";
		Object[] params = { rec.getComid() };
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while (rs.next()) {
				rec.setComname(rs.getString("comname"));
				rec.setPrice(rs.getString("price"));
				rec.setPhotoname(rs.getString("photoname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rec;
	}

	@Override
	//添加商品信息
	public int addRecommend(RecommendBean recommend) {
		int row = 0;
		System.out.println(recommend.getPrice()+"价格Reco");
		String sql = "insert into recommend(`comid`,`comname`,`price`,`photo`,`photoname`) values(?,?,?,?,?)";
		Object[] params = {recommend.getComid(),recommend.getComname(),recommend.getPrice(),recommend.getPhoto(),recommend.getPhotoname()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("添加商品信息成功");
		}else{
			System.out.println("添加商品信息失败");
		}
		return row;
	}

	@Override
	//删除商品信息
	public int delRecommend(RecommendBean rec) {
		int row = 0;
		String sql = "delete from recommend where `comid`=?";
		Object[] params = { rec.getComid()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("success");
		}else{
			System.out.println("erro");
		}
		return row;
	}

	@Override
	//修改商品信息
	public int modifyRecommend(RecommendBean rec) {
		int row = 0;
		String sql = "update recommend set comname=?,price=?,photoname=? where comid=?";
		Object[] params = {rec.getComname(),rec.getPrice(),rec.getPhotoname(),rec.getComid()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("修改商品信息成功");
		}else{
			System.out.println("修改商品信息失败");
		}
		
		return row;
	}
	
	
	//查询商品信息
	public boolean findRecommend(RecommendBean rec){
		boolean flag = true;
		int row = 0;
		String sql = "select count(1) from Recommend where  `Comname`=? and `price`=? and `photoname`=?" ;
		Object[] params = {rec.getComname(),rec.getPrice(),rec.getPhotoname()};
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(row>0){
			System.out.println("查询商品信息成功");
			flag = true;
		}else{
			System.out.println("查询商品信息失败");
			flag = false;
		}
		
		return flag;
		
	}

	@Override
	public int delRecommendt(RecommendBean recommend) {
		// TODO Auto-generated method stub
		return 0;
	}
}

