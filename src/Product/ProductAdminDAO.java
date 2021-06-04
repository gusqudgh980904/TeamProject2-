package Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Admin.AdminLBListVO;
import DBConnection.AdminDBConnection;

/**
 * 상품에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */

public class ProductAdminDAO {
	AdminDBConnection dc=AdminDBConnection.getInstance();
	
	/**
	 * 상품을 추가하는 일
	 * @param pVO
	 * @throws SQLException
	 */
	public void insertProduct(ProductVO pVO)throws SQLException{
	
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		con=dc.getConn();
		
		String insertProduct="insert into PRODUCT values (PROD_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		
							
		
		pstmt=con.prepareStatement(insertProduct);
		
		pstmt.setString(1,pVO.getProd_cat());
		pstmt.setString(2,pVO.getProd_name());
		pstmt.setString(3,pVO.getProd_price());
		pstmt.setString(4,pVO.getProd_detail());
		pstmt.setString(5,pVO.getProd_size());
		pstmt.setString(6,pVO.getProd_delete());
		pstmt.setString(7,pVO.getProd_img());
		pstmt.setString(8,pVO.getProd_add_date());
		
		pstmt.executeUpdate();
		
		}finally {
			dc.dbClose(con, pstmt, null);
		}//finally
		
	}//insertProduct
	
	
	/**
	 * 상품번호로 상품정보를 수정하는 일
	 * @param pmVO
	 * @return
	 * @throws SQLException
	 */
	public int updateProduct(ProductModifyVO pmVO)throws SQLException{
		int cnt=0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		con=dc.getConn();
		
		String updateProduct="update PRODUCT\r\n"
				+ "set  PROD_NAME=?, PROD_PRICE=?, PROD_SIZE=?, PROD_IMAGE=?, PROD_EXPLAIN=?\r\n"
				+ "where PROD_NUM=?";
		
		pstmt=con.prepareStatement(updateProduct);
		
		pstmt.setString(1,pmVO.getProd_name());
		pstmt.setInt(2,pmVO.getProd_price());
		pstmt.setString(3,pmVO.getProd_img());
		pstmt.setString(4,pmVO.getProd_detail());
		pstmt.setInt(5,pmVO.getProd_num());
		
		cnt=pstmt.executeUpdate();
		
		}finally {
			dc.dbClose(con, pstmt, null);
		}//finally
		
		
		return cnt;
	}//updateProduct
	
	
	
	/**
	 * 상품번호를 받아 상품을 삭제상태로 바꾸는일 (Y->N)
	 * @param pVO
	 * @return
	 * @throws SQLException
	 */
	public int deleteProduct(ProductVO pVO)throws SQLException{
		int cnt=0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		con=dc.getConn();
				
		String deleteProduct="update product\r\n"
				+ "set prod_delete=?\r\n"
				+ "where prod_num=?";
		
		pstmt=con.prepareStatement(deleteProduct);
		
		pstmt.setString(1,"'Y'");
		pstmt.setString(2,pVO.getProd_num());
		
		cnt=pstmt.executeUpdate();
		
		}finally {
			dc.dbClose(con, pstmt, null);
		}//finally
		
		return cnt;
	}//deleteProduct
	
	
	/**
	 * 상품 전체조회
	 * @return
	 * @throws SQLException
	 */
	public List<ProductVO> selectLookBookAll()throws SQLException{
		List<ProductVO> list=new ArrayList<ProductVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=dc.getConn();
		
		String selectAllProduct="SELECT PROD_NUM, PROD_CAT, PROD_NAME, PROD_PRICE, PROD_EXPLAIN, PROD_SIZE, PROD_ADD_DATE, PROD_DELTE, PROD_IMAGE\r\n"
				+ "from PRODUCT";
		
		pstmt=con.prepareStatement(selectAllProduct);
		
		rs=pstmt.executeQuery();
		
		AdminLBListVO allVO=null;
		while(rs.next()) {
//			allVO=new ProductVO();
//			list.add(allVO);
		}//while
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		return list;
	}//selectAllLookBook
	
	
}//class
