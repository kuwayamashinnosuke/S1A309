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

import model.InputLogic;
import model.Todo;
import model.User;

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
		HttpSession session=request.getSession();
		User loginUser=(User)session.getAttribute("loginUser");
		if(loginUser !=null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
			
			return;
		}
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
		//セッションオブジェクトの取得
		HttpSession session=request.getSession();
		
		//セッションスコープのtodo管理用リスト引継ぎ
		List<Todo> todoList= (ArrayList<Todo>)session.getAttribute("todoList");
		
		if(errorMsg.length() != 0) {
			request.setAttribute("msg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if(todoList==null) {
			//複数管理用todoリスト
			todoList=new ArrayList<Todo>();
			
		}else {
			//リストに1件分のデータを追加
			InputLogic inputLogic=new InputLogic();
			inputLogic.execute(todoList, todo);
		}
		
		
		
		//セッションスコープにtodoを設定
		
		session.setAttribute("todoList", todoList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}

}
