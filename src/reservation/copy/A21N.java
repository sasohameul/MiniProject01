package reservation.copy;

public class A21N implements SeatType{

	private int rowCount;
	private int colCount;

	public A21N() {

	}
	
	
	
	
	@Override
	public void seatMap() {
		
		for(int i = 0; i < A21N.length; i++) {

			for(int j = 0; j < A21N[i].length; j++) {

				A21N[i][j] = "O";

			}

		}
		
	}

	public void seatSelect(char rowCount, int colCount) {

		try {

			this.rowCount = (char) (70 - rowCount);
			this.colCount=  colCount -1 ;

			if(A21N[this.rowCount][this.colCount].equals("O") && this.rowCount < 6 && this.colCount < 31) {

				A21N[this.rowCount][this.colCount] = "X";

				System.out.println(colCount + ""+ rowCount + " " + "좌석이 예약되었습니다.");

			} else if (A21N[this.rowCount][this.colCount].equals("X")&&this.rowCount < 6 && this.colCount < 31){

				System.out.println("선택하신 " + colCount + ""+ rowCount + " " + 
						"좌석은 이미 점유된 좌석입니다. 다른 좌석을 선택해주십시오.");

			}

			System.out.println(" ");


		} catch (Exception e) {

			System.out.println("좌석번호는 1~30 숫자와 A~F 대문자의 조합입니다. (ex.28A)");
			e.printStackTrace();


		}


	}

	public void printSeatMap() {

		int [] a = new int[30];

		for(int i = 0; i < a.length; i++) {

			a[i] = i+1;

			if(i < 10) {

				System.out.print( "   " + a[i] );

			} else if(i == 10 ) {

				System.out.print( "  " + a[i] + " ");

			}else if (i > 10) {

				System.out.print(" "+ a[i] + " ");

			}
		}

		System.out.println();

		for(int i = 0; i < A21N.length; i++) {

			if(i == 3) {

				System.out.println("==========================================================================================================================");
			} 

			char k = (char)(71 - i);
			
			k --;

			System.out.print(k + " ");

			for(int j = 0; j < A21N[i].length; j++) {

				if(A21N[i][j].equals("O")) {

					System.out.print("[ ]" + " ");

				} else if(A21N[i][j].equals("X")) {

					System.out.print("[X]" + " ");

				}
			}
			
			System.out.println();

		}

	}

	public void seatCancel(char rowCount, int colCount) {

		this.rowCount = (char) (70 - rowCount );
		this.colCount = (char) colCount-1;

		if(A21N[this.rowCount][this.colCount].equals("X")) {

			A21N[this.rowCount][this.colCount] = "O";

			System.out.println(colCount + ""+ rowCount + " " + "좌석이 취소되었습니다.");

		} else if (A21N[this.rowCount][this.colCount].equals("O")){

			System.out.println("선택하신 좌석은 빈좌석입니다.");

		}

		System.out.println();
		printSeatMap();
		System.out.println();

	}



	public int getRowCount() {
		return rowCount;
	}



	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}



	public int getColCount() {
		return colCount;
	}



	public void setColCount(int colCount) {
		this.colCount = colCount;
	}



	


}
