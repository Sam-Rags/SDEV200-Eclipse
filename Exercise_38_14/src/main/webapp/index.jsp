<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Random" %>

<% Random random = new Random();%>
<% int[] num1Arr = new int[5]; 
   int[] num2Arr = new int[5];%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition Quiz</title>
</head>
<body>
<form action="Result.jsp" method="POST">
<% 
for (int i = 0; i < 10; i++) {
%>
<% int number1 = random.nextInt(100); 
	int number2 = random.nextInt(100);
	
	%>
<label><%= number1 %> + <%= number2 %></label>
<input type="text" name="result_<%=i%>" />
<input type="hidden" name=num1Array value=<%= number1 %> />
<input type="hidden" name=num2Array value=<%= number2 %> />
<br>
<%}%>
<br>
<input type="submit" value="Submit">
</form>
<p>Click the browser's Refresh button (F5) to get a new quiz</p>
</body>
</html>