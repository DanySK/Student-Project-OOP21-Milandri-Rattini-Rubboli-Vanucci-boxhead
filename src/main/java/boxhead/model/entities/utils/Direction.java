package boxhead.model.entities.utils;

import javafx.geometry.Point2D;

public enum Direction {
	NORTH(0,1),
	
	NORTH_EAST(0.707,0.707),
	
	EAST(1,0),
	
	SOUTH_EAST(0.707,-0.707),
	
	SOUTH(0,-1),

	SOUTH_WEST(-0.707,-0.707),
	
	WEST(-1,0),
	
	NORTH_WEST(-0.707,0.707);
	
	private final Point2D direction;
	
	Direction(final double x, final double y) {
		this.direction = new Point2D(x, y);
	}
	
	public final Point2D traduce() {
		return this.direction;
	}
}
