package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class DrainPunch extends FightingMove {

	/**
	 * id 365
	 * special
	 * base power 90
	 * base accuracy 100 percent
	 * pp 10
	 */
	public DrainPunch() {
		super(409, Move.PHYSICAL, 75, 1.0, 10, "Drain Punch");
		setDescription("An energy-draining punch. The user's HP is restored by half the damage taken by the target.");
		setPunch(true);
	}
	
	public void healBack(InBattlePokemon user, int damageDone) {
		user.increaseHP(damageDone/2);
	}
	
	
	@Override
	public Move newInstance() {
		return new DrainPunch();
	}

}