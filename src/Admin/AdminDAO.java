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
		
		String selectOneuser="select MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE, MEMBER_ZIPCODE, MEMBER_ADDR, MEMBER_EMAIL, MEMBER_GENDER, MEMBER_BIRTH, MEMBER_SIGN_DATE,MEMBER_DETAILED_ADDR\r\n"
				+ "from member"
				+ "where member_id=?";
		
		pstmt=con.prepareStatement(selectOneuser);
		
		pstmt.setString(1,member_id);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			auoVO=new AdminUsersOneVO(rs.getString("member_id"),rs.getString("member_name"),rs.getString("member_phone"),rs.getInt("member_zipcode")
									,rs.getString("member_addr"),rs.getString("member_detailedAddr"),rs.getString("member_email")
									,rs.getString("member_gender"),rs.getString("member_birth"),rs.getDate("member_signDate"),rs.getString("member_withdrawal"));
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
		
		String selectAllusers="select MEMBER_ID,MEMBER_NAME, MEMBER_GENDER,MEMBER_SIGN_DATE,member_withdrawal"
								+ "from member";
		
		pstmt=con.prepareStatement(selectAllusers);
		
		rs=pstmt.executeQuery();
		
		AdminUsersAllVO auaVO=null;
		while(rs.next()) {
			auaVO=new AdminUsersAllVO(rs.getString("member_id"),rs.getString("member_name"),rs.getString("member_gender")
							,rs.getDate("member_signDate"),rs.getString("member_withdrawal"));
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
		
		String selectAlllookbook="select LB_POSTS_NUM, LB_TITLE, MEMBER_ID, LB_WRITE_DATE\r\n"
								+ "from lookbook";
		
		pstmt=con.prepareStatement(selectAlllookbook);
		
		rs=pstmt.executeQuery();
		
		AdminLBListVO allVO=null;
		while(rs.next()) {
			allVO=new AdminLBListVO(rs.getInt("lb_num"),rs.getString("lb_title"),rs.getString("lb_writer"),rs.getDate("lb_date"));
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
		
		String selectlookbookOne="select LB_TITLE, LB_CONTENTS, LB_IMAGES\r\n"
				+ "from lookbook\r\n"
				+ "where LB_POSTS_NUM=?";
		
		pstmt=con.prepareStatement(selectlookbookOne);
		
		pstmt.setInt(1,lb_num);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			aldVO=new AdminLBDetailVO(rs.getString("lb_title"),rs.getString("lb_content"),rs.getString("lb_img"));
		}//if
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}//finally
		
		return aldVO;
	}//selectLookBookOne
	
	
	
}//class
