import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class RunGame{
	
	
	public RunGame(){
		JFrame frame = new JFrame();
		BattleCity game = new BattleCity();

		JLabel player1lab = new JLabel("PLAYER 1: ",JLabel.CENTER);
		JLabel player2lab = new JLabel("PLAYER 2: ",JLabel.CENTER);
		JButton button = new JButton("BACK to MENU");
		button.setBounds(700,630, 150, 30);

		
		
		player1lab.setForeground(Color.black);
		player1lab.setBounds(700,100,150,35);
		frame.add(player1lab);
		
		player2lab.setForeground(Color.black);
		player2lab.setBounds(700,400,150,35);
		frame.add(player1lab);
		frame.add(player2lab);
		frame.add(button);
	
		frame.add(game);
		
		
		
		frame.setSize(BattleCity.WIDTH, BattleCity.HEIGHT);
		frame.setTitle(BattleCity.title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		
		
}

		public static void main(String[] args) { // Main method 
			new RunGame();
		}

		/*public void actionPerformed(ActionEvent e) {
		if(e.getID() == button.this){
			
		}
		}*/

	
}