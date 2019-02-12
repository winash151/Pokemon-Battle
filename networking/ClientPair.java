package networking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import javax.swing.Timer;

public class ClientPair {
	private Socket firstSocket;
	private Socket secondSocket;
	private String firstName;
	private String secondName;
	private String firstTeam;
	private String secondTeam;
	private DataOutputStream firstDout;
	private DataOutputStream secondDout;
	private PokemonServer server;
	private KeepAliveTimer firstTimer;
	private KeepAliveTimer secondTimer;

	public ClientPair(PokemonServer pokemonServer) {
		server = pokemonServer;
	}

	public void add(Socket s, String name, String teamString) {
		try {
			s.setKeepAlive(true);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		if(isEmpty()){
			firstSocket=s;
			try {
				firstDout = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			firstName = name;
			firstTeam = teamString;
			new Thread(new FirstStringCatcher()).start();
			firstTimer = new KeepAliveTimer(firstDout);
			firstTimer.start();
		}
		else if(isUnPaired()){
			secondSocket = s;
			try {
				secondDout = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			secondName = name;
			secondTeam = teamString;
			
			int random = (int) (Math.random()*100000);
			
			try {
				firstDout = new DataOutputStream(firstSocket.getOutputStream());
				secondDout = new DataOutputStream(secondSocket.getOutputStream());
				firstDout.writeUTF(RANDOM_INDEX_EXPORT + random + OTHER_TEAM_EXPORT + secondTeam + SPEED_TIE_EXPORT + "false");
				secondDout.writeUTF(RANDOM_INDEX_EXPORT + random + OTHER_TEAM_EXPORT + firstTeam + SPEED_TIE_EXPORT + "true");
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Thread(new SecondStringCatcher()).start();
			secondTimer = new KeepAliveTimer(secondDout);
			secondTimer.start();
		}
	}
	
	public static final String RANDOM_INDEX_EXPORT = "RI";
	public static final String OTHER_TEAM_EXPORT = "otherteam";
	public static final String SPEED_TIE_EXPORT = "speedtie";
	
	private class FirstStringCatcher implements Runnable{

		@Override
		public void run() {
			try {
				DataInputStream din = new DataInputStream(firstSocket.getInputStream());
				// Over and over, forever ...
				while (true) {
					// ... read the next message ...
					String message = din.readUTF();
					if(!message.equals("keepalive")){
						// ... tell the world ...
						System.out.println("Sending " + message);
						// ... and have the server send it to all clients
						secondDout.writeUTF(message);
					}
					
				}
			} catch (EOFException ie) {
				// This doesn't need an error message
			} catch (IOException ie) {
				// This does; tell the world!
				ie.printStackTrace();
			} finally {
				ArrayList<ClientPair> pairs = server.getPairs();
				try {
					secondDout.writeUTF("disconnect");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				synchronized(pairs){
					pairs.remove(this);
				}
				try {
					firstSocket.close();
					secondSocket.close();
					firstTimer.stop();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class KeepAliveTimer extends Timer{
		/**
		 * 
		 */
		private static final long serialVersionUID = -4306540979050179644L;

		public KeepAliveTimer(DataOutputStream dout) {
			super(1000*60, new KeepAliveListener(dout));
		}
	}
	
	private class KeepAliveListener implements ActionListener{
		private DataOutputStream dout;
		public KeepAliveListener(DataOutputStream dout) {
			this.dout = dout;
		}
		
		public void actionPerformed(ActionEvent e) {
			new KeepAliveThread(dout).start();
		}
	}
	
	private class KeepAliveThread extends Thread{
		public KeepAliveThread(final DataOutputStream dout){
			super(new Runnable(){
				public void run() {
					try {
						dout.writeUTF("keepalive");
					} catch (IOException e) {
						e.printStackTrace();
					};
				}
			});
		}
	}
	
	private class SecondStringCatcher implements Runnable{

		public void run() {
			try {
				DataInputStream din = new DataInputStream(secondSocket.getInputStream());
				// Over and over, forever ...
				while (true) {
					// ... read the next message ...
					String message = din.readUTF();
					if(!message.equals("keepalive")){
						// ... tell the world ...
						System.out.println("Sending " + message);
						// ... and have the server send it to all clients
						firstDout.writeUTF(message);
					}	
					
				}
			} catch (EOFException ie) {
				// This doesn't need an error message
			} catch (IOException ie) {
				// This does; tell the world!
				ie.printStackTrace();
			} finally {
				ArrayList<ClientPair> pairs = server.getPairs();
				try {
					firstDout.writeUTF("disconnect");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				synchronized(pairs){
					pairs.remove(this);
				}
				try {
					secondSocket.close();
					firstSocket.close();
					secondTimer.stop();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public boolean isPaired(){
		return firstSocket!=null && secondSocket!=null;
	}
	
	public boolean isUnPaired(){
		return firstSocket!=null && secondSocket == null;
	}
	
	public boolean isEmpty(){
		return firstSocket==null && secondSocket==null;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public boolean contains(Socket s) {
		return firstSocket==s || secondSocket==s;
	}

	/**
	 * @return the firstSocket
	 */
	public Socket getFirstSocket() {
		return firstSocket;
	}

	/**
	 * @param firstSocket the firstSocket to set
	 */
	public void setFirstSocket(Socket firstSocket) {
		this.firstSocket = firstSocket;
	}
	
	public boolean isFirstSocket(Socket s){
		return firstSocket==s;
	}
	
	public boolean isSecondSocket(Socket s){
		return secondSocket==s;
	}
	
	public void sendToFirstSocket(String message) {
		try {
			firstDout.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendToSecondSocket(String message) {
		try {
			secondDout.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
