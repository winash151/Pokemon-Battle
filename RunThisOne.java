import javax.swing.JApplet;

import networking.PokemonClient;


public class RunThisOne extends JApplet{

	private static final long serialVersionUID = 8831070381585038171L;
	
	public void init(){
		PokemonClient.main(new String[]{});
	}
}
