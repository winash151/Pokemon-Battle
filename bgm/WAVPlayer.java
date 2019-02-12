package bgm;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WAVPlayer {
	private Clip clip;
	private String filename;
	
	public WAVPlayer(String filename){
		this.setFilename(filename);
		BufferedInputStream inputStream = new BufferedInputStream(getClass()
				.getClassLoader().getResourceAsStream(filename));
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e4) {
			e4.printStackTrace();
		}
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(inputStream);
		} catch (UnsupportedAudioFileException | IOException e3) {
			e3.printStackTrace();
		}
		try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException | IOException e2) {
			e2.printStackTrace();
		}
	}
	
	public void play(){
		clip.setMicrosecondPosition(0);
		clip.start();
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

}
