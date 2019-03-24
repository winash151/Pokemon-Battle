package networking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

//import javax.sound.midi.MidiSystem;
//import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

//import com.sun.media.sound.SF2Soundbank;
//import com.sun.media.sound.SoftSynthesizer;



import javazoom.jl.decoder.JavaLayerException;
import engine.moves.*;
import bgm.MP3Player;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import engine.Ability;
import engine.Battle;
import engine.PartyPokemon;
import engine.Pokedex;
import engine.Pokemon;
import engine.RandomGen;
import engine.Trainer;
import graphics.Display;
import graphics.FontMetricsWrapper;
import graphics.ImageGetter;

//import javafx.embed.swing.JFXPanel;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

public class PokemonClient {
	
	//the battle that this server is emulating
	private Battle battle;
	// The ServerSocket we'll use for accepting new connections
	// A mapping from sockets to DataOutputStreams. This will
	// help us avoid having to create a DataOutputStream each time
	// we want to write to a stream.
	private DataOutputStream dout;
	private Socket socket;
	private DataInputStream din;

	//setting up the intro music
	/*private URL openingURL = getClass().getClassLoader().getResource("fireredtitle.mp3");
	private Media openingMusic;
	private MediaPlayer openingPlayer;
	
	//setting up the battle background music
	private URL battleURL = getClass().getClassLoader().getResource("fireredtrainerbattle.mp3");
	private Media battleMusic;
	private MediaPlayer battlePlayer;*/
	
	//MidiPlayer loading = new MidiPlayer("titlescreen.mid", true);
	//MidiPlayer bgm = new MidiPlayer("trainerbattle.mid", true);

	//the loading frame
	private JFrame loadingFrame = new JFrame();
	
	private JPanel loadingPanel = new JPanel(){

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image snorlaxImage  = new ImageGetter().getImage("snorlax.png");
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D canvas = (Graphics2D) g;
			canvas.drawImage(snorlaxImage,20,20,this);
		}
	};
	
	//the dimensions of the loading frame
	private int loadingWidth = 400;
	private int loadingHeight = 400;
	
	//the text area that will be added to the loading frame
	private JTextArea loadingArea;
	
	private MP3Player titlePlayer = new MP3Player(new String[] {"fireredtitle.mp3", "littleroot.mp3"}, true);
	private MP3Player battlePlayer = new MP3Player(new String[] { "frtrainer.mp3", "hgsslancered.mp3",
			"rslegend.mp3", "cynthia.mp3", "bwplasma.mp3"}, true);

	public PokemonClient() {
		//need to do this so the javafx works
		//new JFXPanel();
		
		//start the music
		/*openingMusic = new Media(openingURL.toString());
		openingPlayer = new MediaPlayer(openingMusic);
		openingPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		battleMusic = new Media(battleURL.toString());
		battlePlayer = new MediaPlayer(battleMusic);
		battlePlayer.setCycleCount(MediaPlayer.INDEFINITE);
		openingPlayer.play();*/
		
		/*
		 * Midi stuff
		 */
		//InputStream stream = getClass().getClassLoader().getResourceAsStream("Pokemon FireRed.sf2");
		/*URL streamURL = null;
		try {
			streamURL = new URL("C:\\Program Files\\Java\\jre7\\lib\\audio\\Pokemon FireRed.sf2");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
		//File f = new File("C:\\Program Files\\Java\\jre7\\lib\\audio\\Pokemon FireRed.sf2");
		//System.out.println(f.getPath());
		/*SoftSynthesizer synth = null;
		SF2Soundbank sb = null;
		try {
			synth = (SoftSynthesizer) MidiSystem.getSynthesizer(); 
			synth.open();
			sb = new SF2Soundbank(stream);
			System.out.println(sb.getInstruments().length);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		System.out.println(synth.loadAllInstruments(sb));
		//synth.unloadAllInstruments(synth.getDefaultSoundbank());
		System.out.println(synth.getLoadedInstruments().length);
		
		//start the loading music
		loading.start();*/
		
		try {
			titlePlayer.start();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		titlePlayer.stop();*/
		
		//set the size of the loading frame
		loadingFrame.setSize(loadingWidth, loadingHeight);
		loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loadingPanel.setSize(loadingWidth, loadingHeight);
		//get the dimensions of the screen
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenDimension.getWidth();
		int screenHeight = (int) screenDimension.getHeight();
		
		int xCoordLoading = screenWidth/2-loadingWidth/2;
		int yCoordLoading = screenHeight/2-loadingHeight/2;
		
		loadingFrame.getContentPane().add(loadingPanel);
		
		loadingArea = new JTextArea(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public FontMetrics getFontMetrics(Font font) {
				return new FontMetricsWrapper(super.getFontMetrics(font)) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public int getHeight() {
						return 20; // Gives line height in pixels
					}
				};
			}
			
		};
		loadingPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		//loadingPanel.add(loadingArea);
		loadingArea.setOpaque(false);
		loadingArea.setEditable(false);
		loadingArea.setFont(new Font("Pokemon FireLeaf", Font.TRUETYPE_FONT, 18));
		loadingFrame.setTitle("loading");
		loadingFrame.setLocation(xCoordLoading, yCoordLoading);
		
		loadFont();
		
		new Thread(new Runnable(){
			public void run() {
				runClient();
			}
		}).start();
	}

	private void loadFont() {
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		InputStream fontStream = getClass().getClassLoader().getResourceAsStream("PKMNFL_1.TTF");
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontStream));
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveGame(String s) {
	 	BufferedWriter bufferedWriter = null;
	 	//FileSystemView filesys = FileSystemView.getFileSystemView();

	 	//File[] roots = filesys.getRoots();

	 	//File desktop = filesys.getHomeDirectory();
	 	
	 	JFileChooser fc = new JFileChooser();
	 	System.out.println("Save chosen");
        try {
        	
			int returnVal = fc.showSaveDialog(loadingFrame);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				try{
					File oldsave = fc.getSelectedFile();
					oldsave.delete();
				} catch(Exception e){}
				File newsave = fc.getSelectedFile();
				newsave.createNewFile();
	            bufferedWriter = new BufferedWriter(new FileWriter(newsave));
	            bufferedWriter.write(s);
			}
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         }
	 }
	
	public String loadGame() {
		FileSystemView filesys = FileSystemView.getFileSystemView();

	 //	File[] roots = filesys.getRoots();

	 	File desktop = filesys.getHomeDirectory();
		File file = new File(desktop, "PokemonBattleTeams/profile.sav");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedReader dis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new BufferedReader(new InputStreamReader(bis));
			String s = dis.readLine();
			fis.close();
			bis.close();
			dis.close();
			
			return s;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String stringo = "MjQuMjE4LjE3Ny4xMTA=";
	private String stringy = "MTkyLjE2OC4yLjE1MQ==";
	private String lemongoose = "MjM0OTI=";
	public static final String NEW_TRAINER_EXPORT = "NewTrainer:";
	public static final String MY_NAME_EXPORT = "MyName:";
	public static final String ENEMY_NAME_EXPORT = "EnemyName:";
	
	private class ComboChoiceListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unchecked")
			JComboBox<Pokemon> cb = (JComboBox<Pokemon>)e.getSource();
	        Pokemon pokemon = (Pokemon) cb.getSelectedItem();
	        
	        int gender;
	        if(Math.random()<0.5){
	        	gender = PartyPokemon.MALE;
	        } else{
	        	gender = PartyPokemon.FEMALE;
	        }
	        
	        homey.add(new PartyPokemon(pokemon, gender, 100));
	        
	        pokemonChosen++;
		}
	}
	
	private int pokemonChosen = 0;
	private ArrayList<PartyPokemon> homey = new ArrayList<PartyPokemon>(6);

	/**
	 * Runs the script for hosting the game
	 */
	public void runClient() {
		boolean connected = false;
		while(!connected){
			loadingFrame.setVisible(true);
			
			try {
				loadingArea.setText("loading...");
				loadingFrame.setVisible(true);
				
				String name = JOptionPane.showInputDialog("What is your name?");
				String enemyName = JOptionPane.showInputDialog("What is your opponent's name?");
				String hostString = JOptionPane.showInputDialog("Host Address: " );
				//String enemyName;
				
				//String name = "Blue";
				//String enemyName = "Red";
				
				JComboBox<Pokemon> cb = new JComboBox<Pokemon>(Pokedex.getPokedex());
				loadingPanel.add(cb);
				cb.setSize(loadingWidth, 30);
				loadingFrame.repaint();
				cb.addActionListener(new ComboChoiceListener());
				
				while(pokemonChosen<6){
					System.out.print("");
				}
				
				loadingPanel.remove(cb);
				
				cb = null;
				
				/*if(name.equals("r")){
					name = "Red";
					enemyName = "Blue";
					homey.add(new PartyPokemon(Pokedex.Zoroark,100));
					homey.add(new PartyPokemon(Pokedex.Zubat,100));
					homey.add(new PartyPokemon(Pokedex.Tentacruel,100));
					homey.add(new PartyPokemon(Pokedex.Vileplume,100));
					homey.add(new PartyPokemon(Pokedex.Whiscash,100));
					homey.add(new PartyPokemon(Pokedex.Weavile,100));
				} else {
					name = "Blue";
					enemyName = "Red";
					homey.add(new PartyPokemon(Pokedex.Wailord,100));
					homey.add(new PartyPokemon(Pokedex.Walrein,100));
					homey.add(new PartyPokemon(Pokedex.Xatu,100));
					homey.add(new PartyPokemon(Pokedex.Yveltal,100));
					homey.add(new PartyPokemon(Pokedex.Zangoose,100));
					homey.add(new PartyPokemon(Pokedex.Zapdos,100));
				}*/
				
				loadingPanel.add(loadingArea);
				
				loadingPanel.revalidate();
				
				loadingFrame.repaint();
				
				int j = 0;
				for (PartyPokemon p : homey) {
					Move[] moves = new Move[4];
					int i = 0;
					System.out.println(j);
					System.out.println(p.getName());
					for (Move m : p.getPotentialMoves()) {
						System.out.println(p.getPotentialMoves().get(i).getName());
						moves[i] = m.newInstance();
						i++;
					}
					p.setMoves(moves);
					j++;
					Ability ability = p.getPotentialAbilities().get(0);
					p.setAbility(ability);
				}
	
				Trainer home = new Trainer(name, homey, true);
				
				//System.setProperty("java.net.preferIPv4Stack" , "true");
				
				// Initiate the connection
				System.out.println("eiubgf" + InetAddress.getLocalHost().getHostAddress());
				
				
				socket = new Socket(hostString, Integer.parseInt(new String(Base64.decode(lemongoose))));
				
				/*try {
					socket = new Socket(new String(Base64.decode(stringo)), Integer.parseInt(new String(Base64.decode(lemongoose))));
				} catch(Exception e) {
					socket = new Socket(new String(Base64.decode(stringy)), Integer.parseInt(new String(Base64.decode(lemongoose))));
				}*/
				
				
				//socket = new Socket(hostString, Integer.parseInt(new String(Base64.decode(lemongoose))));
				socket.setKeepAlive(true);
				
				
				System.out.println("Socket in client server so timeout: " + socket.getKeepAlive());
				
				// We got a connection! Tell the world
				System.out.println("connected to " + socket);
				System.out.println("Local port: " + socket.getLocalPort());
				System.out.println("Port: " + socket.getPort());
				System.out.println(socket.getInetAddress().getCanonicalHostName());
				connected = true;
				
				// Let's grab the streams and create DataInput/Output streams
				// from them
				din = new DataInputStream(socket.getInputStream());
				dout = new DataOutputStream(socket.getOutputStream());
				
				System.out.println("got output and input streams");
				
				dout.writeUTF(MY_NAME_EXPORT + name + ENEMY_NAME_EXPORT + enemyName + NEW_TRAINER_EXPORT + home.exportAsString());
				
				String infoString;
				
				while(true){
					infoString = din.readUTF();
					if(infoString.equals("keepalive")){
						processInput(infoString);
					} else {
						break;
					}
				}
				
				
				infoString = infoString.substring(ClientPair.RANDOM_INDEX_EXPORT.length());
				
				int otherTeamIndex = infoString.indexOf(ClientPair.OTHER_TEAM_EXPORT);
				
				int random = Integer.parseInt(infoString.substring(0,otherTeamIndex));
				
				infoString = infoString.substring(otherTeamIndex + ClientPair.OTHER_TEAM_EXPORT.length());
				
				int speedTieIndex = infoString.indexOf(ClientPair.SPEED_TIE_EXPORT);
				
				String awayTrainerString = infoString.substring(0, speedTieIndex);
				
				infoString = infoString.substring(speedTieIndex + ClientPair.SPEED_TIE_EXPORT.length());
				
				boolean speedTie = infoString.equals("true");
				
				Trainer away = Trainer.generateFromExportString(awayTrainerString);
				
				randomGen.setSeed(random);
				home.setRandomGen(randomGen);
				away.setRandomGen(randomGen);
				
				//new JFrame("before create battle").setVisible(true);
				
				setBattle(new Battle(home, away));
				
				battle.setSpeedTie(speedTie);
				
				battle.setRandomGen(randomGen);
				
				//loading.setVisible(false);
				
				//new JFrame("before create display").setVisible(true);
				
				
				display = new Display(this/*, loadingFrame*/);
				
				//new JFrame("before set display").setVisible(true);
				
				battle.setDisplay(display);
				
				//new JFrame("before set battle").setVisible(true);
				
				display.setBattle(battle);
				
				
				//new JFrame("before stop").setVisible(true);
				
				titlePlayer.stop();
				
			//	new JFrame("after stop").setVisible(true);
				battlePlayer.start();
				
				//new JFrame("before frame").setVisible(true);
				
				loadingFrame.setVisible(false);
				display.startDisplay();
				

				//Pokedex.clearPokedex();
				//Moves.clearMoves();
				new Thread(new StringCatcher()).start();
				//System.gc();
			} catch (Exception ie) {
				ie.printStackTrace();
				JFrame errorFrame = new JFrame();
				JTextArea errorArea = new JTextArea();
				errorFrame.add(errorArea);
				errorFrame.setVisible(true);
				errorArea.setText(ie.getMessage());
			}
		}
	}
	
	private Display display;
	private RandomGen randomGen = new RandomGen();
	
	private class StringCatcher implements Runnable {
		@Override
		public void run() {
			try {
				// Create a DataInputStream for communication; the client
				// is using a DataOutputStream to write to us
				// Over and over, forever ...
				while (true) {
					// ... read the next message ...
					String message = din.readUTF();
					// ... tell the world ...
					System.out.println("processing " + message);
					// ... and have the server send it to all clients
					processInput(message);
				}
			} catch (EOFException ie) {
				// This doesn't need an error message
			} catch (IOException ie) {
				// This does; tell the world!
				ie.printStackTrace();
			} finally {
				// The connection is closed for one reason or another,
				// so have the server dealing with it
				//removeConnection(socket);
				JOptionPane.showMessageDialog(null, "Opponent has disconnectado...");
			}
		}
	}

	public  void send(String message) {
		try {
			dout.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void processInput(String message) {
		if(message.equals("keepalive")){
			try {
				dout.writeUTF("keepalive");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(message.equals("disconnect")){
			JOptionPane.showMessageDialog(null, "Opponent has disconnectedolo...");
		}
		else if (message.startsWith("opponentmove")) {
			message = message.substring(12);
			int moveChoice = Integer.parseInt(message);
			battle.setAwayMove(moveChoice);
		}
		else if (message.startsWith("switchchoice")) {
			message = message.substring(12);
			int switchChoice = Integer.parseInt(message);
			battle.setUpSwitchForAwayTeam(switchChoice);
		}
	}

	public void removeConnection(Socket s) {
		System.exit(0);
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public static void main(String[] args) {
		// Create a Server object, which will automatically begin
		// accepting connections.
		
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new PokemonClient();
			}
		});
		
	}
}
