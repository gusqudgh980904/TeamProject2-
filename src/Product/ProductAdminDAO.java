package Product;

import java.sql.Connection;
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
		
		String insertProduct="insert into PRODUCT values (PROD_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		
							
		
		pstmt=con.prepareStatement(insertProduct);
		
		pstmt.setString(1,pVO.getProd_cat());
		pstmt.setString(2,pVO.getProd_name());
		pstmt.setString(3,pVO.getProd_price());
		pstmt.setString(4,pVO.getProd_detail());
		pstmt.setString(5,pVO.getProd_delete());
		pstmt.setString(6,pVO.getProd_img());
		pstmt.setString(7,pVO.getProd_add_date());
		
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
		
		String updateProduct="update product "
				+ "set PROD_NAME=?, PROD_PRICE=?, PROD_IMAGE=?, PROD_EXPLAIN=?  "
				+ "where prod_num=?";
		
		pstmt=con.prepareStatement(updateProduct);
		
		pstmt.setString(1,pmVO.getProd_name());
		pstmt.setString(2,pmVO.getProd_price());
		pstmt.setString(3,pmVO.getProd_img());
		pstmt.setString(4,pmVO.getProd_detail());
		pstmt.setString(5,pmVO.getProd_num());
		
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
	public int deleteProduct(String delete,int num)throws SQLException{
		int cnt=0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		con=dc.getConn();
				
		String deleteProduct="update product\r\n"
				+ "set prod_delete=?\r\n"
				+ "where prod_num=?";
		
		pstmt=con.prepareStatement(deleteProduct);
		
		pstmt.setString(1,delete);
		pstmt.setInt(2,num);
			
		cnt=pstmt.executeUpdate();
		
		}finally {
			dc.dbClose(con, pstmt, null);
		}//finally
		
		return cnt;
	}//deleteProduct
	
	
	/**
	 * 룩북 전체조회
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
	
	
	/**
	 * 상품번호를 받아 상품의 상세정보를 보여주는 일
	 * @param num 상품번호
	 * @return
	 * @throws SQLException
	 */
	public ProductDetailAdminVO selectProductInfo(int num)throws SQLException{
		ProductDetailAdminVO pdaVO=null;
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		con=dc.getConn();
		
		String selectProductInfo="select PROD_NUM, PROD_NAME, PROD_PRICE, PROD_CAT, PROD_EXPLAIN,PROD_IMAGE,prod_add_date,prod_delete   "
				+ "from product "
				+ "where prod_num=?";
		
		pstmt=con.prepareStatement(selectProductInfo);
		
		pstmt.setInt(1,num);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			pdaVO=new ProductDetailAdminVO(rs.getString("prod_num"),rs.getString("prod_name"),rs.getString("prod_price"),rs.getString("prod_cat"),rs.getString("prod_explain"),rs.getString("PROD_IMAGE"),rs.getString("prod_add_date"),rs.getString("prod_delete"));
		}//if
			
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		
		return pdaVO;
	}//selectProductInfo
	
	
	/**
	 * 상품 전체보기
	 * @return
	 * @throws SQLException
	 */
	public List<ProductListAdminVO> selectProductAll()throws SQLException{
		List<ProductListAdminVO> list=new ArrayList<ProductListAdminVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=dc.getConn();
		
		String selectProductAll="select PROD_NUM, PROD_IMAGE, PROD_NAME, PROD_PRICE, PROD_EXPLAIN, PROD_DELETE "
				+ "from product "
				+ "order by prod_num desc";
		
		pstmt=con.prepareStatement(selectProductAll);
		
		rs=pstmt.executeQuery();
		
		ProductListAdminVO plaVO=null;
		while(rs.next()) {
			plaVO=new ProductListAdminVO(rs.getString("PROD_NUM"),rs.getString("PROD_NAME"),rs.getString("PROD_PRICE"),rs.getString("PROD_EXPLAIN"),rs.getString("PROD_DELETE"));
		list.add(plaVO);
		}//while
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		
		return list;
	}
	
	
}//class
