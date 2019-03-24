package engine.moves.normal;

import engine.moves.Move;

public class Boomburst extends NormalMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public Boomburst() {
		super(586, Move.SPECIAL, 140, 1.0, 10, "Boomburst");
		setSound(true);
		setDescription("The user attacks everything around it with the destructive power of a terrible, explosive sound.");
	}

	@Override
	public Move newInstance() {
		return new Boomburst();
	}
}
