package com.lzp.bean;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.lzp.core.Core;
import com.lzp.frame.GameFrame;
import com.lzp.util.ImageUtil;

/**
 * 
 * 
 * 子弹类
 * 
 * 
 */
public class Bullet {
	
	//子弹图片
	private BufferedImage bimg;
    //子弹坐标
	private Point bpoint;
    //子弹状态
	private  boolean bstate;
	
	//子弹矩阵
		private Rectangle brect;
	
	
	
	public BufferedImage getBimg() {
		return bimg;
	}

	public void setBimg(BufferedImage bimg) {
		this.bimg = bimg;
	}

	public Point getBpoint() {
		return bpoint;
	}

	public void setBpoint(Point bpoint) {
		this.bpoint = bpoint;
	}

	public boolean isBstate() {
		return bstate;
	}

	public void setBstate(boolean bstate) {
		this.bstate = bstate;
	}

	public Rectangle getBrect() {
		return brect;
	}

	public void setBrect(Rectangle brect) {
		this.brect = brect;
	}

	public void runTask2() {			
		new BulletThead().start();
	}			
	 class BulletThead extends Thread {	
			public void run() {				
			
				int x=0;	
			while(true) {						
				//遍历所有的炮弹移动			
			 for(int i=0;i<Core.bulletList.size();i++) {			
				 Bullet bl=Core.bulletList.get(i);					   		
				 bl.setBimg(ImageUtil.img.get("peaBullet_0.png").getSubimage(x*24, 0, 24, 24));
		 		 bl.setBpoint(new Point(bl.getBpoint().x+5,bl.getBpoint().y));
		 		 bl.setBrect(new Rectangle(bl.getBpoint().x,bl.getBpoint().y,bl.getBimg().getWidth(),bl.getBimg().getHeight()));
		 		if(bl.getBpoint().x>GameFrame.WIDTH+100) {
		 			bl.setBstate(false);
		 			Core.bulletList.remove(bl);
		 		}			 			
					}	
			     	x++;
			     	if(x>1) {			
					x=0;
					}
			
					try {
						this.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					 
						 }
					 }
		 		}	
	 		} 
			