package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Todo;
import model.UpdateLogic;

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
		String su=request.getParameter("status");
		int number=Integer.parseInt(su);
		
		
		
		
		
		
		Todo todo= new Todo();
		todo.setContents(Contents);
		todo.setLimitDay(limitDay);
		todo.setNumbers(Numbers);
		
		
		HttpSession session=request.getSession();
		
		
		//セッションスコープのtodo管理用リスト引継ぎ
		List<Todo> todoList= (ArrayList<Todo>)session.getAttribute("todoList");
		if(todoList==null) {
			//複数管理用todoリスト
			todoList=new ArrayList<Todo>();
			
		}else {
			//リストの1件分のデータを変更
			int status=number-1;
			UpdateLogic UpdateLogic=new UpdateLogic();
			UpdateLogic.execute(todoList,status, todo);
		}
		session.setAttribute("todoList", todoList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
