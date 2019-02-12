package engine.moves.electric;

import engine.Statuses;
import engine.moves.Move;

public class Thunderbolt extends ElectricMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public Thunderbolt() {
		super(85, Move.SPECIAL, 90, 1.0, 15, "Thunderbolt", Statuses.PARALYSIS,
				0.1);
		setDescription("A strong electric blast crashes down on the target. This may also leave the target with paralysis.");
	}

	@Override
	public Move newInstance() {
		return new Thunderbolt();
	}
}
