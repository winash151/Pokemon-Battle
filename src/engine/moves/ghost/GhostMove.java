package engine.moves.ghost;

import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class GhostMove extends Move {

	public GhostMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.GHOST, kind, basePower, accuracy, totalPP, name,
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
	public GhostMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.GHOST, kind, accuracy, totalPP, name, status,
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
	public GhostMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.GHOST, kind, basePower, accuracy, totalPP, name,
				speedPriority);
		// TODO Auto-generated constructor stub
	}

	public GhostMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.GHOST, kind, basePower, accuracy, totalPP, name,
				speedPriority, criticalHitBoost);
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
	public GhostMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.GHOST, kind, basePower, accuracy, totalPP, name,
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
	public GhostMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.GHOST, kind, basePower, accuracy, totalPP, name);
		// TODO Auto-generated constructor stub
	}

	public GhostMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.GHOST, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}
}
