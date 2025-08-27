package pong;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	public Fenetre() {
		this.setTitle("Jeu de ping pong");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		
		Pong pon = new Pong();
		this.add(pon);
		pon.lets_go();
		this.pack();
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	public static void main(String[] args) {
		new Fenetre();
	}
}
