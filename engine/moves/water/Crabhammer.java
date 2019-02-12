package engine.moves.water;

import engine.moves.Move;

public class Crabhammer extends WaterMove {

	/**
	 * id 127
	 * special move
	 * base power 100
	 * base accuracy 95
	 * pp 5
	 * high crit rate
	 */
	public Crabhammer() {
		super(152, Move.PHYSICAL, 100, .90, 10, "Crabhammer", 0, 1);
		setDescription("The target is hammered with a large pincer. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new Crabhammer();
	}
}
