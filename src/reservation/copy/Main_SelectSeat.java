package reservation.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_SelectSeat extends Frame{

	public static void main(String[] args) {


		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

			A321 s = new A321();
			s.seatMap();

			while(true) {

				s.printSeatMap();

				System.out.println();
				System.out.println("원하시는 메뉴를 선택해주세요.");
				System.out.println("[ 1. 좌석 예약 | 2. 좌석 취소 | 3. 종료 ]");
				System.out.print("> ");

				String a = br.readLine();

				switch (a) {

				case "1":

					System.out.print("예약하실 좌석을 입력해주세요> ");
					String sn = br.readLine().replace(" ", "");

					if(sn.length() == 2) {

						int c = sn.charAt(0) - '0';
						char r = sn.charAt(1);

						s.seatSelect(r, c);

					} else if(sn.length() == 3) {

						String cc = sn.substring(0, 2);
						int c = Integer.parseInt(cc);
						char r = sn.charAt(2);

						s.seatSelect(r, c);

						System.out.println("======================================================================================================");

					}

					break;

				case "2":

					System.out.print("예약하실 좌석을 입력해주세요> ");
					String snc = br.readLine();

					if(snc.length() == 2) {

						int c = snc.charAt(0) - '0';
						char r = snc.charAt(1);

						s.seatCancel(r, c);

					} else if(snc.length() == 3) {

						String cc = snc.substring(0, 2);
						int c = Integer.parseInt(cc);
						char r = snc.charAt(2);

						s.seatCancel(r, c);

					}


					System.out.println("=========================================================================================================================================");


					break;

				case "3": 
					
				System.out.println(" *** 좌석 예약이 종료되었습니다. ***");
				System.exit(0);

				break;

				default:

					System.out.println("다시 선택해 주세요.");

					break;
				}

			}

		} catch (Exception e) {

		}

	}

}
