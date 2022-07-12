package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[]todoList= {"Linuxテスト対策","paiza","TODOアプリ作成","履歴書作成"};
		//内容
		int index=(int)(Math.random()*4);
		String todo=todoList[index];
		
		//重要度
		int priority=index+1;
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日");
		String limitDay=sdf.format(date);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>TODOアプリ出力画面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p><h1>TODOアプリケーション</h1></p>");
		out.println("<p><h2>桑山慎之助のTODOリスト</h2></p>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<td>NO</td><td>重要度</td><td>内容</td><td>期日</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>1</td><td>"+priority+"</td><td>"+todo+"</td><td>"+limitDay+"</td>");
		out.println("</table>");
		out.println("</tr>");
		out.println("</body>");
		out.println("</html>");
	}

}
