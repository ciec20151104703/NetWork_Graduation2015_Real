package com.wgh.dao;

import commerce.member;
import com.wgh.DB.connDB;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.*;
import com.wgh.DB.chStr;

public class MemberDaoImpl implements MemberDao {
	private connDB conn = new connDB();

	// ִ�в������
	public int insert(member m) {
		chStr chStr = new chStr();
		int ret = -1;
		try {
			String sql = "Insert into tb_Member (UserName,TrueName,PassWord,City,address,postcode,CardNO,CardType,Tel,Email,question,answer) values('"
					+ chStr.chStr(m.getUsername())
					+ "','"
					+ chStr.chStr(m.getTruename())
					+ "','"
					+ chStr.chStr(m.getPwd())
					+ "','"
					+ chStr.chStr(m.getCity())
					+ "','"
					+ chStr.chStr(m.getAddress())
					+ "','"
					+ chStr.chStr(m.getPostcode())
					+ "','"
					+ chStr.chStr(m.getCardno())
					+ "','"
					+ chStr.chStr(m.getCardtype())
					+ "','"
					+ chStr.chStr(m.getTel())
					+ "','"
					+ chStr.chStr(m.getEmail())
					+ "','"
					+ chStr.chStr(m.getQuestion())
					+ "','"
					+ chStr.chStr(m.getAnswer()) + "')";
			ret = conn.executeUpdate(sql);
		} catch (Exception e) {
			ret = 0;
		}
		conn.close();
		return ret;
	}

	// ִ���޸Ĳ���
	public int update(member m) {
		int ret = -1;
		chStr chStr = new chStr();
		try {
			String sql = "update tb_member set TrueName='"
					+ chStr.chStr(m.getTruename()) + "',PassWord='"
					+ chStr.chStr(m.getPwd()) + "',City='"
					+ chStr.chStr(m.getCity()) + "',address='"
					+ chStr.chStr(m.getAddress()) + "',postcode='"
					+ chStr.chStr(m.getPostcode()) + "',CardNO='"
					+ chStr.chStr(m.getCardno()) + "',CardType='"
					+ chStr.chStr(m.getCardtype()) + "',Tel='"
					+ chStr.chStr(m.getTel()) + "',Email='"
					+ chStr.chStr(m.getEmail()) + "',question='"
					+ chStr.chStr(m.getQuestion()) + "',answer='"
					+ chStr.chStr(m.getAnswer()) + "' where ID=" + m.getID();
			ret = conn.executeUpdate(sql);
		} catch (Exception e) {
			ret = 0;
		}
		conn.close();
		return ret;
	}

	// ִ��ɾ������
	public int delete(member m) {
		String sql = "delect from tb_member where ID=" + m.getID();
		int ret = conn.executeUpdate(sql);
		conn.close();
		return 0;
	}

	// ִ�в�ѯ����
	public List select() {
		member form = null;
		List list = new ArrayList();
		String sql = "select * from tb_member";
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new member();
				form.setID(Integer.valueOf(rs.getString(1)));// �ѵ�һ������ǿ��ת������������
																// ��ΪID

				list.add(form); // ���������ӵ� List �Ľ�β��
			}
		} catch (SQLException ex) {
		}
		conn.close();
		return list;
	}

	public member select1() {
		return null;
	}
	
	
	// ִ���޸Ĳ���
	public int findPassWord(member m) {
		int ret = -1;
		chStr chStr = new chStr();
		try {
			String sql = "update tb_member set PassWord='888888' where username='"
					+ chStr.chStr(m.getUsername()) + "' and question='"
					+ chStr.chStr(m.getQuestion()) + "' and answer='"
					+ chStr.chStr(m.getAnswer()) + "'";
			ret = conn.executeUpdate(sql);
		} catch (Exception e) {
			ret = 0;
		}
		conn.close();
		return ret;
	}

}