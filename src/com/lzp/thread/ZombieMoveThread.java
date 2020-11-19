package com.lzp.thread;


import java.awt.Point;
import java.awt.Rectangle;

import com.lzp.bean.Botany;
import com.lzp.bean.Car;
import com.lzp.bean.Zombie;
import com.lzp.core.Core;
import com.lzp.frame.GameFrame;
import com.lzp.util.ImageUtil;

public class ZombieMoveThread  extends Thread{
	//定义一个面板的属性	
	long A=System.currentTimeMillis();
	public void run() {
      //定义一个计数器  
		int x=0;
		int y=0;
		
		while (true) {
			long B=System.currentTimeMillis();
			if(B-A>20000) {
				Core c=new Core();
				c.createZombie();
				A=System.currentTimeMillis();
			}
			 for(int i=0;i<Core.zombieList.size();i++) {
				 Zombie zb=Core.zombieList.get(i);
			   if(Core.zombieList.get(i).getBlood()>2) {
				   zb.setZimg(ImageUtil.img.get("121_0.png").getSubimage(x*166, 0, 166, 144));
				   zb.setZpoint(new Point(zb.getZpoint().x-2,zb.getZpoint().y));
				   zb.setZrect(new Rectangle(zb.getZpoint().x+50,zb.getZpoint().y,zb.getZimg().getWidth(),zb.getZimg().getHeight()+10));
			   }else if(Core.zombieList.get(i).getBlood()<=2) {
				   zb.setZimg(ImageUtil.img.get("121_4.png").getSubimage(y*166, 0, 166, 144));
				   zb.setZpoint(new Point(zb.getZpoint().x-2,zb.getZpoint().y));
				   zb.setZrect(new Rectangle(zb.getZpoint().x+50,zb.getZpoint().y,zb.getZimg().getWidth(),zb.getZimg().getHeight()));				   
			   }
			   
		       if(Core.zombieList.get(i).getZpoint().x<-30) {
		    	   Core.game=false;	    	   
		    	   
		       }
				}				
			x++;
			if(x>21) {
				x=0;			
			}
			y++;
			if(y>17) {
				y=0;
			}
			//遍历僵尸和子弹集合 判断是否相交
			for(int i=0;i<Core.zombieList.size();i++) {
				for(int i2=0;i2<Core.bulletList.size();i2++) {
					if(Core.zombieList.size()>i) {
						if(Core.zombieList.get(i).getZrect().intersects(Core.bulletList.get(i2).getBrect())) {
						
						Core.bulletList.remove(i2);
						Core.zombieList.get(i).setBlood(Core.zombieList.get(i).getBlood()-1);											
					}
					if(Core.zombieList.get(i).getBlood()<=0) {
						Core.zombieList.get(i).setZstate(false);
						Core.zombieList.remove(i);
						Core.sum1++;
					}			
				}						
			}				
		}	
			//遍历僵尸和小车集合 判断是否相交
	    for(int i=0;i<Core.zombieList.size();i++) {
	    Zombie zb=Core.zombieList.get(i);
	  
			for(int i3=0;i3<Core.carList.size();i3++) {	
				  if(Core.carList.size()>i3) {
				Car c=Core.carList.get(i3);
				if(c.getCrect().intersects(zb.getZrect())) {
				Core.zombieList.get(i).setZstate(false);					
					//zb.setZstate(false);					
						}	
				
				if(c.getCpoint().x>GameFrame.WIDTH+100) {
					Core.carList.remove(i3);
					
				}
					}
	    }	
	    }
		//遍历僵尸和植物集合 判断是否相交
	    for(int i=0;i<Core.zombieList.size();i++) {
	        
			for(int i3=0;i3<Core.botanyList.size();i3++) {	
				if(Core.botanyList.size()>i3) {
				Botany b=Core.botanyList.get(i3);
				if(Core.zombieList.get(i).getZrect().intersects(Core.botanyList.get(i3).getBrect())) {
				Core.botanyList.get(i3).setBstate(false);					
										
						}				
					}
	        }
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
