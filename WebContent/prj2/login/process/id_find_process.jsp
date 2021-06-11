<%@page import="Member.SearchIdVO"%>
<%@page import="Member.IDFindVO"%>
<%@page import="Member.MemberDAO"%>

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
<script type="text/javascript">
	
</script>
</head>
<body>
<div>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	SearchIdVO sIVO = new SearchIdVO(name, email);

	MemberDAO mDAO = new MemberDAO();
	
	IDFindVO idFVO = mDAO.selectSearchID(sIVO);
	
	session.setMaxInactiveInterval(60*5);
	session.setAttribute("id", idFVO.getMember_id());
	session.setAttribute("signDate", idFVO.getMember_signDate());
	session.setAttribute("name", name);
		
	
%>
<script type="text/javascript">
	window.onload = function() {
		window.open("http://localhost/team_prj2/prj2/login/popup/id_find.jsp"
				,"Fail","width = 640, height = 387, top ="+(window.sceenTop+100)+",left =" +(window.creenleft + 100));
		window.location = document.referrer;
}
</script>


</div>
</body>
</html>