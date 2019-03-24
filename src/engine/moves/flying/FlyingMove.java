package engine.moves.flying;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class FlyingMove extends Move {

	public FlyingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.FLYING, kind, basePower, accuracy, totalPP, name,
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
	public FlyingMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.FLYING, kind, accuracy, totalPP, name, status,
				statusProbability);
		//
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
	public FlyingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.FLYING, kind, basePower, accuracy, totalPP, name,
				speedPriority);
		//
	}

	public FlyingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.FLYING, kind, basePower, accuracy, totalPP, name,
				speedPriority, criticalHitBoost);
		//
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
	public FlyingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.FLYING, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority);
		//
	}
	
	public FlyingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority, int criticalHitBoost) {
		super(idNum, Types.FLYING, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority, criticalHitBoost);
		//
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
	public FlyingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.FLYING, kind, basePower, accuracy, totalPP, name);
		//
	}

	public FlyingMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.FLYING, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}
	
	public int getSpeedPriority(InBattlePokemon user, InBattlePokemon target) {
		if(user.getAbility().equals(Abilities.GALE_WINGS)){
			return getSpeedPriority()+1;
		}
		
		return getSpeedPriority();
	}
}
