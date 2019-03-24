import networking.PokemonClient;
import networking.PokemonServer;


public class RunThisOne{

//	private static final long serialVersionUID = 8831070381585038171L;
	
	public static void main(String [] args) {
		PokemonServer.main(args);
		PokemonClient.main(new String[]{});
	}
}
