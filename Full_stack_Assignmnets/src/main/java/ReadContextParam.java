

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadContextParam
 */
public class ReadContextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para = (String) getServletContext().getInitParameter("Jayesh");
		PrintWriter pq=response.getWriter();
//		pq.println("<script>");
//		pq.println("Window.alert(");
		pq.println("Reading context parameter:"+para);
//		pq.println(");");
//		pq.println("</script>");
	}

	
	
}
