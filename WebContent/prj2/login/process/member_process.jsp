<%@page import="Member.MemberDAO"%>
<%@page import="Member.MemberUpdateVO"%>
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
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	int zipcode =Integer.parseInt(request.getParameter("zipcode"));
	String detailedAddr = request.getParameter("addr1");
	String addr = request.getParameter("addr2");
	
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String phone = phone1 + phone2 + phone3;
	
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String birth = year+month+day;	
	
	MemberUpdateVO muVO = new MemberUpdateVO(id,name,phone,email,zipcode,addr,detailedAddr,gender,birth);
	
	MemberDAO mDAO = new MemberDAO();
	
	int cnt = mDAO.updateMember(muVO); 
	
	if(cnt == 1){
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
		정보수정에 문제가 발생하였습니다.<br/>
		잠시 후 다시해주세요.
<%
	}
%>




</div>
</body>
</html>