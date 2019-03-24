package engine.moves.fire;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Overheat extends FireMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public Overheat() {
		super(315, Move.SPECIAL, 130, .9, 5, "Overheat");
		setDescription("The user attacks the target at full power. The attack's recoil harshly lowers the user's Sp. Atk stat.");
	}
	
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
		if(user.decreaseSpAttack(2, false, user)){
			user.getDisplay().animateStatDecrease(user);
		}
	}

	@Override
	public Move newInstance() {
		return new Overheat();
	}

}
