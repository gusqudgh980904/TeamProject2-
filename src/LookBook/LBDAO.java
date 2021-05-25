package LookBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.UserDBConnection;

/**
 * 룩북 게시판에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */
public class LBDAO {
	public void insertPost(LBWriteVO lbwVO) throws SQLException {
		UserDBConnection udc = UserDBConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = udc.getConn();
			
			String insertQuery = "insert into lookbook values(seq_lookbook.nextval, ?, ?, ?, ?, sysdate)";
			
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setString(2, lbwVO.getLbw_id());
			pstmt.setString(3, lbwVO.getLbw_img());
			pstmt.setString(4, lbwVO.getLbw_title());
			pstmt.setString(5, lbwVO.getLbw_content());
			
			rs = pstmt.executeQuery();
			
		} finally {
			udc.dbClose(conn, pstmt, rs);
		}//end finally
	
	}//insertPost
}//class
