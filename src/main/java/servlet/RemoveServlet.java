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

import model.RemoveLogic;
import model.Todo;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String su=request.getParameter("no");
		int no=Integer.parseInt(su);
		HttpSession session=request.getSession();
		String errorMsg="";
		//セッションスコープのtodo管理用リスト引継ぎ
		List<Todo> todoList= (ArrayList<Todo>)session.getAttribute("todoList");
		
		if(todoList==null) {
			//複数管理用todoリスト
			todoList=new ArrayList<Todo>();
			
		}
		//List<Todo> todoList=(ArrayList<Todo>)session.getAttribute("no");
		int number=no-1;
		RemoveLogic removeLogic=new RemoveLogic();
		removeLogic.execute(todoList,number);
		//session.removeAttribute(no);
		
		
		if(errorMsg.length() != 0) {
			request.setAttribute("msg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//セッションスコープにtodoを設定
		
		session.setAttribute("todoList", todoList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
