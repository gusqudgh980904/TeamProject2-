<%@page import="Admin.AdminUsersOneVO"%>
<%@page import="Admin.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원상세정보</title>

<!-- css -->
<link href="http://localhost/team_prj2/common/css/yl_main.css" rel="stylesheet" >
<link href="http://localhost/team_prj2/common/css/main.css" rel="stylesheet" >

<!-- bootstrap -->
<link href="http://localhost/team_prj2/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/team_prj2/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
.header{
	z-index: 1;
}


.navigation {
	margin-left : 10px;
	z-index: 1;
}
#headerTitle {
	margin-top : 20px;
	margin-left : 400px;
}

#wrap {
	width: 1250px;
	height: 900px;
	margin: 0px auto;
	background-color: #dfdfdf;
}

td {
	text-align: center;
}

th {
	text-align: center;
	background-color: #909090
}
/* container시작 */
#container{
	margin-top: 100px;
	width:1600px;
	height:800px;
	float:right;
	}
/* container끝 */
td,th{text-align:center;}

#title{
	margin-left: 400px;
}
td{text-align:center;width:600px;}
th{text-align:center;width:600px;background-color:#909090}
/* 상세정보 */
#details{width:1200px;height:600px;position:relative;top:20px;left:20px; margin-left: 380px;}

</style>
<script type="text/javascript">
function remove(){
	window.open("http://localhost/team_prj2/prj2/admin/popup/user_delete.jsp","remove","width=650,height=380px")
}//confirm
</script>
</head>
<body>
<!-- header start -->
    <header class="header">
        <div class="main_nav">
            <div>
                <h1 class="title"><a href="#"><img src="http://localhost/team_prj2/common/images/%EC%83%81%ED%95%98%EC%9D%98%EC%8A%A4%ED%8A%B8%EB%A6%BF.png"></a></h1>
                <ul class="navigation">
      				  <li> <a href="" style="color: black">메인홈</a></li>
                  	<li><a href="http://localhost/team_prj2/prj2/admin/admin_contents/admin_users.jsp" style="color: black">회원목록</a></li>
                    <li><a href="http://localhost/team_prj2/prj2/admin/admin_contents/admin_lookbooks.jsp" style="color: black">게시판목록</a></li>
                    <li><a href="http://localhost/team_prj2/prj2/admin/admin_contents/admin_main.jsp" style="color: black">상품관리</a></li>
                </ul>
                
            </div>
        </div>
    </header>
    <!-- header end -->
<div id="wrap">
	<div id="container">
				<%
				AdminDAO aDAO=new AdminDAO();
				String member_id=request.getParameter("member_id");
				
				AdminUsersOneVO auoVO=aDAO.selectUserOne(member_id);
				
				%>
	<h1 id="headerTitle">SANGHAUI STREET ADMINISTRATOR</h1>
		<h1 id="title" ><%=auoVO.getMember_id() %>님 회원정보</h1>
				<table class="table table-bordered" id="details">
				<tr>
					<th>아이디</th><td><%=auoVO.getMember_id() %></td>
				</tr>
				<tr>
					<th>이름</th><td><%=auoVO.getMember_name() %></td>
				</tr>
				<tr>
					<th>성별</th><td><%=auoVO.getMember_gender() %></td>
				</tr>
				<tr>
					<th>생년월일</th><td><%=auoVO.getMember_birth() %></td>
				</tr>
				<tr>
					<th>연락처</th><td><%=auoVO.getMember_phone() %></td>
				</tr>
				<tr>
					<th>이메일</th><td><%=auoVO.getMember_email() %></td>
				</tr>
				<tr>
					<th>우편번호</th><td><%=auoVO.getMember_zipcode() %></td>
				</tr>
				<tr>
					<th>상세주소</th><td><%=auoVO.getMember_detailedAddr() %></td>
				</tr>
				<tr>
					<th>가입날짜</th><td><%=auoVO.getMember_signDate() %></td>
				</tr>
				<tr>
					<th>탈퇴여부</th><td><%=auoVO.getMember_withdrawal() %></td>
				</tr>
				
				</table>
			
			<input type="button" value="탈퇴" class="btn btn-primary" style="position:relative;left:1500px;top:20px" onclick="remove()"/>
	</div>
</div>
 <!-- footer start -->
    <footer>
        <div class="footer-wrap">
            <div class="footer-content">
                <h2>ABOUT SANGHAUI</h2>
                <p>
                    상하의스트릿 공식 온라인스토어는 ㈜쌍용교육센터의 콘텐츠를 위임받아 운영하고 있습니다. <br/>
                    상하의스트릿 공식 온라인 스토어에서 사용하는 인증 마크를 훼손 또는 무단복제하여 사용할 수 없으며, <br/>
                    해당 콘텐츠의 소유권은 SANGHAUI STREET ㈜쌍용교육센터에 있습니다.<br/>
					Copyright © sanghaui street. All rights reserved.
                </p>
            </div>
            <div class="footer-content">
                <h2>CS CENTER</h2>
                <ul>
                    <li>업무시간 10:00 - 17:00</li>
                    <li>점심시간 12:00 - 13:00</li>
                    <li>휴무 토요일,일요일,공휴일</li>
                    <li>현금 등으로 결제시 저희 쇼핑몰이 가입한</li>
                    <li>PG에스크로 구매안전 서비스를 이용하실 수 있습니다</li>
                </ul>
            </div>
            <div class="footer-content">
                <h2>OUR COMPANY</h2>
                <ul>
                    <li>회사명 : (주)쌍용교육센터</li>
                    <li>사업자등록번호 : 2148529296</li>
                    <li>통신판매업 신고 : 제 2021-서울쌍용-3333호</li>
                    <li>주소 : 서울특별시 강남구 테헤란로 132(역삼동) </li>
                    <li>한독약품빌딩 8층 쌍용교육센터</li>
                </ul>
            </div>
        </div>
    </footer>
    <!-- footer end -->
</body>
</html>