package signup;

import java.util.regex.Pattern;

public class MemberException {
	
	//id 
	public boolean idFormat(String str) {
		boolean result = false;
		if(str.length() <5 || str.length() >13) {
			result = true;
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
			result = false;
		}
		
		return result;
		
		
	}
	
	//pw
	public boolean pwCheck(String pw) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		boolean result = false;
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
			result = false;	
		}
		return result;
		
	}
	
	//이름확인
	public boolean h_nameCheck (String h_name){
		boolean result = false;
		boolean check = Pattern.matches("[가-힣]*$", h_name);
		if(!check){
			result = false;
		}
		return result;
	}
	//영문이름
	public boolean e_nameCheck (String e_name) {
		boolean result = false;
		boolean check = Pattern.matches("^[a-zA-Z]*$", e_name);
		if(!check){
			result = false;
		}
		return result;
	}
	
	//주민번호
	public boolean dobCheck (String d_o_b) {
		boolean result = false;
		boolean check = Pattern.matches("^\\d{6}\\-\\d{7}$", d_o_b);
		if(!check) {
			result = false;
		}
		return result;
	}
	
	//성별
	public boolean genderCheck (String gender) {
		boolean result = false;
		if(!gender.equals("M") && !gender.equals("F")) {
			result = false;
		}
		return result;
	}
	
	//이메일
	public boolean emailCheck (String email) {
		boolean result = false;
		boolean check = Pattern.matches("^[a-zA-Z0-9_+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", email);
		if(!check) {
			result = false;
		}
		return result;
	}
	
	//휴대폰번호
	public boolean phoneCheck (String phone)  {
		boolean result = false;
		boolean check = Pattern.matches("(\\d{3})-(\\d{4})-(\\d{4})", phone);
		if(!check) {
			result = false;
		}
		return result;
	}
	
}












