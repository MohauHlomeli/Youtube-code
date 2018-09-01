import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField screen;
	double firstnumber;
	double secondnumber;
	String operator;
	double answer;
	String finalAnswer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					Calculator frame = new Calculator();
					frame.setResizable(false);
					frame.setTitle("Hauza's Calculator");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		screen = new JTextField();
		screen.setHorizontalAlignment(SwingConstants.TRAILING);
		screen.setFont(new Font("Tahoma", Font.BOLD, 34));
		screen.setEditable(false);
		screen.setBounds(10, 11, 370, 67);
		contentPane.add(screen);
		screen.setColumns(10);
		
		final JButton sevenbt = new JButton("7");
		sevenbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + sevenbt.getText();
				screen.setText(num);
			}
		});
		sevenbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		sevenbt.setBounds(10, 123, 85, 31);
		contentPane.add(sevenbt);
		
		final JButton eightbt = new JButton("8");
		eightbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + eightbt.getText();
				screen.setText(num);
			}
		});
		eightbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		eightbt.setBounds(105, 123, 85, 31);
		contentPane.add(eightbt);
		
		final JButton ninebt = new JButton("9");
		ninebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + ninebt.getText();
				screen.setText(num);
			}
		});
		ninebt.setFont(new Font("Tahoma", Font.BOLD, 20));
		ninebt.setBounds(201, 123, 85, 31);
		contentPane.add(ninebt);
		
		JButton divbt = new JButton("/");
		divbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstnumber = Double.parseDouble(screen.getText());
				screen.setText(" ");
				operator = "/";
			}
		});
		divbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		divbt.setBounds(295, 123, 85, 31);
		contentPane.add(divbt);
		
		final JButton fourbt = new JButton("4");
		fourbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + fourbt.getText();
				screen.setText(num);
			}
		});
		fourbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		fourbt.setBounds(10, 209, 85, 31);
		contentPane.add(fourbt);
		
		final JButton fivebt = new JButton("5");
		fivebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + fivebt.getText();
				screen.setText(num);
			}
		});
		fivebt.setFont(new Font("Tahoma", Font.BOLD, 20));
		fivebt.setBounds(105, 209, 85, 31);
		contentPane.add(fivebt);
		
		final JButton sixbt = new JButton("6");
		sixbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + sixbt.getText();
				screen.setText(num);
			}
		});
		sixbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		sixbt.setBounds(201, 209, 85, 31);
		contentPane.add(sixbt);
		
		JButton multibt = new JButton("x");
		multibt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstnumber = Double.parseDouble(screen.getText());
				screen.setText(" ");
				operator = "x";
			}
		});
		multibt.setFont(new Font("Tahoma", Font.BOLD, 20));
		multibt.setBounds(295, 209, 85, 31);
		contentPane.add(multibt);
		
		final JButton onebt = new JButton("1");
		onebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + onebt.getText();
				screen.setText(num);
			}
		});
		onebt.setFont(new Font("Tahoma", Font.BOLD, 20));
		onebt.setBounds(10, 285, 85, 31);
		contentPane.add(onebt);
		
		final JButton twoobt = new JButton("2");
		twoobt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + twoobt.getText();
				screen.setText(num);
			}
		});
		twoobt.setFont(new Font("Tahoma", Font.BOLD, 20));
		twoobt.setBounds(105, 285, 85, 31);
		contentPane.add(twoobt);
		
		final JButton threebt = new JButton("3");
		threebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + threebt.getText();
				screen.setText(num);
			}
		});
		threebt.setFont(new Font("Tahoma", Font.BOLD, 20));
		threebt.setBounds(201, 285, 85, 31);
		contentPane.add(threebt);
		
		JButton minusbt = new JButton("-");
		minusbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstnumber = Double.parseDouble(screen.getText());
				screen.setText(" ");
				operator = "-";
			}
		});
		minusbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		minusbt.setBounds(295, 285, 85, 31);
		contentPane.add(minusbt);
		
		final JButton zerobt = new JButton("0");
		zerobt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + zerobt.getText();
				screen.setText(num);
				
			}
		});
		zerobt.setFont(new Font("Tahoma", Font.BOLD, 20));
		zerobt.setBounds(10, 366, 85, 31);
		contentPane.add(zerobt);
		
		JButton posbt = new JButton("+/-");
		posbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		posbt.setBounds(105, 366, 85, 31);
		contentPane.add(posbt);
		
		final JButton dotbt = new JButton(".");
		dotbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = screen.getText() + dotbt.getText();
				screen.setText(num);
			}
		});
		dotbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		dotbt.setBounds(201, 366, 85, 31);
		contentPane.add(dotbt);
		
		final JButton plusbt = new JButton("+");
		plusbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstnumber = Double.parseDouble(screen.getText());
				screen.setText(" ");
				operator = "+";
				
			}
		});
		plusbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		plusbt.setBounds(295, 366, 85, 31);
		contentPane.add(plusbt);
		
		JButton equalbt = new JButton("=");
		equalbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secondnumber = Double.parseDouble(screen.getText());
				if(operator == "+"){
					answer = firstnumber + secondnumber;
					finalAnswer = String.format("%.0f", answer);
					screen.setText(finalAnswer);
					
				} else if(operator == "-"){
					answer = firstnumber - secondnumber;
					finalAnswer = String.format("%.0f", answer);
					screen.setText(finalAnswer);
				} else if(operator == "x"){
					answer = firstnumber * secondnumber;
					finalAnswer = String.format("%.0f", answer);
					screen.setText(finalAnswer);
				} else if(operator == "/"){
					answer = firstnumber / secondnumber;
					//finalAnswer = String.format("%.0f", answer);
					screen.setText(String.valueOf(answer));
				}
			}
		});
		equalbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		equalbt.setBounds(10, 434, 370, 31);
		contentPane.add(equalbt);
		
		JButton cbt = new JButton("C");
		cbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				screen.setText(" ");
			}
		});
		cbt.setFont(new Font("Tahoma", Font.BOLD, 20));
		cbt.setBounds(10, 81, 85, 31);
		contentPane.add(cbt);
	}
}
