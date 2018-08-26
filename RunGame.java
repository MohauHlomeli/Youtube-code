import javax.swing.JFrame;


public class RunGame {

		public static void main(String[] args) {
			JFrame frame = new JFrame();
			BattleCity game = new BattleCity();
			
			
			frame.add(game);
			frame.setSize(BattleCity.WIDTH, BattleCity.HEIGHT);
			frame.setTitle(BattleCity.title);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			
			frame.setVisible(true);
			
			game.start();
			


	}

}
