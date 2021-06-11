package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDBConnection {

	private static UserDBConnection udc;
	
	private UserDBConnection() {	
		
	}//AdminDBConnection
	
	public static UserDBConnection getInstance() {
		if(udc == null) {
			udc = new UserDBConnection();
		}//end if
		return udc;
	}//getInstance
	
	//DBCP를 사용한 DB연동 METHOD
	public Connection getConn() throws SQLException{
		Connection conn = null;
		//1. JNDI 객체 생성
		try {
			Context ctx = new InitialContext();
		//2. DBCP에서 DB와 연결하고 있는 객체 얻기
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/tkdgkdml");
		//3. DBCP에서 연결하고 있는 객체로부터 Connection 연결
			conn = ds.getConnection();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}//end catch
		
		return conn;
	}//Connection
	
	//DB 연결 끊기 METHOD
	public void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException{
		if(rs != null) {rs.close();}//end if
		if(pstmt != null) {pstmt.close();}//end if
		if(conn != null) {conn.close();}//end if
	}//dbClose
}
