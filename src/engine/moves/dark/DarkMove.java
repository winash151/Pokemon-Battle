package engine.moves.dark;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class DarkMove extends Move {

	public DarkMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.DARK, kind, basePower, accuracy, totalPP, name,
				status, statusProbability);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 */
	public DarkMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.DARK, kind, accuracy, totalPP, name, status,
				statusProbability);
	}
	
	public DarkMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.DARK, kind, 0, accuracy, totalPP, name, null, 0, 0);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param speedPriority
	 */
	public DarkMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.DARK, kind, basePower, accuracy, totalPP, name,
				speedPriority);
	}

	public DarkMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.DARK, kind, basePower, accuracy, totalPP, name,
				speedPriority, criticalHitBoost);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 * @param speedPriority
	 */
	public DarkMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.DARK, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public DarkMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.DARK, kind, basePower, accuracy, totalPP, name);
	}

	public DarkMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.DARK, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}
	
	public void damagingMoveDoesOtherStuff(InBattlePokemon user, InBattlePokemon target) {
		if(target.getAbility().equals(Abilities.JUSTIFIED)){
			if(target.increaseAttack(1, false, target)){
				target.getDisplay().animateAbility(target);
				target.getDisplay().animateStatIncrease(target);
			}
		}
	}

	
}
