<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>

<%@ page import="java.util.Arrays" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition Quiz Answer</title>
</head>
<body>
<% 
String[] values1 = request.getParameterValues("num1Array");
String[] values2 = request.getParameterValues("num2Array");
int[] intArray1 = new int[values1.length];
int[] intArray2= new int[values2.length];
int correct = 0;

for (int i = 0; i < values1.length; i++) {
	intArray1[i] = Integer.parseInt(values1[i]);
}

for (int i = 0; i < values2.length; i++) {
	intArray2[i] = Integer.parseInt(values2[i]);
}
for (int i = 0; i < 10; i++) { %>
	<% String val = request.getParameter("result_" + i); 
	int num = Integer.parseInt(request.getParameter("result_"+i));
    int sum = intArray1[i] + intArray2[i];
    if (num == sum) {
		 correct++;
	 }
	 
	%>
	<p>
	
	 <%= intArray1[i] %> + <%= intArray2[i] %> = <%= num %>  
	 <span>
	 <%= (num == sum) ? "Correct" : "Wrong" %>
	 </span>
	 </p>
	 
	 <% } %> 
	 
	  <p>The total correct count is: <%= correct %> </p>

</body>
</html>