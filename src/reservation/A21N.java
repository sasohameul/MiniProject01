package reservation;

public class A21N extends SeatType{

	String seat;

	RseatDAO rDAO = new RseatDAO();
	RseatVO rVO = new RseatVO();

	String[][] str = new String[6][30]; //좌석번호 담은 배열 (1A~30F)
	int[][] seatCount = new int[6][30]; //좌석 reserved or empty

	public A21N() {

		//좌석번호 담은 배열 (1A~30F)

		for(int i = 0; i < str.length; i++) {

			for(int j = 0; j < str[i].length; j++) {

				char k = (char)(i+65);

				str[i][j] = j+1 + "" + k;

			}

		}

		//좌석 0 으로 초기화. 후에 SQL로 연결시 str배열 인덱스와 동일한 seat no.있으면 1로 값 변경 할 것.

		for(int i = 0; i < seatCount.length; i++) {

			for(int j = 0; j < seatCount[i].length; j++) {

				if(rVO.getFlights().equals("A21N") && rVO.getReserved_seat_num().equals(str[i][j])) {

					seatCount[i][j] = 1;

				} else {

					seatCount[i][j] = 0;
				}


			}


		}


	}

	public boolean seatSelect(String seat) {

		this.seat = seat;

		for(int i = 0; i < str.length; i++) {

			for(int j = 0; j < str[i].length; j++) {

				if(str[i][j].equals(seat) && seatCount[i][j] == 1) {

					return false;

				} else seatCount[i][j] = 1;
			}


		}

		return true;
	}

	public boolean seatCancel(String seat) {

		this.seat = seat;

		for(int i = 0; i < str.length; i++) {

			for(int j = 0; j < str[i].length; j++) {

				if(str[i][j].equals(seat) && seatCount[i][j] == 1) {

					seatCount[i][j] = 0;

					return true;

				} 
			}

		}

		return false;
	}


}
