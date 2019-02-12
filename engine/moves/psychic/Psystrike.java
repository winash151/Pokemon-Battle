package engine.moves.psychic;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.moves.Move;

public class Psystrike extends PsychicMove {

	/**
	 * id 369
	 * special move
	 * 100 base power
	 * accuracy 100
	 */
	public Psystrike() {
		super(540, Move.SPECIAL, 100, 1.0, 10, "Psystrike");
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
		return new Psystrike();
	}

}