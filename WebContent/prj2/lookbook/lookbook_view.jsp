<%@page import="LookBook.LBWriteVO"%>
<%@page import="LookBook.LBDAO"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자 로그인 한 이후의 아이디 데이터를 필요한 페이지에서 사용하기 위한 공통 JSP
	String userId = (String)session.getAttribute("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- css -->
<link href="http://localhost/team_prj2/common/css/yl_main.css" rel="stylesheet" >
<link href="http://localhost/team_prj2/common/css/main.css" rel="stylesheet" >

<title>LookBook</title>

<!-- bootstrap -->
<link href="http://localhost/team_prj2/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/team_prj2/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
	table{border-collapse: separate; border-spacing: 10px 10px;  }
	h2,h3{text-align: center; font-weight:bold;}
	.text{width: 1185px;height:600px;border:1px solid #dfdfdf;}
	.view{width: 1185px;height:600px;}
	.text_right{text-align:right;}	
	
</style>
<script type="text/javascript">
window.onload=function(){
	ocument.getElementById("writeCmt").addEventListener("click", sendView);
}//onload

function cancel(){
	 if( confirm("정말 게시글을 삭제 하시겠습니까?")){
     window.location.href ="http://localhost/team_prj2/prj2/lookbook/process/lookbook_delete_process.jsp";
   }
}

function logout(){
    if( confirm("정말 로그아웃 하시겠습니까?")){
    	location.href="http://localhost/team_prj2/prj2/main/logout.jsp";
	}
}
</script>
</head>
<body>
<!-- header start -->
     <header class="header">
        <div class="main_nav">
            <div>
                <h1 class="title"><a href="http://localhost/team_prj2/prj2/main/main_all.jsp"><img src="http://localhost/team_prj2/common/images/상하의스트릿.png"></a></h1>
                <ul class="navigation">
                    <li><a href="http://localhost/team_prj2/prj2/product/guest_prod_top.jsp" style="color: black">TOP</a></li>
                    <li><a href="http://localhost/team_prj2/prj2/product/guest_prod_bottom.jsp" style="color: black">BOTTOM</a></li>
                    <li><a href="http://localhost/team_prj2/prj2/lookbook/lookbook_main.jsp" style="color: black">LOOKBOOK</a></li>
                    <li><a href="http://localhost/team_prj2/prj2/login/member.jsp" style="color: black">MYPAGE</a></li>
                </ul>
            </div>
            <ul class="icons">
                <li>
                    <p>login</p>
                    <%                    
                    if( userId == null  ){
                    %>
                    <a href="http://localhost/team_prj2/prj2/login/login.jsp">
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
                     	} else {
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
                <li>
                    <p>cart</p>
                    <a href="http://localhost/team_prj2/prj2/order/orderDetail.jsp">
                    <svg id="Capa_1" enable-background="new 0 0 512 512" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
                        <path d="m472 452c0 11.046-8.954 20-20 20h-20v20c0 11.046-8.954 20-20 20s-20-8.954-20-20v-20h-20c-11.046 
                        0-20-8.954-20-20s8.954-20 20-20h20v-20c0-11.046 8.954-20 20-20s20 8.954 20 20v20h20c11.046 0 20 8.954 20 20zm0-312v192c0 
                        11.046-8.954 20-20 20s-20-8.954-20-20v-172h-40v60c0 11.046-8.954 20-20 20s-20-8.954-20-20v-60h-192v60c0 11.046-8.954 20-20 
                        20s-20-8.954-20-20v-60h-40v312h212c11.046 0 20 8.954 20 20s-8.954 20-20 20h-232c-11.046 0-20-8.954-20-20v-352c0-11.046 8.954-20 
                        20-20h60.946c7.945-67.477 65.477-120 135.054-120s127.109 52.523 135.054 120h60.946c11.046 0 20 8.954 20 20zm-121.341-20c-7.64-45.345-47.176-80-94.659-80s-87.019 34.655-94.659 80z"/>
                        </svg>
                        </a>
                </li>
            </ul>
        </div>
    </header>
    <!-- header end -->
    <section>
     <!-- container start -->
        <div class="container">
        <%
	    	request.setCharacterEncoding("UTF-8");
			
        	String num=request.getParameter("num"); 
        
    		session.setAttribute("num", num);
        	      	
        	if(num == null){
        		JOptionPane.showMessageDialog(null, "해당하는 게시물이 없습니다.");
        		%>
        		<script type="text/javascript">
        			window.location.href="http://localhost/team_prj2/prj2/lookbook/lookbook_main.jsp";
        		</script>
        		<%
        		
        	} else {
        		LBDAO lbDAO = new LBDAO();
        		LBWriteVO lbwVO = new LBWriteVO();
        		
        		int lb_num = Integer.parseInt(num);
        		lbwVO = lbDAO.selectOnePost(lb_num);
        		
        		%>
        	<!-- LookBook Header -->
        	<h2></h2>       	
        	<div  style="justify-content: center; display: flex; flex-direction: column; align-items: center;">
        	<table>
        	<tr>
				<th> 
	        		<span style="font-size:1.3em; ">작성자 : <%= lbwVO.getLbw_id() %></span>	        	 	
        			<span style="font-size:1.3em; padding-left: 905px ">작성일 : <%= lbwVO.getLbw_write_date() %></span><br/>	       
        		</th>
        		
        		
        	</tr>	
        	<tr>
        		<td>		        
        			<div class="view" style="overflow:auto; font-size:1.3em; border: 1px solid; overflow: auto; border-radius: 10px" >
        				<%= lbwVO.getLbw_content() %>
        			</div>
        		</td>
        	</tr>
        	
        	<tr>
        		<td>
        			<input type="text" placeholder="댓글 내용" style="width:1128px" readonly="readonly"/>
        		<input type="button" value="삭제" class="btn btn-danger" id="deleteCmt"/></td>
        	</tr>
        	<tr>
        		<td>
        			<textarea placeholder="댓글을 작성해주세요" style="resize:none; width:1128px; height:80px; "></textarea>
        		
        		<input type="button" value="등록" class="btn btn-primary" id="writeCmt" style="height: 80px"/></td>
        	</tr>
        	<tr>
        		<td style="padding-left: 1015px">
        			<input type="button" value="수정" class="btn btn-info" <%= lbwVO.getLbw_id().equals(userId) ?"":"style='display: none;'"%> onclick="location.href='http://localhost/team_prj2/prj2/lookbook/lookbook_revise.jsp?num=<%= lb_num %>'"/>
        			<input type="button" value="삭제" class="btn btn-info" <%= lbwVO.getLbw_id().equals(userId) ?"":"style='display: none;'"%> onclick="cancel();"/>
        			<input  type="button" value="목록" class="btn btn-info" onclick="location.href='http://localhost/team_prj2/prj2/lookbook/lookbook_main.jsp'"/>
        		</td>
        	</tr>
        	</table>
        	</div>
        	<%
        		}//end else
       		%>  
        </div>
    </section>
    <!-- container end -->
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