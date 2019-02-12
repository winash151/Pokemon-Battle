package engine.moves.normal;

import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class NormalMove extends Move {

	public NormalMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.NORMAL, kind, basePower, accuracy, totalPP, name,
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
	public NormalMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.NORMAL, kind, accuracy, totalPP, name, status,
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
	public NormalMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.NORMAL, kind, basePower, accuracy, totalPP, name,
				speedPriority);
		// TODO Auto-generated constructor stub
	}

	public NormalMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.NORMAL, kind, basePower, accuracy, totalPP, name,
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
	public NormalMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.NORMAL, kind, basePower, accuracy, totalPP, name,
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
	public NormalMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.NORMAL, kind, basePower, accuracy, totalPP, name);
		// TODO Auto-generated constructor stub
	}

	public NormalMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.NORMAL, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}

	public NormalMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.NORMAL, kind, 0, accuracy, totalPP, name, null, 0, 0);
	}
	
	public NormalMove(int idNum, String kind, double accuracy, int totalPP,
			String name, int speedPriority) {
		super(idNum, Types.NORMAL, kind, 0, accuracy, totalPP, name, null, 0,
				speedPriority);
	}
}
