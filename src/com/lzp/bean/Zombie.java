package com.lzp.bean;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import com.lzp.core.Core;
import com.lzp.util.ImageUtil;

public class Zombie {
	    //��ʬͼƬ
		private BufferedImage zimg;
		//��ʬ����
		private Point zpoint;
		//��ʬ״̬
		private boolean zstate;			
		//��ʬ����
		private Rectangle zrect; 
		//����һ����ʬ����ֵ		
		private  int blood=7;	
		
		public int getBlood() {
			return blood;
		}
		public void setBlood(int blood) {
			this.blood = blood;
		}
		public Rectangle getZrect() {
			return zrect;
		}
		public void setZrect(Rectangle zrect) {
			this.zrect = zrect;
		}
		public BufferedImage getZimg() {
			return zimg;
		}
		public void setZimg(BufferedImage zimg) {
			this.zimg = zimg;
		}
		public Point getZpoint() {
			return zpoint;
		}
		public void setZpoint(Point zpoint) {
			this.zpoint = zpoint;
		}
		public boolean isZstate() {
			return zstate;
		}
		public void setZstate(boolean zstate) {
			this.zstate = zstate;
		}
		

	}