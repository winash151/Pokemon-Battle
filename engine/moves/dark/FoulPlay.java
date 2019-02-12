package engine.moves.dark;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.moves.Move;

public class FoulPlay extends DarkMove {

	/**
	 * id 369
	 * special move
	 * 100 base power
	 * accuracy 100
	 */
	public FoulPlay() {
		super(492, Move.PHYSICAL, 95, 1.0, 10, "Foul Play");
		setDescription("The user turns the target's power against it. The higher the target's Attack stat, the greater the move's power.");
	}
	
	public int getAttackingStat(InBattlePokemon user, InBattlePokemon target) {
		int attackingStat;
		
		if (target.getAbility().equals(Abilities.UNAWARE)) {
			attackingStat = target.getAttackStat();
		} else {
			attackingStat = target.getAttack();
		}

		return attackingStat;
	}

	@Override
	public Move newInstance() {
		return new FoulPlay();
	}

}