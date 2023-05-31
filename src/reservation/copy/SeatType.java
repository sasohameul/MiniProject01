package reservation.copy;

public interface SeatType {
	
	public String[][] A21N = new String[6][30];
	public String[][] A321 = new String[6][43];
	public String[][] AT75 = new String[4][17];
	public String[][] B378 = new String[6][31];
	public String[][] A320 = new String[8][27];

	public void seatMap();

	public void seatSelect(char rowCount, int colCount);
	public void printSeatMap();
	public void seatCancel(char rowCount, int colCount);
	
}
