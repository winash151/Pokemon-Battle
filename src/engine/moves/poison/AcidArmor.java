package engine.moves.poison;

import engine.InBattlePokemon;
import engine.moves.Move;

public class AcidArmor extends PoisonMove {

	/**
	 * id 3595
	 * status move
	 * pp 30
	 */
	public AcidArmor() {
		super(151, Move.STATUS, 20, "Acid Armor");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user alters its cellular structure to liquefy itself, sharply raising its Defense stat.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.increaseDefense(2, true, user)){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
	}


	@Override
	public Move newInstance() {
		return new AcidArmor();
	}

}
