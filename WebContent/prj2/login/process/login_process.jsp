<%@page import="Member.MemberDAO"%>
<%@page import="Member.LoginVO"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
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

</head>
<body>
<div>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	pass=DataEncrypt.messageDigest("MD5", pass);
	
	LoginVO lVO = new LoginVO(id,pass);
	
	MemberDAO mDAO = new MemberDAO();
	
	boolean login = mDAO.selectLogin(lVO);
	
	String withdraw = mDAO.selectWithdraw(id);
	
	
	if(!login || withdraw.equals("Y")){	
%>
<script type="text/javascript">
	window.onload = function() {
		window.open("http://localhost/team_prj2/prj2/login/popup/fail.jsp"
				,"Fail","width = 640, height = 387, top ="+(window.sceenTop+100)+",left =" +(window.creenleft + 100));
		window.location = document.referrer;
}
</script>
<%
	}else{
		session.setMaxInactiveInterval(60*5);
		session.setAttribute("id", id);
	
		response.sendRedirect("../../main/main_all.jsp");
	}
%>

</div>
</body>
</html>