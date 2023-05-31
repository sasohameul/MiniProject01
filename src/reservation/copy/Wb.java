package reservation.copy;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Font;

public class Wb {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wb window = new Wb();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Wb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(1000,1000/12*9);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBounds(0, 10, 950, 621);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("원하시는 메뉴를 선택해주세요");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(401, 236, 280, 42);
		panel.add(lblNewLabel);
		
		JButton btn1 = new JButton("1. 좌석 예약");
		btn1.setFont(new Font("굴림", Font.PLAIN, 18));
		btn1.setBounds(264, 327, 182, 38);
		panel.add(btn1);
		
		JButton btn2 = new JButton("2. 좌석 취소");
		btn2.setFont(new Font("굴림", Font.PLAIN, 18));
		btn2.setBounds(458, 327, 165, 38);
		panel.add(btn2);
		
		JButton btn3 = new JButton("3. 종료");
		btn3.setFont(new Font("굴림", Font.PLAIN, 18));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBounds(635, 327, 133, 38);
		panel.add(btn3);
		
	}
}
