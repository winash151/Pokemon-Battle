package engine.moves.ice;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Statuses;
import engine.Types;
import engine.moves.Move;

public class FreezeDry extends IceMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public FreezeDry() {
		super(573, Move.SPECIAL, 70, 1.0, 20, "Freeze Dry", Statuses.FROZEN,
				0.1);
		setDescription("The user rapidly cools the target. This may also leave the target frozen. This move is super effective on Water types.");
	}
	
	public double getEffectiveness(InBattlePokemon user, InBattlePokemon target) {
		double effectiveness;
		
		if(target.getFirstType().equals(Types.WATER)) {
			effectiveness = getType().effectivenessAgainst(target.getSecondType())*2;
		} else if(target.getSecondType().equals(Types.WATER)) {
			effectiveness = getType().effectivenessAgainst(target.getFirstType())*2;
		} else {
			effectiveness = target.getTypeDamageFrom(getType());
		}
		
		if (user.getAbility().equals(Abilities.TINTED_LENS)) {
			if (effectiveness < 1) {
				effectiveness *= 2;
			}
		}
		return effectiveness;
	}

	@Override
	public Move newInstance() {
		return new FreezeDry();
	}

}