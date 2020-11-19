package com.lzp.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import com.lzp.bean.Botany;
import com.lzp.bean.BotanyCard;
import com.lzp.bean.Bullet;
import com.lzp.bean.Car;
import com.lzp.bean.Shovel;
import com.lzp.bean.Sun;
import com.lzp.bean.Sun1;
import com.lzp.bean.Zombie;

import com.lzp.core.Core;
import com.lzp.thread.CarMoveThread;
import com.lzp.thread.CreateBulletThread;
import com.lzp.thread.CreateSunThread;
import com.lzp.thread.MusicMoveThread;
import com.lzp.thread.PanelThread;
import com.lzp.thread.SunMoveThread;
import com.lzp.thread.ZombieMoveThread;
import com.lzp.util.ImageUtil;
import com.lzp.util.MusicUtils;





public class GamePanel extends JPanel {
	        
	 
				Random r=new Random();
				
				Zombie zb;
				 public static int pi;
				 public static	 int px;
				 public static  int py;
         
				//�ڵ�ǰ����ж���һ��ֲ��Ķ���
	      List<Botany> botanyList=new ArrayList();
	  
	      
          public GamePanel() {
        	 System.out.println(11);
        	 new PanelThread(this).start();   	  
        	 //�����ر�������
    	     new MusicMoveThread().start(); 
   	     
    	    new SunMoveThread().start();
         	
    	  
    	  
			    //������ʬ�̶߳����������
    	     new ZombieMoveThread().start();
			 
    	     //�����Ƴ��̶߳����������
    	     new CarMoveThread().start();
    	     //�������Ĵ�С
    	     this.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);
    	     //�������Ĳ���Ϊ��
    	     this.setLayout(null);
    	     //������役��
    	     this.setFocusable(true);
    	    
    	     
    	     this.addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub		
				}
				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
			
					int x=e.getX();
					int y=e.getY();										
                      //����ֲ���ƶ�
					if(Core.card!=null) {
						Core.card.setBcpoint(new Point(x-Core.card.getBcimg().getWidth()/2,y-Core.card.getBcimg().getHeight()/2));
					}
					
					  //���Ʋ����ƶ�
					if(Core.shovel!=null) {
						Core.shovel.setShpoint(new Point(x-Core.shovel.getShimg().getWidth()/2,y-Core.shovel.getShimg().getHeight()/2));					
					}				
									     }
   	    	 
    	     										});
   	     
    	     
			 this.addMouseListener(new MouseListener() {
				 
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub					
						int x=e.getX();
						int y=e.getY();
						Point point =new Point(x,y);
													
						int cc=e.getClickCount();
						//������			
						if(e.getButton()==MouseEvent.BUTTON1) {					         										           							
							 Core c=new Core();		
							         if(cc==1) {		
							        								        	 
						  //�л���Ϸҳ��  ��ʼ����Ϊ��ʼҳ��  �����ʼ��������Ϸҳ��
						 if(e.getX()>454 && e.getX()<545 && e.getY()>660 && e.getY()<700) {	 
											 
							  GameFrame.currentBackground="background.png";      	 									 
						 }	
						 
						//�Ƿ�ѡ���㶹
					       if(e.getX()>100 && e.getX()<150 && e.getY()<100 && Core.sum>=100) {										        
							Core.card=new BotanyCard();
							
							Core.card.setBcimg(ImageUtil.img.get("Pease.png"));
							
							Core.card.setBcpoint(new Point(e.getX(),e.getY()));											
							System.out.println("ѡ��");			
							 pi=0;	 							 					      
					       }  
							        	 //ѡ�����տ�																						 
							 if(e.getX()>200 && e.getX()<270 && e.getY()<100 &&Core.sum>=50) {
					        	 Core.card=new BotanyCard();				        	
					        	 Core.card.setBcimg(ImageUtil.img.get("sunf.png"));					        	 
					        	 Core.card.setBcpoint(new Point(e.getX(),e.getY()));
					        	 System.out.println("ѡ��");	
					        	 pi=1;					        	
					         }	 		 														    	 
										//ѡ�в���
						      if(e.getX()>(ImageUtil.img.get("cardboard.png").getWidth()) && e.getX()<(ImageUtil.img.get("cardboard.png").getWidth()+80) && e.getY()<80) {
						        	 Core.shovel=new Shovel();
						        	 Core.shovel.setShimg(ImageUtil.img.get("shovel.png"));
						        	 Core.shovel.setShpoint(new Point(e.getX(),e.getY()));
						        	 System.out.println("ѡ��");	
						        	 pi=3;
						         }
									 
									 //�ж������λ�� ����ȡ�м�ֵ
							 			 if (x > 55 && x < 150) {
								 			px = (50 + 150) / 2;
								 		}
								 		if (x > 150 && x < 250 ) {
								 			px = (150 + 250) / 2;
								 		}
								 		if (x > 250 && x < 350 ) {
								 			px = (250 + 350) / 2;
								 		}
								 		if (x > 350 && x < 455) {
								 			px = (350 + 455) / 2;
								 		}
								 		if (x > 455 && x < 561) {
								 			px = (455 + 561) / 2;
								 		}
								 		if (x > 561 && x < 656) {
								 			px = (561 + 656) / 2;
								 		}
								 		if (x > 656 && x < 755) {
								 			px = (656 + 755) / 2;
								 		}
								 		if (x > 755 && x < 859) {
								 			px = (755 + 859) / 2;
								 		}
								 		if (x > 859 && x < 964) {
								 			px = (859 + 964) / 2;
								 		}
								 		if (y > 104 && y< 214) {
								 			py = (104 + 214) / 2;
								 		}
								 		if (y > 214 && y < 333) {
								 			py = (214 + 333) / 2;
								 		}
								 		if (y > 340 && y < 460) {
								 			py = (340 + 460) / 2;
								 		}
								 		if (y > 460 && y < 580) {
								 			py = (460 + 580) / 2;
								 		}
								 		if (y > 580 && y < 704) {
								 			py = (580 + 704) / 2;
								 		}
											 		 
											 		
								 		//��ֲ�㶹  && pi==0
							 		if(Core.card!=null && e.getX()>=50 && e.getX()<=960 && e.getY()<700 && e.getY()>110 && pi==0){					
							 			Botany b=new Botany();							 			
							 			Bullet bt=new Bullet();
							 			b.setBimg(ImageUtil.img.get("Pease.png"));
							 			b.setBpoint(new Point(px-ImageUtil.img.get("Pease.png").getWidth()/2,py-ImageUtil.img.get("Pease.png").getHeight()/2));
							 		    b.setBstate(true);
						 			    b.runTask();
							 			Core.card=null;					 			
							 			Core.botanyList.add(b);	
							 			Core.sum-=100;
							 			
							 			new CreateBulletThread(b).start();	
								 		bt.runTask2();			
								 		}
								 			 
								 		//��ֲ���տ�   && pi==1
					        	       if(Core.card!=null && e.getX()>=50 && e.getX()<=960 && e.getY()<700 && e.getY()>110 && pi==1){														    	 
					        		    Botany b1=new Botany();
					        		    Sun1 s1=new Sun1();
					        		    //  s.runTask3();
							 			b1.setBimg(ImageUtil.img.get("sunf.png"));
							 			b1.setBpoint(new Point(px-ImageUtil.img.get("sunf.png").getWidth()/2,py-ImageUtil.img.get("sunf.png").getHeight()/2));
							 		    b1.setBstate(true);
							 		   Core.sum-=50;
							 			b1.runTask();
							 			Core.card=null;		
							 			Core.botanyList.add(b1);									 												 											 											 			
							 			new CreateSunThread(b1).start();
							 			s1.runTask3();
 							       }    
					        	       
					        	       //�����Ƴ�ֲ��
					        	       for(int i=0;i<Core.botanyList.size();i++) {		
						        	    	  Botany b=Core.botanyList.get(i);
					        	       int x1 = b.getBpoint().x;
				        	   			int x2 = b.getBpoint().x+b.getBimg().getWidth();
				        	   			int y1 = b.getBpoint().y;
				        	   			int y2 = b.getBpoint().y+b.getBimg().getHeight();
				        	   			
				        	   			 if(Core.shovel!=null && e.getX()>=x1 && e.getX()<=x2 && e.getY()<y2 && e.getY()>y1 && pi==3 ){									        	    	  							        	    							        	    					        	    	  							        	    	  
						        	    	  b.setBstate(false);							        	    	
						        	    	  Core.botanyList.remove(b);
						        	    	  System.out.println(b.isBstate());
						        	    	 }						        	   			
				        	   			}							        	      
				        	      	}
						        	       	
							        	       
							        	       
							        	       //���յ���������̫����
								     for(int i=0;i<Core.sunList.size();i++) {
											//�ڵ�ǰ����ж���һ��̫������Ķ���
											        Sun sun=Core.sunList.get(i);
											        if(e.getY()>sun.getSpoint().y-sun.getSimg().getHeight()/2-50 && e.getY()<sun.getSpoint().y+sun.getSimg().getHeight()/2+50 && e.getX()>sun.getSpoint().x-sun.getSimg().getWidth()/2-50 && e.getX()<sun.getSpoint().x+sun.getSimg().getWidth()/2+50) {
										    	    sun.setSstate(false);
										    	    System.out.println(sun.isSstate());
										    	      // Core.sunList.remove(sun);						    	  
										    	      Core.sum+=25;		
										    	      
								                            }
//											//�������տ�������̫����						}	
								     for(int i1=0;i1<Core.sun2List.size();i1++) {
											Sun1 sun1=Core.sun2List.get(i1);
											   if(e.getY()>sun1.getSpoint().y-sun1.getSimg().getHeight()/2 && e.getY()<sun1.getSpoint().y+sun1.getSimg().getHeight()/2+30 && e.getX()>sun1.getSpoint().x-sun1.getSimg().getWidth()/2 && e.getX()<sun1.getSpoint().x+sun1.getSimg().getWidth()/2+20) {
										    	    sun1.setSstate(false);
										    	   Core.sun2List.remove(sun1);
										    	    System.out.println(sun1.isSstate());
										    	      // Core.sunList.remove(sun);						    	  
										    	      Core.sum+=25;		 
												 }
											 }	   										        
										 }
								    
						
								     
								 
						  
						         
										   }
											if(e.getButton()==MouseEvent.BUTTON3) {							        	    	 
							        	    	  Core.card=null;
							        	    	  Core.shovel=null;
							        	      }		
										}
					
									@Override
									public void mousePressed(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
					
									@Override
									public void mouseReleased(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
					
									@Override
									public void mouseEntered(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}
					
									@Override
									public void mouseExited(MouseEvent e) {
										// TODO Auto-generated method stub
										
									}});
							
					
								 
					               //��굥��
								
					             //�ػ�
								 GamePanel.this.repaint();
								        
							   }					          
					     	 //��ȡ��ǰͼƬ����
								 public Image getCurrentBackground() {
									return ImageUtil.img.get(GameFrame.currentBackground);
									 
								 }      	         
          @Override
	        protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        
	    	g.setColor(Color.red);
			//���Ƴ�ʼ����
	    	 g.drawImage(getCurrentBackground(), 0, 0,null);
	        if(GameFrame.currentBackground.equals("background.png") && Core.game==true) {
			g.drawImage(ImageUtil.img.get("cardboard.png"), 0,0 , null);						
			if(Core.sum<100) {
				g.drawImage(ImageUtil.img.get("pease1_dark1.png"), 100, 10, null);
				
			}else if(Core.sum>=100) {
			g.drawImage(ImageUtil.img.get("Peashooter.png"), 100, 10, null);
			}
			if(Core.sum<50) {
				 g.drawImage(ImageUtil.img.get("sunflower1_dark1.png"), 200, 10, null);		        			        		 
	    	 }else if(Core.sum>=50) {
			g.drawImage(ImageUtil.img.get("Sunflower.png"), 200, 10, null);
	    	 }
			g.drawImage(ImageUtil.img.get("chanzi.png"),(ImageUtil.img.get("cardboard.png").getWidth()),0,null);																																
			//����ֲ�￨��
			BotanyCard card=Core.card;
			if(card!=null) {
				g.drawImage(card.getBcimg(),card.getBcpoint().x, card.getBcpoint().y, null);												
			}									 
			//���Ʋ���
			Shovel shovel=Core.shovel;
			if(shovel!=null) {
				g.drawImage(shovel.getShimg(),shovel.getShpoint().x ,shovel.getShpoint().y, null);																			
			}				
			//����ֲ��				
			for(int i=0;i<Core.botanyList.size();i++) {
			  Botany b=Core.botanyList.get(i);	
			  if(b.isBstate()) {
					g.drawImage(b.getBimg(),b.getBpoint().x, b.getBpoint().y, null);																					
			  }		
            }
			//�����ӵ�
			for(int i=0;i<Core.bulletList.size();i++) {
				Bullet bt=Core.bulletList.get(i);						
									
				g.drawImage(bt.getBimg(), bt.getBpoint().x, bt.getBpoint().y, null);						
				}																
			//���ƽ�ʬ
			for(int i=0;i<Core.zombieList.size();i++) {
				Zombie zb=Core.zombieList.get(i);
				if(zb.isZstate()) {
				g.drawImage(zb.getZimg(), zb.getZpoint().x, zb.getZpoint().y, null);	
			  //  g.drawRect(zb.getZpoint().x+70, zb.getZpoint().y+60, zb.getZimg().getWidth(), zb.getZimg().getHeight()-50);
		
				}																
			}			
			//�����Ƴ�
			for(int i=0;i<Core.carList.size();i++) {
			//�ڵ�ǰ����ж���һ���Ƴ����ϵĶ���
			Car c=Core.carList.get(i);
			g.drawImage(c.getCimg(), c.getCpoint().x, c.getCpoint().y, null);	
			//g.drawRect(c.getCpoint().x, c.getCpoint().y, c.getCimg().getWidth(), c.getCimg().getHeight()-30);
			}
			
		  //����sum
			g.setFont(new Font("΢���ź�",Font.BOLD,16));
			
			if(Core.sum==0) {
				 g.drawString(Integer.toString(Core.sum), 45, 100); 										
			}
			else if(Core.sum<100) {
			     g.drawString(Integer.toString(Core.sum), 40, 100);   
		        }else if(Core.sum>=100) {
			g.drawString(Integer.toString(Core.sum), 35, 100);
		        }
			//����̫����
			for(int i=0;i<Core.sunList.size();i++) {					
				Sun s=Core.sunList.get(i);
				if(s.isSstate()) {
				g.drawImage(s.getSimg(), s.getSpoint().x, s.getSpoint().y, null);									
				}												
			   }
			//�������տ�����������
			for(int i=0;i<Core.sun2List.size();i++) {					
				Sun1 s1=Core.sun2List.get(i);
				if(s1.isSstate()) {
				g.drawImage(s1.getSimg(), s1.getSpoint().x, s1.getSpoint().y, null);																				
				}
		      }	
		
	        }
	        
	        
							    	if(!Core.game) {					    		
										g.drawImage(ImageUtil.img.get("ZombiesWon.png"),100,100, null);																				    
									}	
							    	
							    	
							    	if(Core.sum1==10) {
							    		g.drawImage(ImageUtil.img.get("victory.png"), 100, 100, null);
							                    
							    	}
							     }	 								   		 
							  } 
