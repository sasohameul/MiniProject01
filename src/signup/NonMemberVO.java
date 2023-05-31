package signup;

public class NonMemberVO {
	

	private String nonmember_num;
	private String name;
	private String email;
	
	public NonMemberVO() {

	}

	public NonMemberVO(String nonmember_num, String name, String email) {
		super();
		this.nonmember_num = nonmember_num;
		this.name = name;
		this.email = email;
	}
	
	public String getNonmember_num() {
		return nonmember_num;
	}

	public void setNonmember_num(String nonmember_num) {
		this.nonmember_num = nonmember_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	
	

}
