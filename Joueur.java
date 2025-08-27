package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Joueur extends JPanel {
	
	Pong pon;
	Control ct;
	public int x = 107;
	public int y = 170;
	String move = "haut";
	int speed = 5;
	int spriteCounter = 0;
	int spriteNum = 1;
	int spriteSpeed = 10;
	
	public BufferedImage img;
	
	public Rectangle rectJr;
	
	public Joueur(Pong pon, Control ct) {
		this.pon = pon;
		this.ct = ct;
		
		rectJr = new Rectangle(x, y, 20, 90);
		
		getImage();
		
	}
	
	public void getImage() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/player/player.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if(ct.haut == true || ct.bas == true) {
			if(ct.haut == true) {
				move = "haut";
				y -= speed;
			}
			if(ct.bas == true) {
				move = "bas";
				y += speed;
			}
			
			if(y < 107) {
				y = 107;
			}
			else if(y > 354) {
				y = 354;
			}
			
			rectJr.setBounds(x, y, 20, 90);
			
			spriteCounter++;
			if(spriteCounter >= spriteSpeed) {
				spriteNum++;
				if(move.equals("haut") && spriteNum > 1) {
					spriteNum = 1;
				}
				else if(move.equals("bas") && spriteNum > 1) {
					spriteNum = 1;
				}
				spriteCounter = 0;
				
			}
			
		}
	}
	
	public void draw(Graphics2D g) {
		BufferedImage timg = null;
		
		if(move.equals("haut")) {
			if(spriteNum == 1) {
				timg = img;
			}
		}
		else if(move.equals("bas")) {
			if(spriteNum == 1) {
				timg = img;
			}
		}
		
		g.setColor(Color.white);
		g.drawImage(timg, x, y, 20, 90, null);
	}

}
