package engine.moves.psychic;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Reflect extends PsychicMove {

	/**
	 * id 360
	 * status
	 * pp 30
	 * 
	 */
	public Reflect() {
		super(115, Move.STATUS, 20, "Reflect");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("A wondrous wall of light is put up to reduce damage from physical attacks for five turns.");
	}

	//sets up a light screen
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		user.setUpReflect();
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new Reflect();
	}

}
