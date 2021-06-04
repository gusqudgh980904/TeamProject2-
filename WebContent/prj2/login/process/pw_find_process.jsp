<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Random"%>
<%@page import="Member.SearchPwVO"%>
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
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	SearchPwVO sPVO = new SearchPwVO(id ,name, email);
	
	MemberDAO mDAO = new MemberDAO();
	
	boolean pwFlag = mDAO.selectSearchPW(sPVO);
		
%>

<%!
	/**
	 * 랜덤 비밀번호 생성
	 * @param pwFlag
	 * @return
	 * @throws SQLException
	 */
	public String TempraryPW(boolean pwFlag)throws SQLException{
	
		StringBuffer TempraryPW = new StringBuffer();
		
		if(pwFlag == true) {
	
		Random random = new Random();
	
		String chars[] = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");
	
		for (int i = 0; i < 4; i++) {
	
			TempraryPW.append(chars[random.nextInt(chars.length)]);
	
			}
		}
		return TempraryPW.toString();
}
%>
	
<%	
	if(pwFlag){
		String TempraryPW = TempraryPW(true);
		
		session.setMaxInactiveInterval(60*5);
		session.setAttribute("TempraryPW", TempraryPW);
		
		mDAO.updatePassword(TempraryPW,id);  
%>
<script type="text/javascript">
	window.onload = function() {
		window.open("http://localhost/team_prj2/prj2/login/popup/pw_find.jsp"
				,"Fail","width = 640, height = 387, top ="+(window.sceenTop+100)+",left =" +(window.creenleft + 100));
		window.location = document.referrer;
	}
</script>
<% 
	} else {
%>
<script type="text/javascript">
	window.onload = function() {
		window.open("http://localhost/team_prj2/prj2/login/popup/fail.jsp"
				,"Fail","width = 640, height = 387, top ="+(window.sceenTop+100)+",left =" +(window.creenleft + 100));
		window.location = document.referrer;
	}
</script>
<%
	}
%>
</div>
</body>
</html>