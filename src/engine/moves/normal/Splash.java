package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Splash extends NormalMove{
	
	/**
	 * id 304
	 * status move
	 * pp 40
	 */
	public Splash() {
		super(150, Move.STATUS, 40, "Splash");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user just flops and splashes around to no effect at all...");
	}

	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		user.getDisplay().consolePrintln(user.getName() + " used " + getName() + "! But nothing happened...");
		cleanUp(user, target);
		return true;
	}

	@Override
	public Move newInstance() {
		return new Splash();
	}
}
