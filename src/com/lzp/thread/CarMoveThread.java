package com.lzp.thread;

import java.awt.Point;
import java.awt.Rectangle;

import com.lzp.bean.Car;
import com.lzp.bean.Zombie;
import com.lzp.core.Core;
import com.lzp.frame.GameFrame;

public class CarMoveThread extends Thread{
	
	public void run() {
		while(true) {
			
			for(int i=0;i<Core.zombieList.size();i++) {
				for(int j=0;j<Core.carList.size();j++) {
					Car c=Core.carList.get(j);
					if(Core.zombieList.size()>i && Core.carList.size()>j) {
					  if(Core.zombieList.get(i).getZrect().intersects(Core.carList.get(j).getCrect())) {
						 Core.carList.get(j).setCstate(true);
						 Core.zombieList.get(i).setZstate(false);	
						 Core.zombieList.remove(i);
					   }										
					}					
				}
			}			
			for(int j=0;j<Core.carList.size();j++) {
				   Car c=Core.carList.get(j);	
				   if(c.isCstate()) {
				   c.setCpoint(new Point(c.getCpoint().x+5,c.getCpoint().y));
				   c.setCrect(new Rectangle(c.getCpoint().x,c.getCpoint().y,c.getCimg().getWidth(),c.getCimg().getHeight()));
				   }
				   if(c.getCpoint().x>GameFrame.WIDTH+10) {
					   Core.carList.remove(j);
					   
				   }
			}
				   //∂®“Â–›√ﬂ
				   
				   
	                try {
						this.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 	
	
		
	  }
   }
}	

