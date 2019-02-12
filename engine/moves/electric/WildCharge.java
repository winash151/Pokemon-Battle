package engine.moves.electric;

import engine.InBattlePokemon;
import engine.moves.Move;

public class WildCharge extends ElectricMove {

	/**
	 * id 117
	 * physical move
	 * 120 base power
	 * 100 base accuracy
	 * pp 15
	 * inflicts burn 10% of the time
	 * blocked by protect
	 */
	public WildCharge() {
		super(528, Move.PHYSICAL, 90, 1.0, 15, "Wild Charge");
		setRecoil(true);
		setDescription("The user shrouds itself in electricity and smashes into its target. This also damages the user a little.");
	}

	/**
	 * takes a third recoil damage
	 */
	public int recoilDamage(InBattlePokemon user, int damageDone) {
		int recoil = (int) (damageDone / 4.0);
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
		return new WildCharge();
	}
}
