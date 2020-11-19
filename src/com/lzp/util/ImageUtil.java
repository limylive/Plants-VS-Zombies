package com.lzp.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


			//�ı䵱ǰ��Ϊ����������
			 public final class ImageUtil{
					 
			 private  ImageUtil() {}
					 
						 
			 //����һ�����ϴ洢���е�ͼƬ����		 
			public static Map<String,BufferedImage> img=new HashMap();
				
			//ʹ�þ�̬�����ͼƬ�ļ��ļ���
				
			static {
			//��ȡimg�ļ��ж���
			File f=new File("img");
			//ѭ�������ļ��л�ȡÿ��ͼƬ�ļ�
			for(File file:f.listFiles()) {
						
					try {
						//��ȡͼƬ�ļ���
						String  key=file.getName();
						//��ȡͼƬ����
						BufferedImage value=ImageIO.read(file);
						//����map����
						img.put(key, value);
				}catch(IOException e){
					
					e.printStackTrace();
				}
				
				
			}
			
		}
		 }

