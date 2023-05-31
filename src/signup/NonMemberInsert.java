package signup;

import java.util.Random;
import java.util.Scanner;

public class NonMemberInsert extends MemberInput{
	
	public void login () {
		
		Scanner scan = new Scanner(System.in);
		
		NonMemberDAO ndao = new NonMemberDAO();
		MemberException me = new MemberException();
		
		System.out.println("비회원");
		System.out.println("-----------------------------");
		
		System.out.print("이름: ");
		String name = scan.next();
		
		System.out.print("EMAIL: ");
		String email = scan.next();
		me.emailCheck(email);
		
		NonMemberVO nvo = new NonMemberVO(DAO.RandomMemberNum(), name, email );
		
		ndao.insertNon(nvo);
		System.out.println(name + "의 비회원 번호는 " + DAO.RandomMemberNum() + "입니다.");
		
	}
	
	
	
	
	
	
}
