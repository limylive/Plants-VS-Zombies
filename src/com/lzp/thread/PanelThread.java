package com.lzp.thread;

import com.lzp.frame.GamePanel;

public class PanelThread extends Thread{
	GamePanel p;
	public PanelThread(GamePanel p) {
		this.p=p;
	}
	
	public void run() {
		while(true) {
			p.repaint();
			try {
				this.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	
}