package signup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws AuthenException {
		
		Scanner scan = new Scanner(System.in);
		
		MemberInput MI = new MemberInput();
		MemberDAO DAO = new MemberDAO();
		NonMemberInsert NI = new NonMemberInsert();
		
		 while(true) {
			
			System.out.println("[1.회원가입하기 2.로그인하기 3. 비회원]");
			
			int menu = scan.nextInt();
			
			 switch (menu) {
             case 1:
                 MI.insert();
                 break;
             case 2:
                MI.login();
                 break;
            
             case 3:
            	
                 NI.login();
                 break;
            	 
             default:
                 break;

			}
			 
		}
		

				
		
	}
}
