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
 * Servlet implementation class InputServlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Numbers=request.getParameter ("Numbers");
		String Contents=request.getParameter("Contents");
		String limitDay=request.getParameter("limitDay");
		String errorMsg="";
		
		if(Numbers == null || Numbers.length() == 0) {
			errorMsg +="重要度が選択されていません<br>";
		}
		if(Contents==null || Contents.length()==0) {
			errorMsg+="内容が入力されていません<br>";
		}
		if(limitDay==null || limitDay.length()==0) {
			errorMsg+="期日が入力されていません<br>";
		}
		Todo todo=new Todo();
		todo.setNumbers(Numbers);
		todo.setContents(Contents);
		todo.setLimitDay(limitDay);
		request.setAttribute("msg", errorMsg);
		
		HttpSession session=request.getSession();
		session.setAttribute("todo", todo);
		
		if(errorMsg.length() != 0) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
