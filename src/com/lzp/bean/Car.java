package com.lzp.bean;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//推车类
public class Car {
	//推车图片
	private BufferedImage cimg;
    //推车坐标
	private Point cpoint;
    //推车状态
	private  boolean cstate;
	
	//推车矩阵
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
