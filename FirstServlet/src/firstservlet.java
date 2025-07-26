

import javax.servlet.*;
import javax.servlet.http;

import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, java.io.InvalidObjectException {
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello, Java Servlets");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}