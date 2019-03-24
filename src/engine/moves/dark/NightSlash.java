package engine.moves.dark;

import engine.moves.Move;

public class NightSlash extends DarkMove {

	/**
	 * id 31
	 * physical
	 * base power 70
	 * 100 base accuracy
	 * pp 15
	 * high crit rate
	 */
	public NightSlash() {
		super(400, Move.PHYSICAL, 70, 1.0, 15, "Night Slash", 0, 1);
		setDescription("Slash the target while its attention is diverted. It has a high critical-hit ratio.");
	}

	@Override
	public Move newInstance() {
		return new NightSlash();
	}

}
