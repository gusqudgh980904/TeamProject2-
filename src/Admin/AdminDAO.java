package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.AdminDBConnection;

/**
 * 관리자가 수행하는 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */
public class AdminDAO {
	AdminDBConnection dc=AdminDBConnection.getInstance();
	
	
	public AdminDAO() {
		
	}


	/**
	 * 관리자가 회원을 탈퇴시키는 일(Y->N)
	 * @param member_id
	 * @return
	 * @throws SQLException
	 */
	public int deleteUser(AdminUsersOneVO auoVO)throws SQLException {
	int cnt=0;
		
	Connection con=null;
	PreparedStatement pstmt=null;
	
	try {
	con=dc.getConn();
	
	String deleteUser="update member "
			+ "set member_withdrawal=? "
			+ "where=?";
	
	pstmt=con.prepareStatement(deleteUser);
	
	pstmt.setString(1,"'Y'");
	pstmt.setString(2,auoVO.getMember_id());
	
	cnt=pstmt.executeUpdate();
	}finally {
	dc.dbClose(con, pstmt, null);	
	}//finally
	
	
	return cnt;
	}//deleteUsers
	
	
	/**
	 * 회원아이디를 받아 회원 한명의 정보를 조회
	 * @param member_id
	 * @return
	 * @throws SQLException
	 */
	public AdminUsersOneVO selectUserOne(String member_id)throws SQLException{
		AdminUsersOneVO auoVO=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=dc.getConn();
		
		String selectOneuser="select MEMBER_ID, MEMBER_NAME, MEMBER_GENDER, MEMBER_BIRTH, MEMBER_PHONE, MEMBER_EMAIL, MEMBER_ZIPCODE, MEMBER_DETAILED_ADDR, MEMBER_SIGN_DATE, MEMBER_WITHDRAWAL from member where member_id=?";
				
				pstmt=con.prepareStatement(selectOneuser);
		
		pstmt.setString(1,member_id);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			auoVO=new AdminUsersOneVO(rs.getString("member_id"),rs.getString("member_name"),rs.getString("MEMBER_GENDER"),rs.getString("MEMBER_BIRTH")
									,rs.getString("MEMBER_PHONE"),rs.getString("MEMBER_EMAIL"),rs.getInt("MEMBER_ZIPCODE")
									,rs.getString("MEMBER_DETAILED_ADDR"),rs.getString("MEMBER_SIGN_DATE"),rs.getString("MEMBER_WITHDRAWAL"));
		}//if
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		
		return auoVO;
	}//selectOneUser
	
	
	/**
	 * 모든 회원정보를 조회
	 * @return
	 * @throws SQLException
	 */
	public List<AdminUsersAllVO> selectUsersAll()throws SQLException{
		List<AdminUsersAllVO> list=new ArrayList<AdminUsersAllVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=dc.getConn();
		
		String selectAllusers="select MEMBER_ID, MEMBER_NAME, MEMBER_GENDER, MEMBER_SIGN_DATE, MEMBER_WITHDRAWAL from member";
		
		pstmt=con.prepareStatement(selectAllusers);
		
		rs=pstmt.executeQuery();
		
		AdminUsersAllVO auaVO=null;
		while(rs.next()) {
			auaVO=new AdminUsersAllVO(rs.getString("member_id"),rs.getString("member_name"),rs.getString("member_gender")
							,rs.getString("member_sign_Date"),rs.getString("member_withdrawal"));
		list.add(auaVO);
		}//while
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		
		return list;
	}//selectAllUsers
	
	
	/**
	 * 룩북 전체조회
	 * @return
	 * @throws SQLException
	 */
	public List<AdminLBListVO> selectLookBookAll()throws SQLException{
		List<AdminLBListVO> list=new ArrayList<AdminLBListVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=dc.getConn();
		
		String selectAlllookbook="select lb_posts_num,LB_TITLE, MEMBER_ID, LB_WRITE_DATE from lookbook order by lb_posts_num";
				
		pstmt=con.prepareStatement(selectAlllookbook);
		
		rs=pstmt.executeQuery();
		
		AdminLBListVO allVO=null;
		while(rs.next()) {
			allVO=new AdminLBListVO(rs.getInt("lb_posts_num"),rs.getString("lb_title"),rs.getString("MEMBER_ID"),rs.getString("LB_WRITE_DATE"));
			list.add(allVO);
		}//while
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		
		return list;
	}//selectAllLookBook
	
	
	/**
	 * 룩북 상세조회
	 * @param lb_num
	 * @return
	 * @throws SQLException
	 */
	public AdminLBDetailVO selectLookBookOne(int lb_num)throws SQLException{
		AdminLBDetailVO aldVO=null;	
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		con=dc.getConn();
		
		String selectlookbookOne="select LB_POSTS_NUM, LB_TITLE, MEMBER_ID,LB_CONTENTS from lookbook where LB_POSTS_NUM=?";
		
		pstmt=con.prepareStatement(selectlookbookOne);
		
		pstmt.setInt(1,lb_num);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			aldVO=new AdminLBDetailVO(rs.getInt("LB_POSTS_NUM"),rs.getString("LB_TITLE"),rs.getString("member_id"),rs.getClob("LB_CONTENTS"));
		}//if
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		
		return aldVO;
	}//selectLookBookOne
	
	
	
}//class
