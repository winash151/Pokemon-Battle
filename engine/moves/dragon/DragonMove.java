package engine.moves.dragon;

import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class DragonMove extends Move {

	public DragonMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.DRAGON, kind, basePower, accuracy, totalPP, name,
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
	public DragonMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.DRAGON, kind, accuracy, totalPP, name, status,
				statusProbability);
	}

	public DragonMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.DRAGON, kind, basePower, accuracy, totalPP, name,
				speedPriority, criticalHitBoost);
		//
	}
	
	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public DragonMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.DRAGON, kind, accuracy, totalPP, name);
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
	public DragonMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.DRAGON, kind, basePower, accuracy, totalPP, name,
				speedPriority);
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
	public DragonMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.DRAGON, kind, basePower, accuracy, totalPP, name,
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
	public DragonMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.DRAGON, kind, basePower, accuracy, totalPP, name);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param totalPP
	 * @param name
	 */
	public DragonMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.DRAGON, kind, totalPP, name);
	}
}
