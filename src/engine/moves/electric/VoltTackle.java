package engine.moves.electric;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class VoltTackle extends ElectricMove {

	/**
	 * id 117
	 * physical move
	 * 120 base power
	 * 100 base accuracy
	 * pp 15
	 * inflicts burn 10% of the time
	 * blocked by protect
	 */
	public VoltTackle() {
		super(344, Move.PHYSICAL, 120, 1.0, 15, "Volt Tackle", Statuses.PARALYSIS,
				0.1);
		setRecoil(true);
		setDescription("The user electrifies itself, then charges. This also damages the user quite a lot. This may leave the target with paralysis.");
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
		return new VoltTackle();
	}
}
