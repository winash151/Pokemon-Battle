package engine.moves.fighting;

import engine.moves.Move;

public class SkyUppercut extends FightingMove {

	/**
	 * id of 54 it is a special move the base power varies so... the accuracy is
	 * 100 percent the pp is 10
	 */
	public SkyUppercut() {
		super(327, Move.PHYSICAL, 85, .9, 15, "Sky Uppercut");
		setDescription("The user attacks the target with an uppercut thrown skyward with force.");
	}
	
	
	
	public Move newInstance() {
		return new SkyUppercut();
	}
}
