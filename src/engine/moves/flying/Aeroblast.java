package engine.moves.flying;

import engine.moves.Move;

public class Aeroblast extends FlyingMove {

	/**
	 * id 127
	 * special move
	 * base power 100
	 * base accuracy 95
	 * pp 5
	 * high crit rate
	 */
	public Aeroblast() {
		super(177, Move.SPECIAL, 100, .95, 5, "Aeroblast", 0, 1);
		setDescription("A vortex of air is shot at the target to inflict damage. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new Aeroblast();
	}
}
