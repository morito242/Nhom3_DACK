package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicGame 
{
	Clip clip;
	public void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException 
	{
		File file  = new File("C:/Users/HP/OneDrive/Máy tính/BTVN/Music/Xo-So-Mien-Bac-Nhac-Chuong-V-A-V-A.wav"); 
		AudioInputStream audioStream  = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopMusic()
	{
		clip.stop();
	}
	
	public MusicGame(){}
}
