package Member;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import DBConnection.UserDBConnection;
import kr.co.sist.util.cipher.DataEncrypt;


/**
 * 회원에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */
public class MemberDAO {
	
	/**
	 * 회원가입
	 * @param mVO
	 */
	public void insertMember(MemberVO mVO) throws SQLException{ 
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		UserDBConnection dc = UserDBConnection.getInstance();
		
		try {
			con = dc.getConn();
			
			String insertMember="insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertMember);
			
			pstmt.setString(1, mVO.getMember_id() );
			pstmt.setString(2, mVO.getMember_pw() );
			pstmt.setString(3, mVO.getMember_name() );
			pstmt.setString(4, mVO.getMember_phone() );
			pstmt.setInt(5, mVO.getMember_zipcode() );
			pstmt.setString(6, mVO.getMember_addr() );
			pstmt.setString(7, mVO.getMember_email() );
			pstmt.setString(8, mVO.getMember_gender() );
			pstmt.setString(9, mVO.getMember_birth() );
			pstmt.setString(10, mVO.getMember_signDate() );
			pstmt.setString(11, mVO.getMember_withdrawsal());
			pstmt.setString(12, mVO.getMember_detailedAddr() );
			
			pstmt.executeUpdate();
			
		}finally {
			dc.dbClose(con, pstmt, null);
		}
		
	}
	
	/**
	 * 로그인
	 * @param lVO
	 * @return
	 * @throws SQLException
	 */
	public boolean selectLogin(LoginVO lVO) throws SQLException{
		boolean login = false;
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dc.getConn();
			
			String selectQuery  = "select MEMBER_ID,MEMBER_PW from MEMBER where MEMBER_ID =? and MEMBER_PW =?";
			pstmt = con.prepareStatement(selectQuery);
			
			pstmt.setString(1, lVO.getMember_id());
			pstmt.setString(2, lVO.getMember_pw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				login = true;
			}
			
		}finally {
			dc.dbClose(con, pstmt, rs);
		}
		return  login;
	}
	
	/**
	 * 아이디 중복확인
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean selectDupID(String id) throws SQLException{
		boolean idFlag = false;
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dc.getConn();
			
			String selectQuery  = "select MEMBER_ID from MEMBER where MEMBER_ID =?";
			pstmt = con.prepareStatement(selectQuery);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idFlag = true;
			}
			
		}finally {
			dc.dbClose(con, pstmt, rs);
		}
		return idFlag;
	}
	 
	/**
	 * 아이디 찾기
	 * @param sIVO
	 * @return
	 * @throws SQLException
	 */
	public IDFindVO selectSearchID(SearchIdVO sIVO)throws SQLException{
		IDFindVO idFVO = null;
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		con = dc.getConn();
		
		String selectQuery = "select MEMBER_ID, MEMBER_SIGN_DATE from MEMBER where MEMBER_NAME =? and MEMBER_EMAIL = ?";
		pstmt = con.prepareStatement(selectQuery);
		
		pstmt.setString(1, sIVO.getMember_name());
		pstmt.setString(2, sIVO.getMember_email());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			idFVO = new IDFindVO(rs.getString("MEMBER_ID"), rs.getString("MEMBER_SIGN_DATE"));
			
		}
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}
		return idFVO;
	}
	
	/**
	 * 비밀번호 찾기
	 * @param sIVO
	 * @return
	 * @throws SQLException
	 */
	public boolean selectSearchPW(SearchPwVO sPVO)throws SQLException{
		boolean pwFlag = false;
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		con = dc.getConn();
		
		String selectQuery = "select member_pw from MEMBER where MEMBER_ID= ? and MEMBER_NAME = ? and MEMBER_EMAIL = ?";
		pstmt = con.prepareStatement(selectQuery);
		
		pstmt.setString(1, sPVO.getMember_id());
		pstmt.setString(2, sPVO.getMember_name());
		pstmt.setString(3, sPVO.getMember_email());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			pwFlag = true;
		}
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}
		return pwFlag;
	}
		
	/**
	 * 비밀번호를 변경, 임시 비밀번호로 변경
	 * @param pass
	 * @return
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException 
	 */
	public int updatePassword(String pass, String id)throws SQLException, NoSuchAlgorithmException{
		int cnt = 0;
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		con = dc.getConn();
		
		pass =DataEncrypt.messageDigest("MD5", pass);
		
		String updateQuery = "update MEMBER set MEMBER_PW= ? where MEMBER_ID = ?";
		pstmt = con.prepareStatement(updateQuery);
		
		pstmt.setString(1, pass);
		pstmt.setString(2, id);
		
		cnt = pstmt.executeUpdate();
		
		}finally {
			dc.dbClose(con, pstmt, null);
			}
		
		return cnt;
		}
	
	
	/**
	 * 회원정보조회(myPage)
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public MemberSearchVO selectMemberInfo(String id)throws SQLException{
		MemberSearchVO msVO = null;
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		con = dc.getConn();
		
		String selectQuery = "select MEMBER_NAME,MEMBER_PHONE,MEMBER_EMAIL,MEMBER_ZIPCODE,MEMBER_ADDR,MEMBER_DETAILED_ADDR,MEMBER_GENDER,MEMBER_BIRTH "
				+ "from MEMBER where MEMBER_ID = ?";
		pstmt = con.prepareStatement(selectQuery);
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			msVO = new MemberSearchVO(rs.getString("MEMBER_NAME"), rs.getString("MEMBER_PHONE"), rs.getString("MEMBER_EMAIL"), 
					rs.getInt("MEMBER_ZIPCODE"), rs.getString("MEMBER_ADDR"), rs.getString("MEMBER_DETAILED_ADDR"), 
					rs.getString("MEMBER_GENDER"), rs.getString("MEMBER_BIRTH"));
		}
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}
		
		return msVO;
	}
	
	/**
	 * 회원정보수정(mypage)
	 * @param mVO
	 */
	public int updateMember(MemberUpdateVO muVO) throws SQLException{ 
		int cnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		UserDBConnection dc = UserDBConnection.getInstance();
		
		try {
			con = dc.getConn();
			
			String updateMember="update member set MEMBER_ID = ?, MEMBER_NAME = ?, MEMBER_PHONE = ? ,MEMBER_ZIPCODE = ?, MEMBER_ADDR = ?, MEMBER_EMAIL = ?, MEMBER_GENDER = ?, MEMBER_BIRTH = ?, MEMBER_DETAILED_ADDR = ? where MEMBER_ID = ?";
			pstmt = con.prepareStatement(updateMember);
			
			pstmt.setString(1, muVO.getMember_id() );
			pstmt.setString(2, muVO.getMember_name() );
			pstmt.setString(3, muVO.getMember_phone() );
			pstmt.setInt(4, muVO.getMember_zipcode() );
			pstmt.setString(5, muVO.getMember_addr() );
			pstmt.setString(6, muVO.getMember_email() );
			pstmt.setString(7, muVO.getMember_gender() );
			pstmt.setString(8, muVO.getMember_birth() );
			pstmt.setString(9, muVO.getMember_detailedAddr() );
			pstmt.setString(10, muVO.getMember_id() );
			
			cnt = pstmt.executeUpdate();
			
		}finally {
			dc.dbClose(con, pstmt, null);
		}
		
		return cnt;
	}
	
	/**
	 * 회원탈퇴관리 (회원탈퇴여부를 N에서 Y로 변경)
	 * @param withdraw
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 */
	public int deleteMember(String withdraw, String id)throws SQLException, NoSuchAlgorithmException{
		int cnt = 0;
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		con = dc.getConn();
		
		String updateQuery = "update MEMBER set MEMBER_WITHDRAWAL= ? where MEMBER_ID = ?";
		pstmt = con.prepareStatement(updateQuery);
		
		pstmt.setString(1, withdraw);
		pstmt.setString(2, id);
		
		cnt = pstmt.executeUpdate();
		
		}finally {
			dc.dbClose(con, pstmt, null);
			}
		
		return cnt;
		}
	
	public String selectWithdraw(String id)throws SQLException{
		String withdraw = "";
		
		UserDBConnection dc =UserDBConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		con = dc.getConn();
		
		String selectQuery = "select MEMBER_WITHDRAWAL from MEMBER where MEMBER_ID = ?";
		pstmt = con.prepareStatement(selectQuery);
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			withdraw = rs.getString("MEMBER_WITHDRAWAL");
		}
		
		}finally {
			dc.dbClose(con, pstmt, rs);
		}
		return withdraw;
	}
	
}//class


