package com.qst.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qst.dao.BaseDao;
import com.qst.dao.TmbuyDao;
import com.qst.bean.TmbuyBean;

/*
 * @ Copyright (c) Create by JASON  Date:2018-02-10  All rights reserved.
 *
 * @ class description对推荐表的操作类
 *
 */
public class TmbuyDaoimp extends BaseDao implements TmbuyDao {

	@Override
	//获取所有推荐信息
	public List<TmbuyBean> getAllTmbuy() {
		List<TmbuyBean> list = new ArrayList<TmbuyBean>();
		String sql = "select * from buytm ";
		Object[] params = {};
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while (rs.next()) {
				TmbuyBean tm = new TmbuyBean();
				tm.setTmname(rs.getString("tmname"));
				tm.setTmnum(rs.getString("tmname"));
				tm.setTmprice(rs.getString("tmprice"));
				tm.setPhoname(rs.getString("phoname"));
				list.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	//获取指定推荐商品信息
	public TmbuyBean getTmbuyMoreInfo(TmbuyBean tm) {
		TmbuyBean tmbuy = new TmbuyBean();
		String sql = "select * from buytm where `tmid`=?";
		Object[] params = { tm.getTmid() };
		ResultSet rs = this.executeQuerySQL(sql, params);
		try {
			while (rs.next()) {
				
				tm.setTmname(rs.getString("tmname"));
				tm.setTmnum(rs.getString("tmnum"));
				tm.setTmprice(rs.getString("tmprice"));
				tm.setPhoname(rs.getString("phoname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tm;
	}

	@Override
	//添加商品信息
	public int addTmbuy(TmbuyBean tm) {
		int row = 0;
		String sql = "insert into buytm(`tmname`,`tmnum`,`tmprice`,`pho`,`phoname`) values(?,?,?,?,?)";
		Object[] params = {tm.getTmname(),tm.getTmnum(),tm.getTmprice(),tm.getPho(),tm.getPhoname()};
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
	public int delTmbuy(TmbuyBean tm) {
		int row = 0;
		String sql = "delete from Buytm where `tmid`=?";
		Object[] params = {tm.getTmid()};
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
	public int modifyTmbuy(TmbuyBean tm) {
		int row = 0;
		String sql = "update buytm set tmname=?,tmnum=?,tmprice=? where tmid=?";
		Object[] params = {tm.getTmid(),tm.getTmname(),tm.getTmnum(),tm.getTmprice()};
		System.out.println(tm.getTmname());
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("修改商品信息成功");
		}else{
			System.out.println("修改商品信息失败");
		}
		
		return row;
	}
	
	
	//查询商品信息
	public boolean findTmbuy(TmbuyBean tm){
		boolean flag = true;
		int row = 0;
		String sql = "select count(1) from buytm where  `tmname`=? and `tmnum`=? and `tmprice`=? ";
		Object[] params = {tm.getTmname(),tm.getTmnum(),tm.getTmprice()};
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
	public int delTmbuy1(TmbuyBean tm) {
		// TODO Auto-generated method stub
		return 0;
	}
}

