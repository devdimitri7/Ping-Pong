package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Computer extends JPanel {
	
	Pong pon;
	int x = 673;
	int y = 250;
	
	BufferedImage img;
	
	private boolean move = true;
	
	public Rectangle rectCom;
	
	Ball ba;
	
	public Computer(Pong pon, Ball ba) {
		this.pon = pon;
		this.ba = ba;
		
		Timer time = new Timer(15, new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		time.start();
		
		rectCom = new Rectangle(x, y, 20, 90);
		
		
		getImage();
	}
	
	public void getImage() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/player/player2.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		
		if(ba.y < y) {
			y-=3;
			
		}
		
		if(ba.y > y) {
			y+=2;
		}
		
		rectCom.setBounds(x, y, 20, 90);
	}
			
		

	
	
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.drawImage(img, x, y, 20, 90, null);
	}
	

}
