package signup.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class NonMemberInsert {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("비회원");
		System.out.println("---------------------------");
		
		System.out.print("이름: ");
		String name = scan.next();
		
		System.out.print("EMAIL: ");
		String email= scan.next();
		
		String url = "jdbc:oracle:thin:@172.30.1.51:1521:xe";
		String uid = "FIGHTING";
		String upw = "1234";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO NONMEMBER (NONMEMBER_NUM, NAME, EMAIL) VALUES (?,?,?)";
				
				try {
					
					Class.forName("oracle.jdvc.driver.OracleDriver");
					
					conn = DriverManager.getConnection(url,uid,upw);
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, RandomMemberNum());
					pstmt.setString(2, name);
					pstmt.setString(3, email);
					
					pstmt.executeUpdate();
					
				} catch (Exception e) {

					e.printStackTrace();
				} finally {
					
				try {
					
					conn.close();
					pstmt.close();
					
				} catch (SQLException e) {

					e.printStackTrace();
				}
					
				}
				
	}
	
	
	
	
	public static String RandomMemberNum() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String result = alphabet + numbers;
        
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        
        for(int i = 0; i < 6; i++) {
            int index = random.nextInt(result.length());
            char randomChar = result.charAt(index);
            randomString.append(randomChar);
        }
        
        return randomString.toString();
	} 
	
	
}
