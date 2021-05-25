<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=" UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

<!-- css -->
<link href="http://localhost/team_prj2/common/css/yl_main.css" rel="stylesheet">

<!-- bootstrap -->
<link href="http://localhost/team_prj2/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/team_prj2/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
	
	.main_con{ width: 100%; justify-content: center; display: flex; flex-direction: column; align-items: center;}
	#container{ width:  100%; height: 1000px;  }
	
	#join_pw{width: 1300px; height:250px; position: absolute;  top: 390px; left:141px;}
	#join_font{position: absolute; top: 165px; left: 141px; font-size: 20px;}
	#pw{position: absolute; top: 330px; left: 141px; font-size: 30px;}
	#essential{position: absolute; top: 340px; left: 1275px; font-size: 25px;}
	
	#spanId{padding-left: 20px; padding-right: 45px;}
	#spanPw{padding-left: 20px; padding-right: 20px;}
	#loginBt{background-color:black; width: 100px; height: 50px; font-size: 15px; font-weight: bold; margin-bottom: 60px}
	#hr{width: 600px; border: 1px solid #8F8F91}
	#dup{font-size: 25px; margin: 0px 0px 8px 10px}
	#commitBtDiv{width: 1300px;  margin-top:100px;  display: flex; justify-content: center; }
	#withdraw{width: 150px; height: 60px; font-size: 25px;  margin-left: 1200px;}

	.text{width: 400px; height: 50px; display: inline; margin-left: 30px; font-size: 22px}
	.phoneTx{width: 100px; height: 50px; display: inline; margin-left: 30px; font-size: 25px; }
	.hyphen{margin: 0px 0px 0px 20px;  font-size: 30px;}
	.genderDiv{margin-left: 30px; display: inline;}
	.gender{font-size: 25px; width: 25px; height: 25px}
	.birth{margin: 0px 0px 0px 10px;  font-size: 25px;}
	.birthTx{width: 70px; height: 50px; display: inline; margin-left: 30px; font-size: 25px; }
	.explain{margin-left: 10px; font-size: 17px}
	.commitBt{width: 150px; height: 60px; font-size: 25px; font-weight: bold; text-align: center; }
	
	div > p{font-size: 60px}
	div > span {font-size: 18px;}
	div > span > a{color: black;}
	
	label{border: 1px solid; #ccc; border-radius: 2px; color: #8F8F91; font-size: 25px; margin-bottom: 20px }
	input:focus {outline: none;}
	
	table{border: 1px solid #d7d5d5;}
	td{width: 1000px; height: 115px; border: 1px solid #d7d5d5;}
	th{width: 400px; font-size: 25px; border: 1px solid #d7d5d5; background-color: #f9f8f8}
</style>

<script type="text/javascript">
	


</script>
</head>
<body>
<div>
		<header class="header" >
        <div class="main_nav">
            <div>
                <h1 class="title"><a href="#"><img src="http://localhost/team_prj2/common/images/상하의스트릿.png"></a></h1>
                <ul class="navigation">
                    <li><a href="http://localhost/team_prj2/prj2/product/guest_prod.jsp" style="color: black">TOP</a></li>
                    <li><a href="http://localhost/team_prj2/prj2/product/guest_prod.jsp" style="color: black">BOTTOM</a></li>
                    <li><a href="http://localhost/team_prj2/prj2/lookbook/lookbook_main.jsp" style="color: black">LOOKBOOK</a></li>
                    <li><a href="" style="color: black">MYPAGE</a></li>
                </ul>
            </div>
            <ul class="icons">
                <li>
                    <p>login</p>
                    <a href="">
                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                        viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
                            <path d="M437.02,330.98c-27.883-27.882-61.071-48.523-97.281-61.018C378.521,243.251,404,198.548,404,148
                                C404,66.393,337.607,0,256,0S108,66.393,108,148c0,50.548,25.479,95.251,64.262,121.962
                                c-36.21,12.495-69.398,33.136-97.281,61.018C26.629,379.333,0,443.62,0,512h40c0-119.103,96.897-216,216-216s216,96.897,216,216
                                h40C512,443.62,485.371,379.333,437.02,330.98z M256,256c-59.551,0-108-48.448-108-108S196.449,40,256,40
                                c59.551,0,108,48.448,108,108S315.551,256,256,256z"/>
                    </svg>
                    </a>
                </li>
                <li>
                    <p>cart</p>
                    <a href="">
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
		
		<div  id = container>
			<div class = main_con >
			<div id=join_font>
				<p>PASSWORD</p>홈 > 비밀번호 변경
			</div>	
			<strong id = "pw">비밀번호설정</strong>
			<div id= join_pw>
				<form>
					<table>
						<tr>
							<th>&emsp;비밀번호</th>
							<td>
								 <input type="password" class="form-control text" maxlength="16">
								 <span class="explain">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8~16자)</span>
							</td>
						</tr>
						<tr>
							<th>&emsp;비밀번호확인</th>
							<td>
								 <input type="password" class="form-control text" maxlength="16">
							</td>
						</tr>
					</table>
				</form>
					<div id ="commitBtDiv">
						<button type="button" class="btn btn-danger commitBt">변경하기</button>
					</div>
				</div>
		</div>
		</div>
	
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
	

</body>
</html>