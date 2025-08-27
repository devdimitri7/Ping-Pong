package pong;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Table extends JPanel {
	
	Pong pon;
	int x = 100;
	int y = 100;
	public int larg = 300;
	public int longu = 350;
	
	int x1 = 400;
	int y1 = 100;
	public int larg1 = 300;
	public int longu1 = 350;
	
	int x2 = 400;
	int y2 = 260;
	
	
	public Table(Pong pon) {
		this.pon = pon;
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.drawRect(x, y, larg, longu);
		
		g.setColor(Color.black);
		g.drawRect(x1, y1, larg1, longu1);
		
		
		
	}

}
