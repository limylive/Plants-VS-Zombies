package com.lzp.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


			//改变当前类为东方不败类
			 public final class ImageUtil{
					 
			 private  ImageUtil() {}
					 
						 
			 //定义一个集合存储所有的图片对象		 
			public static Map<String,BufferedImage> img=new HashMap();
				
			//使用静态块完成图片文件的加载
				
			static {
			//获取img文件夹对象
			File f=new File("img");
			//循环遍历文件夹获取每个图片文件
			for(File file:f.listFiles()) {
						
					try {
						//获取图片文件名
						String  key=file.getName();
						//获取图片对象
						BufferedImage value=ImageIO.read(file);
						//存入map集合
						img.put(key, value);
				}catch(IOException e){
					
					e.printStackTrace();
				}
				
				
			}
			
		}
		 }

