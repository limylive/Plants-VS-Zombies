package com.lzp.thread;

import java.awt.Point;
import java.util.Random;

import com.lzp.bean.Sun;
import com.lzp.core.Core;
import com.lzp.frame.GameFrame;
import com.lzp.util.ImageUtil;

public class SunMoveThread extends Thread{
	 int x=0;
	 	
	long A=System.currentTimeMillis();	
	public void run() {		
  Random r=new Random();	
  //太阳花移动
		while(true) {
			
			long B=System.currentTimeMillis();
			if(B-A>10000) {
			Core c=new Core();
			c.createSun();	
			A=System.currentTimeMillis();
			}
			for(int i=0;i<Core.sunList.size();i++) {
				//定义一个太阳花的属性
				Sun s=Core.sunList.get(i);
			//	int z=r.nextInt(250);
				s.setSimg(ImageUtil.img.get("sun_0.png").getSubimage(x*78,0,78,78));		
				if(s.getSpoint().y<GameFrame.HEIGHT-110) {
				s.setSpoint(new Point(s.getSpoint().x,s.getSpoint().y+5));					
				}else {
					s.setSpoint(new Point(s.getSpoint().x,s.getSpoint().y));						
				}				
			}
			x++;
			if(x>21) {
				x=0;			
			}
		
			//重绘面板
			//panel.repaint();
			try {
				this.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				  }
			}
	    
	
	
}
