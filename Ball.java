package pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Ball extends JPanel {
	
	Pong pon;
	public int x = 210;
	public int y = 300;
	private boolean deplace = true;
	
	int directionX = -3;
	int directionY = -3; // -1 pour monter, 1 pour descendre
	
	public Rectangle rectBall;
	
	
	public Ball(Pong pon) {
		this.pon = pon;
		
		Timer time = new Timer(12, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		time.start();
		
		rectBall = new Rectangle(x, y, 30, 30);
	}
	
	public void update() {
		if(this.deplace) {
			
			x += directionX;

			if(x < 65) {
				song();
				x = 300;
				pon.score1++;
				x++;
				directionX = 3; //Change de direction vers la droite.
				
			}
			else if(x > 700) {
				song();
				x = 300;
				pon.score2++;
				directionX = -3; //Change de direction vers la gauche
			}
			
			
			y += directionY;

		    if (y < 107) {
		        y = 107;
		        directionY = 3; // Change de direction vers le bas
		    } else if (y > 420) {
		        y = 420;
		        directionY = -3; // Change de direction vers le haut
		    }
		
			
		}
		rectBall.setBounds(x, y, 30, 30);
		
	}
	
	public void song() {
		try {
			File audio = new File("song/audio/ping.wav");
			AudioInputStream sc = AudioSystem.getAudioInputStream(audio);
			Clip clip = AudioSystem.getClip();
			clip.open(sc);
			clip.start();
			
			//Stopper la musique apres sa lecture
			clip.addLineListener(event ->{
				if(event.getType() == LineEvent.Type.STOP) {
					clip.close();
				}
			});
			
			
		}catch(Exception e) {
			e.printStackTrace();		
			
		}
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(Color.pink);
		g.fillOval(x, y, 30, 30);
	}

}
