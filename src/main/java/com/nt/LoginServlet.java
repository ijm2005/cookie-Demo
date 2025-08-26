package com.nt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		if(uname.equals(pwd)) {
			//valid user
			Cookie ck1 = new Cookie("role", "HR");
			Cookie ck2 = new Cookie("user", uname);
			
			res.addCookie(ck1);
			res.addCookie(ck2);
			RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
			rd.forward(req, res);
		}else {
			//invalid user
			req.setAttribute("errorMsg", "invalid username or password");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}

	}
}
