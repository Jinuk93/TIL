<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <%=request.getAttribute("r") %>입니다 -->
	${r} <!-- EL표기법으로 위와 같은 get=출력문 -->

	${names[0]} <br> <!-- EL표기법으로 배열에 담긴 변수를 꺼낼때 -->
	${names[1]} <br>
	${notice.title}

 	
 
</body>
</html>