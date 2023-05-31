package signup.copy;

public class MemberVO {

	private String member_num;
	private String id;
	private String pw;
	private String h_name;
	private String e_name;
	private String d_o_b;
	private String gender;
	private String email;
	private String phonenum;
	private String grade;
	
	
	public MemberVO() {
		
	}

	//생성자
	public MemberVO(String member_num,String id, String pw, String h_name, String e_name, String d_o_b, String gender,
			String email, String phonenum, String grade) {
		super();
		
		this.member_num = member_num;
		this.id = id;
		this.pw = pw;
		this.h_name = h_name;
		this.e_name = e_name;
		this.d_o_b = d_o_b;
		this.gender = gender;
		this.email = email;
		this.phonenum = phonenum;
		this.grade = grade;
	}

	
	
	//getter , setter
	
	
	public String getMember_num() {
		return member_num;
	}

	public void setMember_num(String member_num) {
		this.member_num = member_num;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getD_o_b() {
		return d_o_b;
	}

	public void setD_o_b(String d_o_b) {
		this.d_o_b = d_o_b;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
	
	
	
}









