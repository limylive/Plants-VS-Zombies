package com.lzp.bean;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.lzp.bean.Botany.PlaneThead;
import com.lzp.core.Core;
import com.lzp.frame.GameFrame;
import com.lzp.frame.GamePanel;
import com.lzp.util.ImageUtil;

public class Sun {
	 //����ͼƬ
	private BufferedImage simg;
	//��������
	private Point spoint;
	//����״̬
	private boolean sstate;	
	//̫��������
	private Rectangle srect;
	//public Sun s; 
	
	
	
	
	
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
		
						
	  
}
