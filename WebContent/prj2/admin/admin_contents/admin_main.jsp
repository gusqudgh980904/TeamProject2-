<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상품관리</title>

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
.title{
	margin-top : 20px;
	z-index: 1;
}

.navigation {
	margin-left : 10px;
}
#headerTitle {
	margin-top : 100px;
	margin-left : 300px;
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


</style>
<script type="text/javascript">

</script>
</head>
<body>
<!-- header start -->
    <header class="header">
        <div class="main_nav">
            <div>
                <h1 class="title"><a href="#"><img src="http://localhost/team_prj2/common/images/%EC%83%81%ED%95%98%EC%9D%98%EC%8A%A4%ED%8A%B8%EB%A6%BF.png"></a></h1>
                <ul class="navigation">
                   <li> <a href="http://localhost/team_prj2/prj2/main/main_all.jsp" style="color: black">메인홈</a></li>
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
			<a href="http://localhost/team_prj2/prj2/admin/admin_product/add.jsp"><input type="button" value="상품추가" class=" btn btn-group-lg" style="position:relative;left:1100px;top:140px;"/></a>
			<h1 id="headerTitle">SANGHAUI STREET ADMINISTRATOR</h1>
			<table class="table table-bordered" style="width:1200px;height:500px;position:relative;left:20px;top:80px;">
				<tr>
				<%
				request.setCharacterEncoding("UTF-8");
				String prod_name=request.getParameter("prod_name");
				String price=request.getParameter("price");
				String prod_detail=request.getParameter("prod_detail");
				%>
					<th>상품번호</th>			
					<th>이미지</th>			
					<th>상품명</th>			
					<th>가격</th>			
					<th>상품설명</th>			
				</tr>
				<tr>
					<td><a href="http://localhost/team_prj2/prj2/admin/admin_product/modify&remove.jsp?">00001</a></td>
					<td>img</td>
					<td><%=prod_name %></td>
					<td><%=price %></td>
					<td><%=prod_detail %></td>
				</tr>
				<tr>
					<td>00002</td>
					<td>img</td>
					<td>하의</td>
					<td>90000원</td>
					<td>저쩌구</td>
				</tr>
				<tr>
					<td>00002</td>
					<td>img</td>
					<td>하의</td>
					<td>90000원</td>
					<td>저쩌구</td>
				</tr>
				<tr>
					<td>00002</td>
					<td>img</td>
					<td>하의</td>
					<td>90000원</td>
					<td>저쩌구</td>
				</tr>
				<tr>
					<td>00002</td>
					<td>img</td>
					<td>하의</td>
					<td>90000원</td>
					<td>저쩌구</td>
				</tr>
				<tr>
					<td>00002</td>
					<td>img</td>
					<td>하의</td>
					<td>90000원</td>
					<td>저쩌구</td>
				</tr>
			</table>
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