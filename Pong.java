package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.JPanel;

public class Pong extends JPanel implements Runnable {
	
	public int title = 68;
	public int col = 12;
	public int row = 8;
	
	public int larg = col * title;
	public int longueur = row * title;

	int FPS = 60;
	Thread th;
	Table tb = new Table(this);
	Control ct = new Control();
	Joueur jr = new Joueur(this, ct);
	Ball ball = new Ball(this);
	Computer com = new Computer(this, ball);
	UI ui = new UI(this);
	
	public int score1;
	public int score2;
	
	public Pong() {
		this.setPreferredSize(new Dimension(larg, longueur));
		this.setBackground(Color.gray);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		this.addKeyListener(ct);
		
	}
	
	public void lets_go() {
		th = new Thread(this);
		th.start();
	}
	
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		
		while(th != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if(delta >= 1) {
				update();
				collision();
				repaint();
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				//System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		
		//Joueur
		jr.update();
		//Computer
		com.update();
		//ball
		ball.update();
		
	}
	
	public void collision() {
		
		if(jr.rectJr.intersects(ball.rectBall)) {
			song();
			ball.directionX = Math.abs(ball.directionX);
			
		}
		if(com.rectCom.intersects(ball.rectBall)) {
			song();
			ball.directionX = -Math.abs(ball.directionX);

		}
		
	}

	
	public void song() {
		try {
			File audio = new File("song/audio/pong.wav");
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
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//Table
		tb.draw(g2);
		
		//Joueur
		jr.draw(g2);
		
		//Computer
		com.draw(g2);
		
		//Ball
		ball.draw(g2);
		
		//UI
		ui.draw(g2);

		
	}

}
