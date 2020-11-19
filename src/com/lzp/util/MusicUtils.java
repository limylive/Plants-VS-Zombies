package com.lzp.util;




import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MusicUtils {
	// 播放音乐 参数为是否循环
	public static void playMusic(boolean loop, File file) {
//		System.out.println(1111111);
		byte[] audioData = new byte[1024];
		// 音源:即需要把本地或网络上的音频读进此处，
		// 注意:声音的播方是在将声加入到此处之后，然后再写向声卡
		AudioInputStream ais = null;
		SourceDataLine line = null;
		try {
			ais = AudioSystem.getAudioInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ais != null) {
			AudioFormat baseFormat = ais.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					baseFormat);
			try {
				line = (SourceDataLine) AudioSystem.getLine(info);
				line.open(baseFormat);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (line == null) {
			return;
		}
		// 允许开始执行数行的I/O,在此这前所做的所有操作，
		// 只是为SourceDataLint获得了一个音频输入流，但是其还未真正的开始进行流的输入。
		line.start();
		int inByte = 0;
		while (inByte != -1) {
			if (loop) {
				try {
					// 将音频流读入到缓冲区中
					inByte = ais.read(audioData, 0, 1024);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
				try {
					if (inByte > 0) {
						// 将缓冲区中的内容写出到音频器中，暂解。
						line.write(audioData, 0, inByte);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				inByte=-1;
			}

		}
		// 相当于flush 清空缓冲区
		line.drain();
		// 停止播放
		line.stop();
		// 关闭
		line.close();
		// 如果是循环播放 则进行递归调用
//		if (loop) {
//			playMusic(loop, file);
//		}
	}




//	
//	public static void main(String[] args) {
//		SoundUtils.playMusic(true, new File("sound/a_btn.wav"));
//	}
	
	
	
}
