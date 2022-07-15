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
		String no = request.getParameter("no");
		String errorMsg="";
		
		HttpSession session=request.getSession();
		Todo todo=(Todo)session.getAttribute("todo");
		try {
			if (no.length() != 0) {
				todo.setNumbers(no);
			}else{
				errorMsg+="指定したNOがありません<br>";
			}
		}catch(NullPointerException e) {
			errorMsg+="指定したNOがありません<br>";
			request.setAttribute("msg", errorMsg);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		request.setAttribute("msg", errorMsg);
		
		session.removeAttribute("todo");
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
