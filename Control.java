package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Control implements KeyListener {
	public boolean haut , bas;

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			haut = true;
			
		}
		if(code == KeyEvent.VK_DOWN) {
			bas = true;
		}
		
	}

	public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			haut = false;
			
		}
		if(code == KeyEvent.VK_DOWN) {
			bas = false;
		}
		
	}

}
