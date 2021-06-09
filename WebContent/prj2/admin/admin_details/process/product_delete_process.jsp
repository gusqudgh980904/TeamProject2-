<%@page import="Product.ProductModifyVO"%>
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

		int prod_num=Integer.parseInt(request.getParameter("prod_num"));
		String prod_delete=request.getParameter("prod_delete");
		
		ProductAdminDAO paDAO=new ProductAdminDAO();
		int cnt=paDAO.deleteProduct(prod_delete,prod_num);
		
			if(cnt==1){
			response.sendRedirect("http://localhost/team_prj2/prj2/admin/admin_contents/admin_lookbooks.jsp");	
			}else{
			%>
			삭제도중 문제가 생겼습니다.
			
			<% }//else%>

</body>
</html>