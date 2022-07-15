package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String errorMsg="";
		
		
		if(name == null || name.equals("") ) {
			errorMsg+="ユーザ名が入力されていません<br>";
		}
		if(pass==null || pass.equals("")) {
			errorMsg+="パスワードが入力されていません<br>";
		}
		if(errorMsg.length() != 0) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		User user=new User(name,pass);
		
		LoginLogic loginLogic=new LoginLogic();
		boolean isLogin=loginLogic.execute(user);
		
		if(isLogin) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", user);
		}else {
			errorMsg="ユーザ名又は、パスワードに誤りがあります<br>";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

}
