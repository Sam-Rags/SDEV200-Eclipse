package com.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Action
 */
@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creates the relevant outputs from the loan object in HelloServlet
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		Loan loan = (Loan) session.getAttribute("loanObject");
		PrintWriter out = response.getWriter();
		
		// Prints out the methods comprising the rate, years, loan amount & total
		out.print("<html><body>");
		out.print("<h2>Loan Terms</h2>");
		out.print("<p>Rate: " + loan.getAnnualInterestRate() + "%.</p>");
		out.print("<p>Loan term: " + loan.getNumberOfYears() + "</p>");
		out.print("<p>Loan amount: " + loan.getLoanAmount() + "</p>");
		out.print("<p>Monthly payment: " + loan.getMonthlyPayment() + "</p>");
		out.print("<p>Total Payment: " + loan.getTotalPayment() + "</p>");
		out.print("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
