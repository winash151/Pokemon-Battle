package engine.moves.dragon;

import engine.InBattlePokemon;
import engine.moves.Move;

public class DracoMeteor extends DragonMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public DracoMeteor() {
		super(434, Move.SPECIAL, 130, .9, 5, "Draco Meteor");
		setDescription("Meteors are summoned down from the sky onto the target. "
				+ "The attack's recoil harshly lowers the user's Special Attack stat.");
	}
	
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
		if(user.decreaseSpAttack(2, false, user)){
			user.getDisplay().animateStatDecrease(user);
		}
	}

	@Override
	public Move newInstance() {
		return new DracoMeteor();
	}

}
