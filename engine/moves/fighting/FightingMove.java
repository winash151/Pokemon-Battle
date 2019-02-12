package engine.moves.fighting;

import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class FightingMove extends Move {

	public FightingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.FIGHTING, kind, basePower, accuracy, totalPP, name,
				status, statusProbability);
	}
	
	public FightingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.FIGHTING, kind, basePower, accuracy, totalPP, name,
				speedPriority, criticalHitBoost);
		// TODO Auto-generated constructor stub
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
	public FightingMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.FIGHTING, kind, accuracy, totalPP, name, status,
				statusProbability);
		// TODO Auto-generated constructor stub
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
	public FightingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.FIGHTING, kind, basePower, accuracy, totalPP, name,
				speedPriority);
		// TODO Auto-generated constructor stub
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
	public FightingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.FIGHTING, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority);
		// TODO Auto-generated constructor stub
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
	public FightingMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.FIGHTING, kind, basePower, accuracy, totalPP, name);
		// TODO Auto-generated constructor stub
	}

	public FightingMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.FIGHTING, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}

	public FightingMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.FIGHTING, kind, 0, accuracy, totalPP, name, null, 0,
				0);
	}
	
	public FightingMove(int idNum, String kind, double accuracy, int totalPP,
			String name, int speedPriority) {
		super(idNum, Types.FIGHTING, kind, 0, accuracy, totalPP, name, null, 0,
				speedPriority);
	}
}
