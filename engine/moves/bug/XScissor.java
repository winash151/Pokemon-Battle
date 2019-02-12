package engine.moves.bug;

import engine.moves.Move;

public class XScissor extends BugMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public XScissor() {
		super(404, Move.PHYSICAL, 80, 1, 15, "X-Scissor");
		setDescription("The user slashes at the target by crossing its scythes or claws as if they were a pair of scissors.");
	}

	@Override
	public Move newInstance() {
		return new XScissor();
	}
}