package signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NonMemberDAO {

	String url = "jdbc:oracle:thin:@172.30.1.51:1521:xe";
	String uid = "TEAM01";
	String upw = "1234";

	public NonMemberDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CLASS FOR NAME ERR");
		}

	}

	public int insertNon(NonMemberVO vo) {

		int result = 0;

		String sql = "INSERT INTO NONMEMBER (NONMEMBER_NUM, NAME, EMAIL) VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url,uid,upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNonmember_num());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				conn.close();
				pstmt.close();
				
			} catch (Exception e2) {

				e2.printStackTrace();
			}
			
		}
		
		
		
		return result;


	}



}



