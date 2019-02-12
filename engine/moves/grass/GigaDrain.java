package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class GigaDrain extends GrassMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public GigaDrain() {
		super(202, Move.SPECIAL, 75, 1.0, 10, "Giga Drain");
		setDescription("A nutrient-draining attack. The user's HP is restored by half the damage taken by the target.");
	}
	
	public void healBack(InBattlePokemon user, int damageDone) {
		user.increaseHP(damageDone/2);
	}
	
	
	@Override
	public Move newInstance() {
		// TODO Auto-generated method stub
		return new GigaDrain();
	}

}