package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Todo;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Numbers = request.getParameter("Numbers");
		String Contents = request.getParameter("Contents");
		String limitDay = request.getParameter("limitDay");
		String errorMsg="";
		
		HttpSession session=request.getSession();
		Todo todo=(Todo)session.getAttribute("todo");
		try {
			if (Numbers.length() != 0) {
				todo.setNumbers(Numbers);
			}
			if (Contents.length() != 0) {
				todo.setContents(Contents);
			}
			if (limitDay.length() != 0) {
				todo.setLimitDay(limitDay);
			}
		}catch(NullPointerException e) {
			errorMsg+="変更する項目がありません<br>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}

		
		if(Contents==null || Contents.length()==0) {
			todo.getContents();
		}
		if(limitDay==null || limitDay.length()==0) {
			todo.getLimitDay();
		}
		request.setAttribute("msg", errorMsg);
		
		if(errorMsg.length() != 0) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		session.setAttribute("todo", todo);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
