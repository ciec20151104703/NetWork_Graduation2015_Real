package com.qst.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.qst.bean.UserBean;
import com.qst.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 用户登录
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		UserDao userdao = new UserDao();
		boolean rs = userdao.login(username, pwd);
		if (rs) {			
			// 显示天气信息
			String qx = userdao.permission(username, pwd);
			Weather weather = new Weather();
			weather.doGet(request, response);
			session.setAttribute("user", username);
			session.setAttribute("pwd", pwd);
			// 查看权限
			if (qx.equals("0")) {
				// 普通用户
				request.getRequestDispatcher("general-jsp/general-index.jsp").forward(request, response);
			} else if (qx.equals("1")) {
				// 记录员用户
				request.getRequestDispatcher("recorder-jsp/recorder-index.jsp").forward(request, response);
			} else if (qx.equals("2")) {
				// 管理员用户
				request.getRequestDispatcher("admin-jsp/admin-index.jsp").forward(request, response);
			} else {
				// 受限制用户，或出错用户
				JOptionPane.showMessageDialog(null, "你的账户被限制了，请联系管理员", "出错了", JOptionPane.ERROR_MESSAGE);
				response.sendRedirect("Login.jsp");
			}
		} else {

			JOptionPane.showMessageDialog(null, "你的用户名密码有误，请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
