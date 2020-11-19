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
	// �������� ����Ϊ�Ƿ�ѭ��
	public static void playMusic(boolean loop, File file) {
//		System.out.println(1111111);
		byte[] audioData = new byte[1024];
		// ��Դ:����Ҫ�ѱ��ػ������ϵ���Ƶ�����˴���
		// ע��:�����Ĳ������ڽ������뵽�˴�֮��Ȼ����д������
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
		// ����ʼִ�����е�I/O,�ڴ���ǰ���������в�����
		// ֻ��ΪSourceDataLint�����һ����Ƶ�������������仹δ�����Ŀ�ʼ�����������롣
		line.start();
		int inByte = 0;
		while (inByte != -1) {
			if (loop) {
				try {
					// ����Ƶ�����뵽��������
					inByte = ais.read(audioData, 0, 1024);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
				try {
					if (inByte > 0) {
						// ���������е�����д������Ƶ���У��ݽ⡣
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
		// �൱��flush ��ջ�����
		line.drain();
		// ֹͣ����
		line.stop();
		// �ر�
		line.close();
		// �����ѭ������ ����еݹ����
//		if (loop) {
//			playMusic(loop, file);
//		}
	}




//	
//	public static void main(String[] args) {
//		SoundUtils.playMusic(true, new File("sound/a_btn.wav"));
//	}
	
	
	
}
