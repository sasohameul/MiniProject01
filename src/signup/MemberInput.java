package signup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MemberInput {
	Scanner scan = new Scanner(System.in);
	MemberDAO DAO = new MemberDAO();
	
	MemberException ME = new MemberException();
	
	//회원가입
	public void insert() throws AuthenException{
		
		
		String member_num;
		boolean id = true;
		boolean pw = true;
		boolean h_name = true;
		boolean e_name = true;
		boolean d_o_b = true;
		boolean gender = true;
		boolean email = true;
		boolean phonenum = true;
		String grade = "BA";
		
		while(true) {
			System.out.println("회원가입");
			System.out.println("-----------------------------");
		
			try {
				MemberVO VO = new MemberVO();
				//아이디
				do {
					try {
						System.out.print("아이디: ");
						VO.setId(scan.next());
						ME.idFormat(VO.getId());
					//	DAO.idcheck(VO.getId());
						id = false ;
					} catch (Exception e) {
						System.out.println(e.toString());
					}		
				}while(id);
				
				//비밀번호
				do {
					try {
						System.out.print("비밀번호: ");
						VO.setPw(scan.next());
						ME.pwCheck(VO.getPw());
						
						pw = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				} while (pw);
				
				//한글이름
				do {
					try {
						System.out.print("한글이름: ");
						VO.setH_name(scan.next());
						ME.h_nameCheck(VO.getH_name());
						
						h_name = false;
						
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				} while (h_name);
			
				
				//영문이름
				do {
					try {
						System.out.print("영문이름: ");
						VO.setE_name(scan.next());
						ME.e_nameCheck(VO.getE_name());
						
						e_name = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				} while (e_name);
				
				
				//주민번호
				do {
					try {
						System.out.print("주민번호: ");
						VO.setD_o_b(scan.next());
						ME.dobCheck(VO.getD_o_b());
						
						d_o_b = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				} while (d_o_b);
				
				//성별
				do {
					try {
						System.out.print("성별[M/F]: ");
						VO.setGender(scan.next());
						ME.genderCheck(VO.getGender());
						
						gender = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				} while (gender);
				
				//이메일
				do {
					try {
						System.out.print("이메일: ");
						VO.setEmail(scan.next());
						ME.emailCheck(VO.getEmail());
						
						email = false;
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				} while (email);
				
				
				//휴대폰 번호
				do {
					try {
						System.out.print("휴대폰번호: ");
						VO.setPhonenum(scan.next());
						ME.phoneCheck(VO.getPhonenum());
						
						phonenum = false;
						
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				} while (phonenum);
				
				String Member_num = DAO.RandomMemberNum();
				VO.setMember_num(Member_num);
				
				VO.setGrade(grade);
				
				int result = DAO.insertMember(VO);
				
				if(result!=0) {
					System.out.println();
					System.out.println("회원가입이 완료되었습니다");
					System.out.println();
					System.out.println("당신의 회원번호는:" + Member_num + "입니다");
					System.out.println("등급 :" + grade);
					
					System.out.println("--------[회원가입확인]-------");
					
				}else {
					System.out.println("회원가입에 실패하였습니다");
				}
				
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}break;
		}
		
	}

	
	
	public void login () {
		Scanner scan = new Scanner(System.in);
		System.out.println("로그인");
		System.out.println("-----------------------------");
		
		System.out.print("아이디: ");
		String id = scan.next();
		
		System.out.print("비밀번호: ");
		String pw = scan.next();
		
		MemberVO member = DAO.login(id, pw);
		
		if(member != null) {
			System.out.println("로그인에 성공하였습니다");
		}else {
			System.out.println("아이디 혹은 비밀번호가 잘못되었습니다");
		}
		
	}
	
	
	
}









