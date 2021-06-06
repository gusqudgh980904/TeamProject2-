package Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.UserDBConnection;

/**
 * 상품에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */
public class ProductDAO {
	 
	/**
	 * 게스트가 상품의 상의 전체 리스트를 보는 method
	 * @return
	 * @throws SQLException
	 */
	public List<ProductListUserVO> selectProductTopListUser() throws SQLException{
		String cat="상의";
		List<ProductListUserVO> list = new ArrayList<ProductListUserVO>();
		
		UserDBConnection dc= UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = dc.getConn();
			
			String selectQuery="select prod_num, prod_name, prod_price, prod_image from product where prod_cat=?";
			pstmt = con.prepareStatement(selectQuery);
			 
			pstmt.setString(1, cat);
			
			rs=pstmt.executeQuery();
			
			ProductListUserVO pluVO=null;
			while(rs.next()) {
				pluVO=new ProductListUserVO(rs.getString("prod_num"), rs.getString("prod_name"), rs.getString("prod_price"),rs.getString("prod_image"));
			list.add(pluVO);
			}//end while
			
			
		}finally{
			dc.dbClose(con, pstmt, rs);
		}
		
		return list;
	}
	
	/**
	 * 게스트가 상품의  하의  리스트를 보는 method
	 * @return
	 * @throws SQLException
	 */
	public List<ProductListUserVO> selectProductBottomListUser() throws SQLException{
		String cat="하의";
		List<ProductListUserVO> list = new ArrayList<ProductListUserVO>();
		
		UserDBConnection dc= UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = dc.getConn();
			
			
			String selectQuery="select prod_num, prod_name, prod_price, prod_image from product where prod_cat=?";
			pstmt = con.prepareStatement(selectQuery);
			 
			pstmt.setString(1, cat);
			
			rs=pstmt.executeQuery();
			
			ProductListUserVO pluVO=null;
			while(rs.next()) {
				pluVO=new ProductListUserVO(rs.getString("prod_num"), rs.getString("prod_name"), rs.getString("prod_price"),rs.getString("prod_image"));
			list.add(pluVO);
			}//end while
			
			
		}finally{
			dc.dbClose(con, pstmt, rs);
		}
		
		return list;
	}
	
	
	/**
	 * 상품 상세 정보
	 * @return
	 * @throws SQLException
	 */
	public ProductDetailUserVO selectProductUser(int num) throws SQLException{
		ProductDetailUserVO pduVO = null;
		
		UserDBConnection dc= UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dc.getConn();
			
			String selectQuery  = "select prod_num, prod_name, prod_price, prod_explain, prod_image from product where prod_num=?";
			pstmt = con.prepareStatement(selectQuery);
			
			pstmt.setInt(1,num);
			
			rs = pstmt.executeQuery();
			
			/*ProductListUserVO pluVO=null;
			while(rs.next()) {
				pluVO=new ProductListUserVO(rs.getString("prod_num"), rs.getString("prod_name"), rs.getString("prod_price"),rs.getString("prod_image"));
			list.add(pluVO);
			}//end while*/
			 
			if(rs.next()) {
				pduVO=new ProductDetailUserVO(rs.getString("prod_num"), rs.getString("prod_name"),rs.getString("prod_price"),rs.getString("prod_explain"),rs.getString("prod_image"));
				
			}//end if
			
		}finally {
			dc.dbClose(con, pstmt, rs);
		}
		
		return pduVO;
	}
	
	
}//class
