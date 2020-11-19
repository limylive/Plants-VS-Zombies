package com.lzp.bean;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.lzp.core.Core;
import com.lzp.frame.GamePanel;
import com.lzp.util.ImageUtil;

public class Botany {
	    //植物图片
		private BufferedImage bimg;
		//植物坐标
		private Point bpoint;
		//植物状态
		private boolean bstate;
		//植物矩阵矩阵
		private Rectangle brect;
		
		Thread t;
		public Rectangle getBrect() {
			return brect;
		}
		public void setBrect(Rectangle brect) {
			this.brect = brect;
		}
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
		
		
		public void runTask() {			
			new PlaneThead().start();
		}	
		
		   class PlaneThead extends Thread {
		 public void run() {
			 int x=0;
				 //豌豆线程				 
				 if(GamePanel.pi==0) {						
				 while(true) {						 
					 bimg=ImageUtil.img.get("plant_1.png").getSubimage(x*71, 0, 71, 71);
					 brect=new Rectangle(bpoint.x,bpoint.y,bimg.getWidth(),bimg.getHeight()-50);
					 x++;
					 if(x>7) {
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
					 //太阳花线程
					 if(GamePanel.pi==1) {					
						 while(true) {							
							 bimg=ImageUtil.img.get("Sunflower_0.png").getSubimage(x*73, 0, 73, 74);
							 brect=new Rectangle(bpoint.x,bpoint.y,bimg.getWidth(),bimg.getHeight()-50);
							 x++;
								if(x>17) {				
									x=0;
								}	
								try {
									this.sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}					 
						 }
					 }
	             }
		   	}                  
		}
				
			
				
			
		
		
		
		
		
		
            