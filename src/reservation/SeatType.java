package reservation;

public abstract class SeatType {
	
	public String[][] A21N = new String[6][30];
	public String[][] A321 = new String[6][43];
	public String[][] AT75 = new String[4][17];
	public String[][] B738 = new String[6][31];
	public String[][] A320 = new String[6][36];


	public abstract boolean seatSelect(String seat);
	

	public abstract boolean seatCancel(String seat);

	public String[][] seatSearch(RseatVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
