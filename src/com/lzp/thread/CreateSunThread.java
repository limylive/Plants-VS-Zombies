package com.lzp.thread;

import java.awt.Point;

import com.lzp.bean.Botany;
import com.lzp.bean.Sun1;
import com.lzp.core.Core;
import com.lzp.frame.GamePanel;
import com.lzp.util.ImageUtil;

public class CreateSunThread extends Thread {
   
	int x=0;
	long A=System.currentTimeMillis();	
	
	Botany b;
	public CreateSunThread(Botany b) {
			
		this.b=b;
	}	
	public void run() {
		while(true) {		
			long B=System.currentTimeMillis();
			if(B-A>5000) {
				
				if(b.isBstate()) {
					Sun1 s=new Sun1();
				    s.setSimg(ImageUtil.img.get("sun_0.png"));	
					s.setSpoint(new Point(b.getBpoint().x,b.getBpoint().y));			   
				    Core.sun2List.add(s);
				    System.out.println(Core.sun2List.size());
				 
				A=System.currentTimeMillis();
					}
			}
					
		try {
			this.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		}
	}

}