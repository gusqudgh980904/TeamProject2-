package LookBookComment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DBConnection.UserDBConnection;
import LookBook.LBListVO;

/**
 * 댓글에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */
public class LBCommentDAO {
	public void insertCmt(LBCommentVO lbcVO) throws SQLException {
		
		UserDBConnection udc = UserDBConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		LBListVO lblVO = null;
		
		try {
			conn = udc.getConn();
			
			String insertQuery = "insert into comments values(?, ?, ?, sysdate, seq_comments.nextval)";
			
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setInt(1, lblVO.getLb_num());
			pstmt.setString(2, lbcVO.getCmt_id());
			pstmt.setString(3, lbcVO.getCmt_comment());
			
			pstmt.executeUpdate();
			
		} finally {
			udc.dbClose(conn, pstmt, null);
		}//end finally
		
	}//insertCmt
	
	public boolean deleteCmt(DeleteCmtVO dcVO) throws SQLException {
		boolean flag = false;
		
		UserDBConnection udc = UserDBConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = udc.getConn();
			
			String deleteQuery = "delete from comments where lb_comments_num = ? and member_id = ?";
			
			pstmt = conn.prepareStatement(deleteQuery);
			
			pstmt.setInt(1, dcVO.getCmt_num());
			pstmt.setString(2, dcVO.getCmt_id());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = !flag;
			}//end if
			
		} finally {
			
		}//end finally
		
		return flag;
	}//deleteCmt
	
	public List<LBCommentVO> selectAllComment(int lb_posts_num) throws SQLException{
		List<LBCommentVO> lbcList = null;
		
		UserDBConnection udc = UserDBConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = udc.getConn();
			
			String selecQueryAll = "select lb_comments_num, member_id, lb_comments, lb_comments_date from comments where lb_posts_num = ?";
			
			pstmt = conn.prepareStatement(selecQueryAll);
			
			pstmt.setInt(1, lb_posts_num);
			
			rs = pstmt.executeQuery();
			
			LBCommentVO lbcVO = null;
			
			while(rs.next()) {
				lbcVO = new LBCommentVO(rs.getInt("lb_comments_num"), rs.getString("member_id"), rs.getString("lb_comments"), rs.getDate("lb_comments_date"));
				lbcList.add(lbcVO);
			}//end while
		} finally {
			udc.dbClose(conn, pstmt, rs);
		}//end finally
		
		return lbcList;
	}//selectAllComment
}//class
