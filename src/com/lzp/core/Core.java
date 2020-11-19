package com.lzp.core;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lzp.bean.Botany;
import com.lzp.bean.BotanyCard;
import com.lzp.bean.Bullet;
import com.lzp.bean.Car;
import com.lzp.bean.Shovel;
import com.lzp.bean.Sun;
import com.lzp.bean.Sun1;
import com.lzp.bean.Zombie;
import com.lzp.frame.GameFrame;
import com.lzp.util.ImageUtil;



public class Core {
	
	  //����һ��List������װ���е�ֲ�����
	  public  static List<Botany> botanyList=new ArrayList();	
	  //����һ��List������װ���еĽ�ʬ����
	  public  static List<Zombie> zombieList=new ArrayList();
	  //���������ʼֵ
	  public  static int sum=50;
	  //������Ϸ״̬
	  public static boolean game = true;
	  //���彩ʬ��������
	  public static int sum1=0;
	  //����һ����ֲ̬�￨�����
	  public static BotanyCard card=null; 
	  //����һ����̬���Ӷ���
	  public static Shovel shovel =null;		
		//����һ��List������װ�Ƴ�����
				public  static List<Car> carList=new ArrayList();	
				
				//����һ��List������װ̫��������				
				public  static List<Sun> sunList=new ArrayList();
				
				//����һ��List������װ���տ�����̫��������				
				public  static List<Sun1> sun2List=new ArrayList();
				
				//����һ��List������װ�ӵ�����	
				public  static List<Bullet> bulletList=new ArrayList();
	       								
		//���������
		Random r=new Random();
	
		//����һ�����ɽ�ʬ�ķ���
	public void createZombie() {
		  int y=20;
		  for(int i=0;i<3;i++) {
			Zombie z=new Zombie();			
			z.setZimg(ImageUtil.img.get("121_0.png"));	
			
			y+=120;
			//ͨ�������ʽ�ý�ʬ����Ļ���󷽳���
			int ay=r.nextInt(GameFrame.HEIGHT-z.getZimg().getHeight());			
			//ͨ�������ʽ�ý�ʬ����Ļ���󷽳��ֵľ���		
			int ax=r.nextInt(200);						
			
			if(ay>101 && ay<222) {
			//���ý�ʬ��������
			z.setZpoint(new Point(GameFrame.WIDTH+ax,40));		
			z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth()-200,z.getZimg().getHeight()-50));
			z.setZstate(true);
			zombieList.add(z);			
			}else if(ay<340) {
				//���ý�ʬ��������
				z.setZpoint(new Point(GameFrame.WIDTH+ax,160));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);					
			}else if(ay<475) {
				//���ý�ʬ��������
				z.setZpoint(new Point(GameFrame.WIDTH+ax,300));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);	
				
			}else if(ay<578) {
				//���ý�ʬ��������
				z.setZpoint(new Point(GameFrame.WIDTH+ax,420));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);	
				
			}else if(ay<705) {
				//���ý�ʬ��������
				z.setZpoint(new Point(GameFrame.WIDTH+ax,540));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);	
				
			}
			
		}		
	}
	
	//����һ�������Ƴ��ķ���
	public void createCar() {
		
		int y=140;
		for(int i=0;i<5;i++) {
		Car c=new Car();	
		c.setCimg(ImageUtil.img.get("car.png"));		
		c.setCpoint(new Point(0,y));
		y+=120;						
		c.setCrect(new Rectangle(c.getCpoint().x,c.getCpoint().y,c.getCimg().getWidth(),c.getCimg().getHeight()-30));				
		carList.add(c);
	
		}
		
	}
	
	//����һ����������ķ���
	public void createSun() {
		
		//����̫��������
		Sun s=new Sun();
		//��ͼƬ
		s.setSimg(ImageUtil.img.get("sun.png"));
	    //ͨ��������������Ϸ��������̫����
		int r2=r.nextInt(GameFrame.WIDTH-s.getSimg().getWidth());
		int rx=r.nextInt(GameFrame.HEIGHT);
		s.setSpoint(new Point(r2,-rx));
		s.setSrect(new Rectangle(s.getSpoint().x,s.getSpoint().y,s.getSimg().getWidth(),s.getSimg().getHeight()));		
		s.setSstate(true);				
		System.out.println(s.isSstate());						
	    //��̫�����ŵ�sunlist������
		sunList.add(s);
		
		}

    }
