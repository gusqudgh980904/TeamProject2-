<%@page import="LookBook.LBDAO"%>
<%@page import="LookBook.LBWriteVO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)session.getAttribute("id");
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
	/*String userid */ //이용자(session)
	String title=request.getParameter("title");//제목
	String content=request.getParameter("editordata");//내용(이미지)
	
	Calendar cal = Calendar.getInstance(); //글작성일자
	String writeDate = String.valueOf(cal.get(Calendar.YEAR))+"-"+String.valueOf(cal.get(Calendar.MONTH)+1)+"-"+String.valueOf(cal.get(Calendar.DATE));
	
	LBWriteVO lbwVO = new LBWriteVO(userId,title,content,writeDate);
	
	LBDAO lbDAO = new LBDAO();
	lbDAO.insertPost(lbwVO);
	
	response.sendRedirect("../lookbook_main.jsp");	
%>

</div>
</body>
</html>