package com.lzp.bean;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import com.lzp.core.Core;
import com.lzp.util.ImageUtil;

public class Sun1 {
	 //����ͼƬ
		private BufferedImage simg;
		//��������
		private Point spoint;
		//����״̬
		private boolean sstate;
		//̫��������
		private Rectangle srect;
		public Rectangle getSrect() {
			return srect;
		}
		public void setSrect(Rectangle srect) {
			this.srect = srect;
		}
		public BufferedImage getSimg() {
			return simg;
		}
		public void setSimg(BufferedImage simg) {
			this.simg = simg;
		}
		public Point getSpoint() {
			return spoint;
		}
		public void setSpoint(Point spoint) {
			this.spoint = spoint;
		}
		public boolean isSstate() {
			return sstate;
		}
		public void setSstate(boolean sstate) {
			this.sstate = sstate;
		}	
		public void runTask3() {			
			new Sun1Thead().start();
		}	
		 class Sun1Thead extends Thread {	
				public void run() {
					int x=0;	
				while(true) {
					//�������е����տ�������̫����
					for(int i=0;i<Core.sun2List.size();i++) {									 
						 Sun1 s1=Core.sun2List.get(i);					
						 s1.setSimg(ImageUtil.img.get("sun_0.png").getSubimage(x*78,0,78,78));	
						 s1.setSpoint(new Point(s1.getSpoint().x,s1.getSpoint().y));
						 s1.setSstate(true);						 		
						}	
				     	x++;
				     	if(x>21) {			
						x=0;
						}					
						try {
							this.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					 
							 }
						 }
			 		}	
}
