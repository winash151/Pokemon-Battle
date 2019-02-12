package engine.moves.normal;

import engine.moves.Move;

public class HyperVoice extends NormalMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public HyperVoice() {
		super(304, Move.SPECIAL, 90, 1.0, 10, "Hyper Voice");
		setSound(true);
		setDescription("The user lets loose a horribly echoing shout with the power to inflict damage.");
	}

	@Override
	public Move newInstance() {
		return new HyperVoice();
	}
}
