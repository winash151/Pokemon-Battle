package engine.moves.bug;

import engine.moves.Move;

public class Megahorn extends BugMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public Megahorn() {
		super(224, Move.PHYSICAL, 120, 0.85, 10, "Megahorn");
		setDescription("Using its tough and impressive horn, the user rams into the target with no letup.");
	}

	@Override
	public Move newInstance() {
		return new Megahorn();
	}
}
