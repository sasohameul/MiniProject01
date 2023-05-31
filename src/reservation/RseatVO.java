package reservation;

public class RseatVO {
	
	private String reserved_seat_num;
	private String flights;
	private String email;
	private String dom_num;
	private int rseat_seq;
	
	public RseatVO() {
		// TODO Auto-generated constructor stub
	}

	public RseatVO(String reserved_seat_num, String flights, String email, String dom_num,int rseat_seq) {
		super();
		this.reserved_seat_num = reserved_seat_num;
		this.flights = flights;
		this.email = email;
		this.dom_num = dom_num;
		this.rseat_seq = rseat_seq;
	}

	
	public RseatVO(String reserved_seat_num) {
		
		this.reserved_seat_num = reserved_seat_num;
		
	}
	
	
	public String getReserved_seat_num() {
		return reserved_seat_num;
	}

	public void setReserved_seat_num(String reserved_seat_num) {
		this.reserved_seat_num = reserved_seat_num;
	}

	public String getFlights() {
		return flights;
	}

	public void setFlights(String flights) {
		this.flights = flights;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDom_num() {
		return dom_num;
	}

	public void setDom_num(String dom_num) {
		this.dom_num = dom_num;
	}

	public int getRseat_seq() {
		return rseat_seq;
	}

	public void setRseat_seq(int rseat_seq) {
		this.rseat_seq = rseat_seq;
	}
	
	
	
	

}
