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
	
	  //创建一个List集合来装所有的植物对象
	  public  static List<Botany> botanyList=new ArrayList();	
	  //创建一个List集合来装所有的僵尸对象
	  public  static List<Zombie> zombieList=new ArrayList();
	  //定义阳光初始值
	  public  static int sum=50;
	  //定义游戏状态
	  public static boolean game = true;
	  //定义僵尸死亡数量
	  public static int sum1=0;
	  //定义一个静态植物卡组对象
	  public static BotanyCard card=null; 
	  //定义一个静态铲子对象
	  public static Shovel shovel =null;		
		//创建一个List集合来装推车对象
				public  static List<Car> carList=new ArrayList();	
				
				//创建一个List集合来装太阳花对象				
				public  static List<Sun> sunList=new ArrayList();
				
				//创建一个List集合来装向日葵生产太阳花对象				
				public  static List<Sun1> sun2List=new ArrayList();
				
				//创建一个List集合来装子弹对象	
				public  static List<Bullet> bulletList=new ArrayList();
	       								
		//随机数工具
		Random r=new Random();
	
		//定义一个生成僵尸的方法
	public void createZombie() {
		  int y=20;
		  for(int i=0;i<3;i++) {
			Zombie z=new Zombie();			
			z.setZimg(ImageUtil.img.get("121_0.png"));	
			
			y+=120;
			//通过随机方式让僵尸在屏幕的左方出现
			int ay=r.nextInt(GameFrame.HEIGHT-z.getZimg().getHeight());			
			//通过随机方式让僵尸在屏幕的左方出现的距离		
			int ax=r.nextInt(200);						
			
			if(ay>101 && ay<222) {
			//设置僵尸生成坐标
			z.setZpoint(new Point(GameFrame.WIDTH+ax,40));		
			z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth()-200,z.getZimg().getHeight()-50));
			z.setZstate(true);
			zombieList.add(z);			
			}else if(ay<340) {
				//设置僵尸生成坐标
				z.setZpoint(new Point(GameFrame.WIDTH+ax,160));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);					
			}else if(ay<475) {
				//设置僵尸生成坐标
				z.setZpoint(new Point(GameFrame.WIDTH+ax,300));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);	
				
			}else if(ay<578) {
				//设置僵尸生成坐标
				z.setZpoint(new Point(GameFrame.WIDTH+ax,420));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);	
				
			}else if(ay<705) {
				//设置僵尸生成坐标
				z.setZpoint(new Point(GameFrame.WIDTH+ax,540));
				z.setZrect(new Rectangle(z.getZpoint().x+70,z.getZpoint().y+60,z.getZimg().getWidth(),z.getZimg().getHeight()-50));
				z.setZstate(true);
				zombieList.add(z);	
				
			}
			
		}		
	}
	
	//定义一个生成推车的方法
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
	
	//定义一个生成阳光的方法
	public void createSun() {
		
		//创建太阳花对象
		Sun s=new Sun();
		//放图片
		s.setSimg(ImageUtil.img.get("sun.png"));
	    //通过随机数工具在上方随机生成太阳花
		int r2=r.nextInt(GameFrame.WIDTH-s.getSimg().getWidth());
		int rx=r.nextInt(GameFrame.HEIGHT);
		s.setSpoint(new Point(r2,-rx));
		s.setSrect(new Rectangle(s.getSpoint().x,s.getSpoint().y,s.getSimg().getWidth(),s.getSimg().getHeight()));		
		s.setSstate(true);				
		System.out.println(s.isSstate());						
	    //将太阳花放到sunlist集合里
		sunList.add(s);
		
		}

    }
