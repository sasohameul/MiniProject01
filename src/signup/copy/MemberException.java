package signup.copy;

import java.util.regex.Pattern;

public class MemberException {
	
	//id 
	public void idFormat(String str) throws AuthenException {
		if(str.length() <5 || str.length() >13) {
			throw new AuthenException("5~13자 이내의 아이디만 가능합니다");
		}
	
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				count1 ++;	
			}else if (c>='0' && c <= '9') {
				count2++;
			}
		}
		if(count1==0 || count2 == 0) {
			throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요");
		}
		
	
		
		
	}
	
	//pw
	public void pwCheck(String pw) throws AuthenException {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		String sc = "!@$^&";
		
		for(int i = 0; i < pw.length(); i++) {
			char c = pw.charAt(i);
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				count1 ++;	
			}else if (c>='0' && c <= '9') {
				count2++;
			}else if(sc.indexOf(c) != -1) { //indexof메소드에서는 sc.indexOf(c) != -1 문자c가 문자열 sc안에 포함되어 있다는 뜻
				count3 ++;
			}
		}
		if(count1==0||count2==0 || count3 ==0) {
			throw new AuthenException("비밀번호는 영어와 숫자 특수문자 !,@,$,^,&을 혼용해서 만들어주세요");
		}
	}
	
	//이름확인
	public void h_nameCheck (String h_name) throws AuthenException {
		boolean check = Pattern.matches("[가-힣]*$", h_name);
		if(!check){
			throw new AuthenException("한글이름은 한글로 입력해주세요");
		}
	}
	//영문이름
	public void e_nameCheck (String e_name) throws AuthenException {
		boolean check = Pattern.matches("^[a-zA-Z]*$", e_name);
		if(!check){
			throw new AuthenException("영문이름은 영어로 입력해주세요");
		}
	}
	
	//주민번호
	public void dobCheck (String d_o_b) throws AuthenException {
		boolean check = Pattern.matches("^\\d{6}\\-\\d{7}$", d_o_b);
		if(!check) {
			throw new AuthenException("주민번호형식은 XXXXXX-XXXXXXX 입니다" );
		}
	}
	
	//성별
	public void genderCheck (String gender) throws AuthenException {
		if(!gender.equals("M") && !gender.equals("F")) {
			throw new AuthenException("성별은 여성은 - F 남성은 - M 로 입력해주세요");
		}
	}
	
	//이메일
	public void emailCheck (String email) throws AuthenException {
		boolean check = Pattern.matches("^[a-zA-Z0-9_+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", email);
		if(!check) {
			throw new AuthenException("이메일형식은 XXX@XXXXX.XXX 입니다" );
		}
	}
	
	//휴대폰번호
	public void phoneCheck (String phone) throws AuthenException {
		boolean check = Pattern.matches("(\\d{3})-(\\d{4})-(\\d{4})", phone);
		if(!check) {
			throw new AuthenException("전화번호형식은 [XXX-XXXX-XXXX] 입니다");
		}
	}
	
}












