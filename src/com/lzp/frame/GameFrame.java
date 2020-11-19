package com.lzp.frame;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.lzp.core.Core;
import com.lzp.util.ImageUtil;
public class GameFrame extends JFrame{
	public GameFrame() {
		//创建核心类对象调用核心方法?
		Core c=new Core();	    
		//调用僵尸创建方法
	    c.createZombie();
	  //调用推车创建方法
		c.createCar();
		////调用阳光创建方法
		c.createSun();	
		init();
	}
    //定义一个个静态的背景对象
	public static String currentBackground="background.jpg";
	//定义两个窗体大小的常量
	public static  int  WIDTH=ImageUtil.img.get("background.png").getWidth();	
	public static  int  HEIGHT=ImageUtil.img.get("background.png").getHeight()+25;		
	public static GameFrame gameFrame;
	public void init() {
		//定义窗体大小
		this.setSize(WIDTH, HEIGHT);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		//设置窗体关闭模式
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	  //设置窗体大小不可变
	  	this.setResizable(true);	  	
	  	this.setContentPane(new GamePanel());
		//设置窗体可见
		this.setVisible(true);
	}
	class StartPanel extends JPanel  {
		public StartPanel() {
			init();		
		}	
		public void init() {	
			 this.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);
		     //设置面板的布局为空
		     this.setLayout(null);
		     //设置面板焦点
		     this.setFocusable(true);		
		}		
	}
}
