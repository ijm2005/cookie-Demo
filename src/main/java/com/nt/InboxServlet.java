package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.UserDataHandler;

public class InboxServlet  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie[] ck = req.getCookies();
		String loginUsername = null;
		if(ck != null) {
			for(Cookie c: ck) {
				String key  = c.getName();
				if(key.equals("uname")) {
					loginUsername = c.getValue();
				}
			}
		}
		
		if(loginUsername == null || loginUsername == "") {
			//no cookie
			req.setAttribute("errorMsg", "please login first");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}else {
			req.setAttribute("user", loginUsername);
			RequestDispatcher rd = req.getRequestDispatcher("inbox.jsp");
			rd.forward(req, res);
		}
		
	}
}