package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class HornLeech extends GrassMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public HornLeech() {
		super(532, Move.PHYSICAL, 75, 1.0, 10, "Horn Leech");
		setDescription("The user drains the target's energy with its horns. The user's HP is restored by half the damage taken by the target.");
	}
	
	public void healBack(InBattlePokemon user, int damageDone) {
		user.increaseHP(damageDone/2);
	}
	
	
	@Override
	public Move newInstance() {
		// TODO Auto-generated method stub
		return new HornLeech();
	}

}