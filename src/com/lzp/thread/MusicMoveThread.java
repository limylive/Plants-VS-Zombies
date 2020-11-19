package com.lzp.thread;

import java.io.File;

import com.lzp.core.Core;
import com.lzp.util.MusicUtils;

public class MusicMoveThread extends Thread{

	
	
	public void run() {
		//如果设计按键音乐就不需要死循环
		while(true) {
		
		MusicUtils.playMusic(true, new File("img/bg.wav"));
			
		}
	}
}
