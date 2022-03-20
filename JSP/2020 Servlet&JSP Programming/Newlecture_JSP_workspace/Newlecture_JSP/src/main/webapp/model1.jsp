<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = 0; //기본 deafult 따라서, deafault 출력은 "짝수입니다."이다."
	String num_ = request.getParameter("n");
	if(num_ != null && !num_.equals(""))
		num = Integer.parseInt(num_);
	
	String result;
	
	if(num%2 != 0)
		result = "홀수입니다";
	else 
		result = "짝수입니다";
	//if문에서 Java 코드라서 중괄호를 안써도된다. (?)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=result %>입니다
</body>
</html>