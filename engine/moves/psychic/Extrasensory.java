package engine.moves.psychic;

import engine.Statuses;
import engine.moves.Move;

public class Extrasensory extends PsychicMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public Extrasensory() {
		super(326, Move.SPECIAL, 80, 1, 20, "Extrasensory", Statuses.FLINCHED,
				0.1);
		setDescription("The user attacks with an odd, unseeable power. This may also make the target flinch.");
	}

	@Override
	public Move newInstance() {
		return new Extrasensory();
	}
}