package engine.moves.psychic;

import engine.moves.Move;

public class PsychoCut extends PsychicMove {

	/**
	 * id 296
	 * physical move
	 * base power 70
	 * base accuracy 100
	 * pp 20
	 * high crit rate
	 */
	public PsychoCut() {
		super(427, Move.PHYSICAL, 70, 1.0, 20, "Psycho Cut", 0, 1);
		setDescription("The user tears at the target with blades formed by psychic power. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new PsychoCut();
	}
}