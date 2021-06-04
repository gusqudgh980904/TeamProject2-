<%@page import="java.sql.SQLException"%>
<%@page import="Member.MemberDAO"%>
<%@page import="Member.MemberVO"%>
<%@page import="java.util.Calendar"%>
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
<script type="text/javascript">

</script>
</head>
<body>
<div>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	int zipcode=Integer.parseInt(request.getParameter("zipcode")) ;
	String detailedAddr=request.getParameter("addr1");
	String addr=request.getParameter("addr2");
	String phone1=request.getParameter("phone1");
	String phone2=request.getParameter("phone2");
	String phone3=request.getParameter("phone3");
	String email =request.getParameter("email");
	String gender =request.getParameter("gender");
	String year =request.getParameter("year");
	String month =request.getParameter("month");
	String day =request.getParameter("day");
	
	String phone = phone1 + phone2 + phone3;
	String birth = year+month+day;
	String withdrawsal = "N";
	
	Calendar cal = Calendar.getInstance();
	String signDate = String.valueOf(cal.get(Calendar.YEAR))+"-"+String.valueOf(cal.get(Calendar.MONTH)+1)+"-"+String.valueOf(cal.get(Calendar.DATE)) ;
	
	pass = DataEncrypt.messageDigest("MD5", pass);
%>
	
<%
	
	MemberVO mVO = new MemberVO(id, pass, name, phone, email, zipcode, addr, detailedAddr, gender, birth, signDate, withdrawsal);

	MemberDAO mDAO = new MemberDAO();
	
	try{
		session.setMaxInactiveInterval(60*5);
		session.setAttribute("id", id);
		
		mDAO.insertMember(mVO);
		response.sendRedirect("../join_success.jsp");
		
	}catch(SQLException se){
		se.printStackTrace();
%>
		죄송합니다.<br/>
		회원가입에 문제가 발생하였습니다.<br/>
		잠시 후 다시해주세요.
<%
	}
%>

</div>
</body>
</html>