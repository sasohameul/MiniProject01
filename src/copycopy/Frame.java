package copycopy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel ("원하시는 메뉴를 선택해주세요");
		JButton btn = new JButton();
		JButton btn1 = new JButton("1. 좌석 예약");
		JButton btn2 = new JButton("2. 좌석 취소");
		JButton btn3 = new JButton("3. 종료");
		JPanel btn1Panel = new JPanel();
		
		
		panel.setLayout(new BorderLayout());
		panel.add(label, BorderLayout.PAGE_START);
		panel.add(btn, BorderLayout.CENTER );
		panel.add(btn1Panel, BorderLayout.CENTER);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				main(args);
			}
			
			
		});
		
		btn3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
			
		});
		btn1Panel.add(btn1);
		btn1Panel.add(btn2);
		btn1Panel.add(btn3);
		
		
		frame.add(panel);
		
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000,1000/12*9));
		frame.setSize(1000,1000/12*9);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		
		
		
		
		
	}

}
