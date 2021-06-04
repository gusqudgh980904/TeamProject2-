<%@page import="Member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자 로그인 한 이후의 아이디 데이터를 필요한 페이지에서 사용하기 위한 공통 JSP
	String userId =(String)session.getAttribute("id");
	if(userId == null){  
		response.sendRedirect("http://localhost/team_prj2/prj2/login/login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=" UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

<!-- bootstrap -->
<link href="http://localhost/jsp_prj/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/jsp_prj/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
</head>
<body>
<div>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String pass = request.getParameter("pass");
	
	MemberDAO mDAO = new MemberDAO();
	
	int passCnt = mDAO.updatePassword(pass, userId);
	
	if(passCnt == 1){
%>
<script type="text/javascript">
	window.onload = function() {
		window.open("http://localhost/team_prj2/prj2/login/popup/member_update.jsp"
				,"update","width = 640, height = 387, top ="+(window.sceenTop+100)+",left =" +(window.creenleft + 100));
		window.location = document.referrer;
	}
</script>
<%
	}else{
%>
		죄송합니다.<br/>
		비밀번호수정에 문제가 발생하였습니다.<br/>
		잠시 후 다시해주세요.
<%
	}
%>	

</div>
</body>
</html>