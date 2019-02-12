package engine.moves.steel;

import engine.InBattlePokemon;
import engine.moves.Move;

public class IronDefense extends SteelMove {

	/**
	 * id 3595
	 * status move
	 * pp 30
	 */
	public IronDefense() {
		super(334, Move.STATUS, 30, "Iron Defense");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user hardens its body's surface like iron, sharply raising its Defense stat.");
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
		return new IronDefense();
	}

}
