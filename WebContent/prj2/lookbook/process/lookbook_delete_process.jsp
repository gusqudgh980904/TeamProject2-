<%@page import="LookBook.LBDAO"%>
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
	String num = (String)session.getAttribute("num");
	int lbNum = Integer.parseInt(num);
	
	LBDAO lbDAO = new LBDAO();
	boolean deleteFlag = lbDAO.deletePost(lbNum);
	
	if(deleteFlag){
%>
<script type="text/javascript">
	window.onload = function() {
		window.open("http://localhost/team_prj2/prj2/lookbook/popup/message_delete2.jsp", 
				"revise", "width=650, height=200, top="+(window.screenTop+350)+", left="+(window.screenLeft+600));
		
	}
</script>
<%
	}else{
%>
게시글 삭제에 실패하였습니다.
잠시 후 이용해주세요 죄송합니다.
<%		
	}
%>
</div>
</body>
</html>