package engine.moves.psychic;

import engine.InBattlePokemon;
import engine.moves.Move;

public class PsychoBoost extends PsychicMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public PsychoBoost() {
		super(354, Move.SPECIAL, 140, .9, 5, "Psycho Boost");
		setDescription("The user attacks the target at full power. The attack's recoil harshly lowers the user's Sp. Atk stat.");
	}
	
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
		if(user.decreaseSpAttack(2, false, user)){
			user.getDisplay().animateStatDecrease(user);
		}
	}

	@Override
	public Move newInstance() {
		return new PsychoBoost();
	}

}
