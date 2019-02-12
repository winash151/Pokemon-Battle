package engine.moves.psychic;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.moves.Move;

public class Psyshock extends PsychicMove {

	/**
	 * id 369
	 * special move
	 * 100 base power
	 * accuracy 100
	 */
	public Psyshock() {
		super(473, Move.SPECIAL, 80, 1.0, 10, "Psyshock");
		setDescription("The user materializes an odd psychic wave to attack the target. This attack does physical damage.");
	}
	
	public int getDefendingStat(InBattlePokemon user, InBattlePokemon target) {
		int defendingStat;
		
		if (user.getAbility().equals(Abilities.UNAWARE)) {
			defendingStat = target.getDefenseStat();
		} else {
			defendingStat = target.getDefense();
		}

		return defendingStat;
	}

	@Override
	public Move newInstance() {
		return new Psyshock();
	}

}