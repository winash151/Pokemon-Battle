package engine.moves.fire;

import engine.InBattlePokemon;
import engine.moves.Move;

public class WillOWisp extends FireMove {

	/**
	 * id 346
	 * status
	 * base accuracy 90
	 * pp 10
	 */
	public WillOWisp() {
		super(92, Move.STATUS, 0.85, 15, "Will-O-Wisp");
		setDescription("The user shoots a sinister, bluish-white flame at the target to inflict a burn.");
	}

	/**
	 * badly poisons target
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(!target.burn(user)){
			user.getDisplay().consolePrintln("But it failed.");
		}
	}

	@Override
	public Move newInstance() {
		return new WillOWisp();
	}

}
