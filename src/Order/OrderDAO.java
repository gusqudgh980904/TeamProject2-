package Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.UserDBConnection;
import Product.ProductListUserVO;


/**
 * 주문에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */
public class OrderDAO {
	
	public List<OrderDetailVO> selectOrder(OrderSimpleVO osVO)throws SQLException{
		OrderDetailVO odVO = null;
		List<OrderDetailVO> list = new ArrayList<OrderDetailVO>();
		
		UserDBConnection dc= UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1. Connection 얻기
			con = dc.getConn();
		//2. 쿼리문 생성객체 얻기
			String selectQuery="select a.ORDER_NUM, a.PROD_NUM, b.PROD_NAME, a.ORDER_SIZE, a.ORDER_PRICE, a.ORDER_QUANTITY "
					+ "from ORDER_DETAILS a, PRODUCT b where a.MEMBER_ID=? and a.PROD_NUM = b.PROD_NUM";
			
			pstmt = con.prepareStatement( selectQuery );
		//3. 바인드변수에 값 할당
			pstmt.setString(1, osVO.getMember_id());
			
		//4. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				odVO=new OrderDetailVO();
				odVO.setProd_name(rs.getString("PROD_NAME"));
				odVO.setOrder_num(rs.getInt("ORDER_NUM"));
				odVO.setProd_num(rs.getInt("PROD_NUM"));
				odVO.setOrder_size(rs.getString("ORDER_SIZE"));
				odVO.setOrder_quantity(rs.getInt("ORDER_QUANTITY"));
				odVO.setProd_price(rs.getString("ORDER_PRICE"));
				list.add(odVO);
			}//end while

		}finally {
		//5. 연결 끊기
			dc.dbClose(con, pstmt, rs);
		}//end finally
		return list;
	}//selectLogin
	
	/**
	 * 주문내역 삽입 
	 * @param osVO
	 * @throws SQLException
	 */
	public void insertOrder(OrderSimpleVO osVO)throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		UserDBConnection dc= UserDBConnection.getInstance();
		
		
		try {
			//1. Connection 얻기
			con = dc.getConn();

			String insertQuery="insert into order_details(ORDER_NUM, MEMBER_ID, PROD_NUM, ORDER_SIZE, ORDER_PRICE, ORDER_QUANTITY) "
					+ "values(NO_SEQ.nextval,?,?,?,?,?)";
			pstmt = con.prepareStatement( insertQuery );
			//3. 바인드변수에 값 할당

			pstmt.setString(1, osVO.getMember_id());
			pstmt.setInt(2, osVO.getProd_num());
			pstmt.setString(3, osVO.getOrder_size());
			pstmt.setInt(4, osVO.getOrder_price());
			pstmt.setInt(5, osVO.getOrder_quantity());
			
			pstmt.executeUpdate();
			
		}finally {
			//5. 연결 끊기
			dc.dbClose(con, pstmt, null);
		}//end finally
	}//selectLogin
}//class
