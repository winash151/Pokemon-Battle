package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class DoubleEdge extends NormalMove {

	/**
	 * id 117
	 * physical move
	 * 120 base power
	 * 100 base accuracy
	 * pp 15
	 * inflicts burn 10% of the time
	 * blocked by protect
	 */
	public DoubleEdge() {
		super(38, Move.PHYSICAL, 120, 1.0, 15, "Double-Edge");
		setRecoil(true);
		setDescription("A reckless, life-risking tackle. This also damages the user quite a lot.");
	}

	/**
	 * takes a third recoil damage
	 */
	public int recoilDamage(InBattlePokemon user, int damageDone) {
		int recoil = (int) (damageDone / 3.0);
		if (recoil > user.getCurrentHP())
			recoil = user.getCurrentHP();
		user.deductHP(recoil);
		System.out.println(user.getName() + " took " + recoil
				+ " in recoil damage.");
		user.getDisplay().consolePrintln(user.getName() + " sustained recoil damage.");
		return recoil;
	}

	@Override
	public Move newInstance() {
		return new DoubleEdge();
	}
}
