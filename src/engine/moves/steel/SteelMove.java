package engine.moves.steel;

import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class SteelMove extends Move {

	public SteelMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.STEEL, kind, basePower, accuracy, totalPP, name,
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
	public SteelMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.STEEL, kind, accuracy, totalPP, name, status,
				statusProbability);
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
	public SteelMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.STEEL, kind, basePower, accuracy, totalPP, name,
				speedPriority);
	}

	public SteelMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.STEEL, kind, basePower, accuracy, totalPP, name,
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
	public SteelMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.STEEL, kind, basePower, accuracy, totalPP, name,
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
	public SteelMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.STEEL, kind, basePower, accuracy, totalPP, name);
	}

	public SteelMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.STEEL, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}
}
