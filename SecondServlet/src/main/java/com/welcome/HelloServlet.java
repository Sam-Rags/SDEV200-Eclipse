package com.welcome;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        // Create the web servlet body that has a form for taking the user input
        out.print("<html><body>");
        out.print("<h2>Compute Loan Payment</h2>");
        out.print("<form action=HelloServlet method='post'>");
        out.print("<label>Loan Amount: </label><input name='amount'><br>");
        out.print("<label>Annual Interest Rate: </label><input name='rate'><br>");
        out.print("<label>Number of Years: </label><input name='years'><br>");
        out.print("<input type=submit value=Submit>");
        out.print("<input type=reset value=reset>");
        out.print("</form>");
        out.print("</body></html>");
        
        // instantiates variables that are the parameters from the form
		double rate = Double.parseDouble(request.getParameter("rate"));
		int years = Integer.parseInt(request.getParameter("years"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		// creates a loan object and passes it to the session with the supplied user inputs
		Loan loan = new Loan(rate, years, amount);
		HttpSession session = request.getSession();
		session.setAttribute("loanObject", loan);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		double rate = Double.parseDouble(request.getParameter("rate"));
		int years = Integer.parseInt(request.getParameter("years"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		
		
		Loan loan = new Loan(rate, years, amount);
		HttpSession session = request.getSession();
		session.setAttribute("loanObject", loan);
		// Pushes the request to the "Action" servlet's doGet method
		RequestDispatcher dispatcher = request.getRequestDispatcher("Action");
		dispatcher.forward(request, response);
		response.sendRedirect("Action");
	}

}


