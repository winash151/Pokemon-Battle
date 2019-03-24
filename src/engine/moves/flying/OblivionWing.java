package engine.moves.flying;

import engine.InBattlePokemon;
import engine.moves.Move;

public class OblivionWing extends FlyingMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public OblivionWing() {
		super(613, Move.SPECIAL, 80, 1.0, 10, "Oblivion Wing");
		setDescription("The user absorbs its target's HP. The user's HP is restored by over half of the damage taken by the target.");
	}
	
	public void healBack(InBattlePokemon user, int damageDone) {
		user.increaseHP(damageDone*3/4);
	}
	
	
	@Override
	public Move newInstance() {
		return new OblivionWing();
	}

}