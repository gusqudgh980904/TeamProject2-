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
<link href="http://localhost/team_prj2/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/team_prj2/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
	.wrap{width:620px; height: 360px; margin: 10px; padding: 40px 20px; box-sizing: border-box; border: 1px solid #d7d7d7; text-align: center;}
	#header{width: 577px; height: 172}
	.text{width: 300px; height: 50px; margin-right: 10px; font-size: 20px}
	#inputDiv{height: 50px; display: flex; justify-content: center; }
	
	h2{font-size: 35px; color: #222;}
	p{margin: 20px 0; font-size: 16px; color: #666;}
	span{font-weight: 300;}
</style>
<script type="text/javascript">
	function idCheck(){
		var obj =  document.checkFrm;
		var idCheck = obj.checkTx.value;
		var pObj = opener.window.document.joinFrm
		
		
		if(idCheck == ""){
			alert("아이디를 입력해주세요.");			
			return; 
		}
		
		obj.submit(); 
		
		
		}
	
	function useId( id ){
		opener.window.document.joinFrm.id.value = id;
		self.close();
		
	}
	
</script>
</head>
<body>
<div class = "wrap">
	<div id="header">
		<form action="id_check.jsp" name = "checkFrm" id="checkFrm" method="post">
			<h2>ID CHECK<span> 아이디 중복확인</span></h2>
			<p>사용하고자 하는 아이디를 입력해주세요.<br/>
			아이디 중복확인 후 사용 가능한 아이디로 선택하시면 됩니다.</p>
			<div id="inputDiv">
				<input type="text" name ="checkTx" id ="checkTx" class="form-control text" maxlength="16"/>
				<input type="button" value="ID 중복확인" name ="checkBt" id ="checkBt"  class="btn btn-default btn-lg" onclick="idCheck()"/>
			</div>
		</form>		
	<div>
	<%	
		String id = request.getParameter("checkTx"); 
	
		if( id != null ){
			MemberDAO mDAO = new MemberDAO();
			boolean idChk = mDAO.selectDupID(id); //아이디가 존재한 true | false
			
		if( idChk ){
	%>
		<%= id %>는 이미 존재하는 아이디 입니다. <Br/>
		 다른 아이디를 입력해주세요.
	<%
		}else{
	%>
		<%= id %>는 사용가능 합니다. 사용하시겠습니까?<a href="#void" onclick="useId('<%= id %>')"">사용</a>
	<%
			}
		 }//end if
	%>
	</div>
</div>
</div>
</body>
</html>