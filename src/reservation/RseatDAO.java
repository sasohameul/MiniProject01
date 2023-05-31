package reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RseatDAO {
	
	private String url = "jdbc:oracle:thin:@172.30.1.51:1521:xe";
	private String uid = "TEAM01";
	private String upw = "1234";
	
	public RseatDAO() {
		
		
		try {
			Class.forName("oracle.jdbc.driver.oracleDriver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public List<RseatVO> getRseat(String flightnum, String domnum){
		
		List<RseatVO> list = new ArrayList<>();
		
		String sql = " SELECT RESERVED_SEAT_NUM FROM R_SEAT where FLIGHTS = '?' AND DOM_NUM = '?' ";
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid,upw );
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flightnum);
			pstmt.setString(2, domnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String reserved_seat_num = rs.getString("reserved_seat_num");
								
				RseatVO vo = new RseatVO(reserved_seat_num);
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		
		} finally {
			
			try {
				conn.close();
				pstmt.close();
				rs.close();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			
		}
		
		return list;
		
		
	}
		
		
		
		
		
	}
	
	
	
	
	
	
	
