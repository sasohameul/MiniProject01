package signup.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	String url = "jdbc:oracle:thin:@172.30.1.51:1521:xe";
	String uid = "TEAM01";
	String upw = "1234";
	
	
	Connection conn =null ; // 데이터베이스에 접근할 수 있도록 설정해주는 객체
	PreparedStatement pstmt=null; //데이터베이스에서 쿼리를 실행시켜주는 객체
	ResultSet rs=null ; // 데이터 베이스 테이블의 결과를 리턴받아 자바에 저장해주는 객체 
	
	//생성자 데이터 베이스에 접근할 수 있도록 도와주는 메서드
	public MemberDAO() {
		try {
			// 해당 데이터베이스를 사용한다고 선언 
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
			e.printStackTrace();
		}
	}
	
	
	//인서트메서드 데이터베이스에 한 사람의 회원 정보를 저장해주는 메서드
	public int insertMember(MemberVO VO ) {
		
		int result = 0;
		

		
		String sql = "INSERT INTO MEMBERS(MEMBER_NUM,ID,PW,H_NAME,E_NAME,D_O_B,GENDER,EMAIL,PHONENUM,GRADE)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?,?,? )";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, VO.getMember_num());	
			pstmt.setString(2, VO.getId());
			pstmt.setString(3, VO.getPw());
			pstmt.setString(4, VO.getH_name());
			pstmt.setString(5, VO.getE_name());
			pstmt.setString(6, VO.getD_o_b());
			pstmt.setString(7, String.valueOf(VO.getGender()) );
			pstmt.setString(8, VO.getEmail());
			pstmt.setString(9, VO.getPhonenum());
			pstmt.setString(10, VO.getGrade());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public List<MemberVO> getMember(){
		
		List<MemberVO> list = new ArrayList<>();
		//쿼리준비
		String sql = "SELECT * FROM MEMBERS";
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//쿼리실행객체준비
			pstmt = conn.prepareStatement(sql);
			//결과를 리턴해서 쿼리를 실행 시킬 결과를 리턴해서 받아줌
			rs = pstmt.executeQuery();
			
			//반복문을 사용해서 rs 에 저장된 데이터를 추출
			while(rs.next()) { //저장된 데이터만큼 반복문을 돌린다
				//세트로 불러오기 위해 MemberVO를 객체로 받아온다
				MemberVO mv = new MemberVO();
				mv.setMember_num(rs.getString(1));
				mv.setId(rs.getString(2));
				mv.setPw(rs.getString(3));
				mv.setH_name(rs.getString(4));
				mv.setE_name(rs.getString(5));
				mv.setD_o_b(rs.getString(6));
				mv.setGender(rs.getString(7));
				mv.setEmail(rs.getString(8));
				mv.setPhonenum(rs.getString(9));
				mv.setGrade(rs.getString(10));
				//패키징 완료 
				//resultset객체로 데이터를 받아와서 멤버vo로 패키징
				
				list.add(mv);
			}
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	
	//로그인
	//데이터베이스에 연결하여 MEMBERS 테이블에서 사용자가 입력한 아이디와 비밀번호가 일치하는 회원을 찾음
	//일치하는 회원이 있느면 해당 회원정보를 담은 MemberVO 객체를 반환하고 그렇지 않으면 null을반환
	//
	public  MemberVO login (String id,String pw) {
		
		MemberVO member = null;
		String sql = "SELECT * FROM MEMBERS WHERE ID = ? and PW = ?";
		
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			//결과 집합 생성
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId("ID");
				member.setPw("PW");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("login sql문 오류");
			
		}finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
	
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return member;
		
		
	}
	
	public int idcheck (String id) {
		
		int result = -1;
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?"; 
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, uid, upw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
				System.out.println("중복된 아이디 입니다");
			}else {
				result = 0;
				System.out.println("사용가능한 아이디입니다");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}


	
}














