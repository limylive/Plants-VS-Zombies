package com.lzp.bean;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//�Ƴ���
public class Car {
	//�Ƴ�ͼƬ
	private BufferedImage cimg;
    //�Ƴ�����
	private Point cpoint;
    //�Ƴ�״̬
	private  boolean cstate;
	
	//�Ƴ�����
		private Rectangle crect; 
	
		
		
	public boolean isCstate() {
			return cstate;
		}

		public void setCstate(boolean cstate) {
			this.cstate = cstate;
		}

		public Rectangle getCrect() {
			return crect;
		}

		public void setCrect(Rectangle crect) {
			this.crect = crect;
		}

	public BufferedImage getCimg() {
		return cimg;
	}

	public void setCimg(BufferedImage cimg) {
		this.cimg = cimg;
	}

	public Point getCpoint() {
		return cpoint;
	}

	public void setCpoint(Point cpoint) {
		this.cpoint = cpoint;
	}
	
	
	
	
}
