package graphics;

import java.awt.Point;

public class CubicBezierCurve extends BezierCurve {

	private Point p1, p2, p3, p4;

	
	/**
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 */
	public CubicBezierCurve(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}


	public Point getCoordAtDistance(double t) {
		int x = (int) (Math.pow(1-t, 3)*p1.x + 3*Math.pow(1-t, 2)*t*p2.x + 3*(1-t)*Math.pow(t, 2)*p3.x + Math.pow(t, 3)*p4.x);
		int y = (int) (Math.pow(1-t, 3)*p1.y + 3*Math.pow(1-t, 2)*t*p2.y + 3*(1-t)*Math.pow(t, 2)*p3.y + Math.pow(t, 3)*p4.y);
		
		return new Point(x, y);
	}

}
