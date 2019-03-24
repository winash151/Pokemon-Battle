package engine.moves.rock;

import engine.Statuses;
import engine.moves.Move;

public class RockSlide extends RockMove {

	/**
	 * id 129
	 * special move
	 * base power 75
	 * base accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public RockSlide() {
		super(157, Move.PHYSICAL, 75, .9, 10, "Rock Slide", Statuses.FLINCHED,
				0.3);
		setDescription("Large boulders are hurled at the opposing Pokémon to inflict damage. This may also make the opposing Pokémon flinch.");
	}

	@Override
	public Move newInstance() {
		return new RockSlide();
	}
}
