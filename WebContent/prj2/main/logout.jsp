<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
session.removeAttribute("id");
session.invalidate(); 

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title></title>
<script type="text/javascript">

	alert("로그아웃되었습니다");
	
	location.href="main_all.jsp";
</script>
</head>
<body>
<div>

</div>
</body>
</html>