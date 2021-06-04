<%@page import="java.sql.SQLException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Product.ProductVO"%>
<%@page import="Product.ProductAdminDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

    <!-- bootstrap -->
    <link href="http://localhost/jsp_prj/common/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <!-- bootstrap -->
<script src="http://localhost/jsp_prj/common/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">

</style>
<script type="text/javascript">

</script>
</head>
<body>
			<%
			request.setCharacterEncoding("UTF-8");
			String savePath="C:/dev/workspace/team_prj2/WebContent/product_photo/";
			int maxSize=500*500*7;
			MultipartRequest mr
			=new MultipartRequest(request,savePath,maxSize,"UTF-8",new DefaultFileRenamePolicy());
			String prod_img=mr.getOriginalFileName("prod_img");
			
			String prod_num=mr.getParameter("prod_num");
			String prod_name=mr.getParameter("prod_name");
			String price=mr.getParameter("price");
			String category=mr.getParameter("category");
			String size=mr.getParameter("size");
			String prod_detail=mr.getParameter("prod_detail");
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-a hh:mm:ss EEEE");
			Date date=new Date();
			String add_date= String.valueOf(sdf.format(date));
			
			String withdrawl="N";
			
			ProductVO pVO=new ProductVO(
					prod_num,
					category,
					prod_name,
					price,
					prod_detail,
					size,
					withdrawl,
					prod_img,
					add_date);
			ProductAdminDAO paDAO=new ProductAdminDAO();
			try{
			paDAO.insertProduct(pVO);
			response.sendRedirect("http://localhost/team_prj2/prj2/admin/admin_contents/admin_main.jsp");
			}catch(SQLException se){
				se.printStackTrace();
			%>
			상품추가에 문제가 발생하였습니다.<br/>
			잠시후 다시 시도해주세요.
			<%
			}//catch
			%>

</body>
</html>