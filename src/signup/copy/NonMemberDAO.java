package signup.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NonMemberDAO {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "FIGHTING";
	private String upw = "1234";
	
	public NonMemberDAO() {

		try {
			
			Class.forName("orcale.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}	
		public int insertNM (NonMemberVO VO) {
			
			int result = 0;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO NONMEMBER (NONMEMBER_NUM, NAME, EMAIL) VALUES (?, ?, ?)";
			
					try {
						
						conn = DriverManager.getConnection(url, uid, upw);
						
						pstmt.setString(1, VO.getNonmember_num());
						pstmt.setString(2, VO.getName());
						pstmt.setString(3, VO.getEmail());
						
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
	

	
	

