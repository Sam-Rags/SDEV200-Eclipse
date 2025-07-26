package com.welcome;


public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	
	// No arg constructor
	public Loan() {
		this.loanAmount = loanAmount;
	}
	
	// Construct a loan with specified annual interest, number of years & loan amount
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}
	
	// Return annualInterestRate
	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	// set a new annualInterestRate
	public void setAnnualInterestRate(double AnnualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	// return numberOfYears
	public int getNumberOfYears() {
		return numberOfYears;
	}
	
	// set a new number of years
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	
	// return loan amount
	public double getLoanAmount() {
		return loanAmount;
	}
	
	// set a new monthly payment
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	// Find monthly payment
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 
				(1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}
	
	// Find total payment
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
	
	// Return Loan date
	public java.util.Date getLoanDate() {
		return loanDate;
	}
	
}
