package engine.moves.fire;

import engine.Statuses;
import engine.moves.Move;

public class HeatWave extends FireMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public HeatWave() {
		super(257, Move.SPECIAL, 95, .9, 10, "Heat Wave", Statuses.BURN,
				0.1);
		setDescription("The user attacks by exhaling hot breath on the opposing Pokémon. This may also leave those Pokémon with a burn.");
	}

	@Override
	public Move newInstance() {
		return new HeatWave();
	}
}