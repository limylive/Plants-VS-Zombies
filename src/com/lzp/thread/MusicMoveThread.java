package com.lzp.thread;

import java.io.File;

import com.lzp.core.Core;
import com.lzp.util.MusicUtils;

public class MusicMoveThread extends Thread{

	
	
	public void run() {
		//�����ư������־Ͳ���Ҫ��ѭ��
		while(true) {
		
		MusicUtils.playMusic(true, new File("img/bg.wav"));
			
		}
	}
}
