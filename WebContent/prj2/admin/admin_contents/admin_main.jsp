<%@page import="Product.ProductListAdminVO"%>
<%@page import="java.util.List"%>
<%@page import="Product.ProductAdminDAO"%>
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
	position:relative;
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
	height: 1200px;
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
<!-- 아이디받는 세션 없으면 이것또한 복붙 이건 위에 지시자 밑에 정의하믄댐-->
<%
	//사용자 로그인 한 이후의 아이디 데이터를 필요한 페이지에서 사용하기 위한 세션
	String userId = (String)session.getAttribute("id");
%>



<!-- logout메소드 복붙하세용 -->
<script type="text/javascript">
	function logout(){
	     if( confirm("정말 로그아웃 하시겠습니까?")){
	     	location.href="http://localhost/team_prj2/prj2/main/logout.jsp";
		}
	}
</script>



<body>
<!-- 헤더 복붙하세용 -->
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
            <ul class="icons">
                <li>
                    <p>login</p>
                    <%                    
                    if( userId == null  ){
                    %>
                    <a href="http://localhost/team_prj2/prj2/main/main_all.jsp">
                     <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                        viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" >
                            <path d="M437.02,330.98c-27.883-27.882-61.071-48.523-97.281-61.018C378.521,243.251,404,198.548,404,148
                                C404,66.393,337.607,0,256,0S108,66.393,108,148c0,50.548,25.479,95.251,64.262,121.962
                                c-36.21,12.495-69.398,33.136-97.281,61.018C26.629,379.333,0,443.62,0,512h40c0-119.103,96.897-216,216-216s216,96.897,216,216
                                h40C512,443.62,485.371,379.333,437.02,330.98z M256,256c-59.551,0-108-48.448-108-108S196.449,40,256,40
                                c59.551,0,108,48.448,108,108S315.551,256,256,256z" />
                    </svg>
                  </a>  
                    <%
                     	}else{
                     %>
                     <a href="#" onclick="javascript:logout();">
                      <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                        viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" >
                            <path d="M437.02,330.98c-27.883-27.882-61.071-48.523-97.281-61.018C378.521,243.251,404,198.548,404,148
                                C404,66.393,337.607,0,256,0S108,66.393,108,148c0,50.548,25.479,95.251,64.262,121.962
                                c-36.21,12.495-69.398,33.136-97.281,61.018C26.629,379.333,0,443.62,0,512h40c0-119.103,96.897-216,216-216s216,96.897,216,216
                                h40C512,443.62,485.371,379.333,437.02,330.98z M256,256c-59.551,0-108-48.448-108-108S196.449,40,256,40
                                c59.551,0,108,48.448,108,108S315.551,256,256,256z" />
                    </svg>
                  </a> 
                    <%
                    	}
                    %>    
                </li>
            </ul>
        </div>
    </header>
<!-- header end --> 
<div id="wrap">
	<div id="container"style="overflow-y:auto; overflow-x:hidden;" >
			<a href="http://localhost/team_prj2/prj2/admin/admin_product/add.jsp"><input type="button" value="상품추가" class=" btn btn-group-lg" style="position:relative;left:1100px;top:140px;"/></a>
			<h1 id="headerTitle">SANGHAUI STREET ADMINISTRATOR</h1>
			<table class="table table-hover" style=" width:1200px;height:500px;position:relative;left:20px;top:80px;">
				<tr>
					<th style="width:80px">상품번호</th>			
					<th style="width:180px">상품명</th>			
					<th style="width:80px">구분</th>			
					<th style="width:80px">가격</th>			
					<th>상품설명</th>			
					<th style="width:50px text-weight:80px;">삭제여부</th>			
				</tr>
				<tr>
				<%
				request.setCharacterEncoding("UTF-8");
				ProductAdminDAO paDAO=new ProductAdminDAO();
				
				List<ProductListAdminVO> list=paDAO.selectProductAll();
				int i=0;
				for(ProductListAdminVO plaVO:list){
				%>
					<td><a href="http://localhost/team_prj2/prj2/admin/admin_product/modify&remove.jsp?prod_num=<%=plaVO.getProd_num()%>"><%=plaVO.getProd_num() %></a></td>
					<td><%=plaVO.getProd_name() %></td>
					<td><%=plaVO.getProd_cat() %></td>
					<td><%=plaVO.getProd_price()%></td>
					<td><%=plaVO.getProd_detail() %></td>
					<td><%=plaVO.getProd_delete() %></td>
				</tr><tr>
				<%}//for%>
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