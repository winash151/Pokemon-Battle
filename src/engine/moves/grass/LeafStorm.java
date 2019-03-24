package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class LeafStorm extends GrassMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public LeafStorm() {
		super(437, Move.SPECIAL, 130, .9, 5, "Leaf Storm");
		setDescription("The user whips up a storm of leaves around the target. The attack's recoil harshly lowers the user's Sp. Atk stat.");
	}
	
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
		if(user.decreaseSpAttack(2, false, user)){
			user.getDisplay().animateStatDecrease(user);
		}
	}

	@Override
	public Move newInstance() {
		return new LeafStorm();
	}

}
