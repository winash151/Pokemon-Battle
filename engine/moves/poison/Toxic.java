package engine.moves.poison;

import engine.InBattlePokemon;
import engine.Types;
import engine.moves.Move;

public class Toxic extends PoisonMove {

	/**
	 * id 346
	 * status
	 * base accuracy 90
	 * pp 10
	 */
	public Toxic() {
		super(92, Move.STATUS, 0.9, 10, "Toxic");
		setDescription("A move that leaves the target badly poisoned. Its poison damage worsens every turn.");
	}

	/**
	 * badly poisons target
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(!target.badlyPoison(user)){
			user.getDisplay().consolePrintln("But it failed.");
		}
	}
	
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		if(user.isType(Types.POISON))
			return true;
		return super.willHit(user, target);
	}

	@Override
	public Move newInstance() {
		return new Toxic();
	}

}
