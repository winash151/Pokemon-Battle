package bgm;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MP3Player {
	
	private boolean loop;
	private AdvancedPlayer player;
	private boolean isPlaying;
	private int songNum = 0;
	private String[] songs;
	
	public MP3Player(String filename, boolean loop){
		this(new String[]{filename}, loop);
	}
	
	public MP3Player(String[] filenames, boolean loop){
		this.songs = filenames;
		this.loop = loop;
	}
	
	public void start() throws JavaLayerException{
		InputStream stream = getClass().getClassLoader().getResourceAsStream(songs[songNum]);
		
			player = new AdvancedPlayer(stream);
			isPlaying = true;
			new Thread(new Runnable(){
				public void run() {
					try {
						player.play();
					} catch (JavaLayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		
		
		if(loop){
			player.setPlayBackListener(new MyPlaybackListener());
		}
	}
	
	private class MyPlaybackListener extends PlaybackListener {
		public void playbackFinished(PlaybackEvent evt){
			if(isPlaying)
				try {
					songNum++;
					if(songNum>=songs.length) songNum=0;
					start();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void stop() {
		isPlaying = false;
		player.setPlayBackListener(null);
		player.close();
		System.out.println("l");
	}

}
