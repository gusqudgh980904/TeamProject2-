<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상품 수정/삭제</title>

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
#title{
	margin-left: 400px;
}
th{text-align:center;width:100px;background-color:#909090}
td{text-align:center;width:300px;}
/* 상품이미지 */
#prodImg{width:500px;height:500px;position:relative;top:55px;left:400px; border: 1px solid #000000;}
/* 상품정보 */
#prodDetails{width:600px;height:500px;position:relative;left:650px;bottom:450px; margin-left: 350px;}
</style>
<script type="text/javascript">
function modify(){
	window.open("http://localhost/team_prj2/prj2/admin/popup/prod_modify.jsp","modify","width=650,height=380px")
}//remove

function remove(){
	window.open("http://localhost/team_prj2/prj2/admin/popup/prod_delete.jsp","remove","width=650,height=380px")
}//remove
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
	<h1 id="headerTitle">SANGHAUI STREET ADMINISTRATOR</h1>
		<h1 id="title" >상품 삭제/수정</h1>
						<div id="prodImg">
				상품이미지			
				</div>
				<table id="prodDetails" class="table table-bordered">
							<tr>
						<th>상품번호</th><td><input type="text"  class="form-control"autofocus="autofocus"/></td>				
					</tr>
					<tr>
						<th>상품명</th><td><input type="text"class="form-control" /></td>				
					</tr>
					<tr>
						<th>가격</th><td><input type="text"class="form-control" /></td>				
					</tr>
					<tr>
						<th>구분</th><td>TOP<input type="radio" name="category" value="상의"checked="checked"/><br/>
										BOTTOM<input type="radio" name="category" value="하의"/></td>				
					</tr>
					<tr>
						<th style="height:150px;">사이즈</th><td>S<input type="checkbox" name="size" value="s"checked="checked"/><br/>
																M<input type="checkbox" name="size" value="m"/><br/>
																L<input type="checkbox" name="size" value="l"/>
						</td>				
					</tr>
					<tr>
						<th>상품설명</th><td><input type="text"class="form-control"  /></td>				
					</tr>
				</table>
			
			<input type="button" value="수정" class=" btn btn-group-lg" style="position:relative;left:1380px;bottom:400px;"onclick="modify()"/>
			<input type="button" value="삭제" class=" btn btn-group-lg" style="position:relative;left:1400px;bottom:400px;"onclick="remove()"/>	
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