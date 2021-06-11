package LookBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
		try {
			conn = udc.getConn();
			
			String insertQuery = "insert into lookbook values(seq_lookbook.nextval, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setString(1, lbwVO.getLbw_id());
			pstmt.setString(2, lbwVO.getLbw_title());
			pstmt.setString(3, lbwVO.getLbw_write_date());
			pstmt.setString(4, lbwVO.getLbw_content());
			
			
			pstmt.executeUpdate();
			
		} finally {
			udc.dbClose(conn, pstmt, null);
		}//end finally

	}//insertPost
	
	/**
	 * 상세글보기 - 글작성자, 글내용+이미지(CLOB), 타이틀(제목), 작성일 select
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public LBWriteVO selectOnePost(int num)throws SQLException{
		  LBWriteVO lbwVO =null;
	      
	      Connection con=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      BufferedReader br=null;
	      
	      UserDBConnection dc= UserDBConnection.getInstance();
	      
	      try {  
	      //1.JNDI사용객체 생성
	      //2.DBCP에서 DB연결객체얻기
	      //3.DB연결 객체에서 Connection얻기
	         con=dc.getConn();
	      
	      //4.쿼리문 생성객체 얻기
	         String selectFile="select MEMBER_ID, LB_TITLE, LB_WRITE_DATE, LB_CONTENTS from LOOKBOOK where LB_POSTS_NUM=?";
	         pstmt=con.prepareStatement(selectFile);
	         
	      //5.바인드 변수에 값 설정
	         pstmt.setInt(1,num);
	         
	      //6.쿼리문수행
	         rs=pstmt.executeQuery();
	        
	         
	         if(rs.next()) {//입력된 num으로 조회된 결과 있으면 next
	        	 lbwVO =new LBWriteVO(); //이름,노트가 들어있는 VO
	        	 lbwVO.setLbw_id(rs.getString("MEMBER_ID"));
	        	 lbwVO.setLbw_title(rs.getString("LB_TITLE"));
	        	 lbwVO.setLbw_write_date(rs.getString("LB_WRITE_DATE"));
	        	
	            //Clob은 별도의 Stream을 이용하여 읽어들인다
	            Clob clob=rs.getClob("LB_CONTENTS");
	            
	            if(clob!=null) {
	            br = new BufferedReader(rs.getClob("LB_CONTENTS").getCharacterStream());//스트림연결
	            
	            try {
	               String temp="";
	               StringBuilder sbFileData=new StringBuilder();
	               while((temp=br.readLine())!=null) {
	                  sbFileData.append(temp);
	               }//while
	               
	               lbwVO.setLbw_content(sbFileData.toString());
	               //글을 읽어들인 스트림을 끊는다
	               if(br!=null) {br.close();}//if
	            }catch(IOException ie) {
	               ie.printStackTrace();
	            }//catch
	         }//if
	      }//if
	         
	      }finally {//7.연결끊기
	    	  dc.dbClose(con, pstmt, rs);
	      }//finally
	      
	      return lbwVO;
	   }//selectFile
	
	/**
	 * 글 수정
	 * @param lbmVO
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePost(LBModifyVO lbmVO) throws SQLException {
		boolean flag = false;
		
		UserDBConnection udc = UserDBConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = udc.getConn();
			
			String updateQuery = "update lookbook set lb_contents = ?, lb_write_date = ?, lb_title = ? where lb_posts_num = ? and member_id = ?";
			
			pstmt = conn.prepareStatement(updateQuery);
			
			pstmt.setString(1, lbmVO.getLbw_content());
			pstmt.setString(2, lbmVO.getLbw_write_date());
			pstmt.setString(3, lbmVO.getLbw_title());
			pstmt.setInt(4, lbmVO.getLbw_num());
			pstmt.setString(5, lbmVO.getLbw_id());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}//end if

		} finally {
			udc.dbClose(conn, pstmt, rs);
		}//end finally
		
		return flag;
	}//updatePost
	
	/**
	 * 글 삭제
	 * @param lb_posts_num
	 * @return
	 * @throws SQLException
	 */
	public boolean deletePost(int lb_posts_num) throws SQLException {
		boolean flag = false;
		
		UserDBConnection udc = UserDBConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = udc.getConn();
			
			String deleteQuery = "delete from lookbook where lb_posts_num = ?";
			
			pstmt = conn.prepareStatement(deleteQuery);
			
			pstmt.setInt(1, lb_posts_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}//end if
			
		} finally {
			
		}//end finally
		
		return flag;
	}//deletePost
	
	
	/**
	 * 글 미리보기(룩북 메인창)
	 * @return
	 * @throws SQLException
	 */
	public List<LBListVO> selectAllPost() throws SQLException{
		List<LBListVO> lbList = null;
		
		UserDBConnection udc = UserDBConnection.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = udc.getConn();
			
			String selecQueryAll = "select lb_posts_num, lb_title, lb_contents, lb_write_Date, member_id from lookbook order by lb_posts_num desc";
			
			pstmt = conn.prepareStatement(selecQueryAll);
			
			rs = pstmt.executeQuery();
			
			LBListVO lblVO = new LBListVO();
			lbList = new ArrayList<LBListVO>();
			while(rs.next()) {
				lblVO = new LBListVO(rs.getInt("lb_posts_num"), rs.getString("lb_title"), rs.getString("lb_contents"), rs.getString("lb_write_Date"), rs.getString("member_id"));
				lbList.add(lblVO);
			}//end while
		} finally {
			udc.dbClose(conn, pstmt, rs);
		}//end finally
		
		return lbList;
	}//selectAllPost
	
}//class
