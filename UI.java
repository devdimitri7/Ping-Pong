package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import javax.swing.JPanel;

public class UI extends JPanel {
	
	Pong pon;
	public String score1 = "Score Computer : ";
	public String score2 = "Score Player : ";
	Font arial_40;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(Pong pon) {
		this.pon = pon;
		arial_40 = new Font("Arial", Font.PLAIN, 30);
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(Color.white);
		g.setFont(arial_40);
		g.drawString(score1 + pon.score1 , 430, 90);
		
		g.setColor(Color.black);
		g.setFont(arial_40);
		g.drawString(score2 + pon.score2, 110, 90);
		
		/*if(pon.score2 == 2) {
			
			g.setColor(Color.black);
			g.setFont(arial_40);
			g.drawString("Player a gagne !", 300, 70);
			
		}*/
	}

}
