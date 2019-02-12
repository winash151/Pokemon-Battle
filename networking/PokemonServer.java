package networking;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class PokemonServer {
	
	public static void main(String[] args) {
		new PokemonServer();
	}
	
	// The ServerSocket we'll use for accepting new connections
	private ServerSocket ss;
	private ArrayList<ClientPair> pairs = new ArrayList<ClientPair>();
		
	public PokemonServer(){
		//new ContinuousAudioDataStream(null).
		//InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ball_out.wav");
		/*BufferedInputStream buff = new BufferedInputStream(inputStream);
	    AudioStream audioStream = null;
	    AudioData data;
	    ContinuousAudioDataStream dataStream = null;
		try {
			audioStream = new AudioStream(inputStream);
			//data = audioStream.getData();
			//dataStream = new ContinuousAudioDataStream(data);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	    AudioPlayer.player.start(audioStream);
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    AudioPlayer.player.stop(audioStream);
	    audioStream.mark(0);
	    AudioPlayer.player.start(audioStream);*/
		
		/*Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	    AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(inputStream);
		} catch (UnsupportedAudioFileException | IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	    try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    clip.start();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    clip.setMicrosecondPosition(0);
	    clip.start();*/
	    
		System.out.println("Total Memory: " + Runtime.getRuntime().totalMemory()/1024/1024);
		try{
			/*String ip = null;
			URL whatismyip = null;
			whatismyip = new URL("http://checkip.amazonaws.com");
		
	        BufferedReader in = null;
	        try {
	            in = new BufferedReader(new InputStreamReader(
	                    whatismyip.openStream()));
	            ip = in.readLine();
			} finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }*/
			
			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			InputStream fontStream = getClass().getClassLoader().getResourceAsStream("PKMNFL_1.TTF");
			try {
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontStream));
			} catch (FontFormatException e1) {
				e1.printStackTrace();
			}
			//System.setProperty("java.net.preferIPv4Stack" , "true");
			//System.out.println(System.getProperty("java.net.prefeIPv4Stack") + " ; prop");
	        
	        // Create the ServerSocket
	        ss = new ServerSocket(5555);
	        System.out.println("Server so timeout: " + ss.getSoTimeout());
	        
	        JFrame frame = new JFrame();
	        JTextArea ta = new JTextArea();
	        ta.setText("Local Host Address: " + InetAddress.getLocalHost().getHostName());
	        ta.setFont(new Font("Pokemon FireLeaf", Font.TRUETYPE_FONT, 18));
	        frame.add(ta);
	        frame.setSize(400, 400);
	        ta.setSize(400, 400);
	        frame.setVisible(true);
	        
	        
	        // Tell the world we're ready to go
	        System.out.println("Listening on " + ss);
	        final PokemonServer server = this;
	
	        while(true){
	        	System.out.println("Total Memory: " + Runtime.getRuntime().totalMemory()/1024/1024);
	        	System.out.println("Server so timeout: " + ss.getSoTimeout());
	        	// Grab the next incoming connection
	        	final Socket s = ss.accept();
				s.setKeepAlive(true);
	        	
	        	new Thread(new Runnable(){
					public void run() {
						String clientInput = null;
						try {
							System.out.println("Socket in pokemon server so timeout: " + s.getKeepAlive());
						
							DataInputStream din;
							din = new DataInputStream(s.getInputStream());
							clientInput = din.readUTF();
						}catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	clientInput = clientInput.substring(PokemonClient.MY_NAME_EXPORT.length());
			        	int enemyIndex = clientInput.indexOf(PokemonClient.ENEMY_NAME_EXPORT);
			        	
			        	String name = clientInput.substring(0, enemyIndex);
			        	
			        	clientInput = clientInput.substring(enemyIndex + PokemonClient.ENEMY_NAME_EXPORT.length());
			        	
			        	int newTrainerIndex = clientInput.indexOf(PokemonClient.NEW_TRAINER_EXPORT);
			        	
			        	String enemyName = clientInput.substring(0, newTrainerIndex);
			        	
			        	clientInput = clientInput.substring(newTrainerIndex + PokemonClient.NEW_TRAINER_EXPORT.length());
			        	
			        	String teamString = clientInput;
			        	
			        	System.out.println("Name " + name);
			        	
			        	boolean partnerFound = false;
			        	
			        	for(int i = 0;i<pairs.size();i++){
			        		ClientPair pair = pairs.get(i);
			        		if(pair.isUnPaired()){
			        			if(pair.getFirstName().equals(enemyName)){
			        				partnerFound = true;
			        				pair.add(s, name, teamString);
			        			}
			        		}
			        	}
			        	if(!partnerFound){
			        		ClientPair newPair = new ClientPair(server);
			        		newPair.add(s, name, teamString);
			        		pairs.add(newPair);
			        	}
			        	
			        	// Tell the world we've got it
						System.out.println("Connection from " + s);
					}
	        		
	        	}).start();
	        }
	        
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	// Remove a socket, and it's corresponding output stream, from our
	// list. This is usually called by a connection thread that has
	// discovered that the connectin to the client is dead.
	/*public void removeConnection(Socket s){
		synchronized(pairs){
			// Tell the world
			System.out.println( "Removing connection to "+s );
			for(ClientPair cp: pairs){
				if(cp.contains(s)){
					if(cp.isFirstSocket(s)){
						cp.sendToSecondSocket("disconnect");
					} else{
						cp.sendToFirstSocket("disconnect");
					}
					pairs.remove(cp);
					break;
				}
			}
			// Make sure it's closed
			try {
				s.close();
			} catch( IOException ie ) {
				System.out.println( "Error closing "+s );
				ie.printStackTrace();
			}
		}
	}*/

	/**
	 * @return the pairs
	 */
	public ArrayList<ClientPair> getPairs() {
		return pairs;
	}

	/*public void send(String message, Socket s) {
		for(ClientPair cp: pairs){
			if(cp.contains(s)){
				if(cp.isFirstSocket(s)){
					cp.sendToSecondSocket(message);
				} else{
					cp.sendToFirstSocket(message);
				}
			}
		}
	}*/


}
