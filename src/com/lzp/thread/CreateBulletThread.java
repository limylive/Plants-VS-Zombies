package com.lzp.thread;

import java.awt.Point;
import java.awt.Rectangle;

import com.lzp.bean.Botany;
import com.lzp.bean.Bullet;
import com.lzp.core.Core;
import com.lzp.util.ImageUtil;

public class CreateBulletThread extends Thread {	
	Botany b;
	Point p;
	public CreateBulletThread(Botany b){		
		this.b=b;
	}
	long A=System.currentTimeMillis();
	  int x;
	public void run() {
		while(true) {
			long B=System.currentTimeMillis();							
			if(B-A>5000) {
				Core c=new Core();										
				if(b.isBstate()) {		
				Bullet bt=new Bullet();			
	 			bt.setBimg(ImageUtil.img.get("peaBullet_0.png").getSubimage(x*24, 0, 24, 24));
	 			bt.setBpoint(new Point(b.getBpoint().x,b.getBpoint().y));
	 			bt.setBrect(new Rectangle(bt.getBpoint().x,bt.getBpoint().y,bt.getBimg().getWidth(),bt.getBimg().getHeight()));	 			
	 			bt.setBstate(true);
	 			Core.bulletList.add(bt);
	 			
	 			A=System.currentTimeMillis();
				}		
			}
 			x++;
 			if(x>1) {
 				
 				x=0;
 			}
			
 			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
