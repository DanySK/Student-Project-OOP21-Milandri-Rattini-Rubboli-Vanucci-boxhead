package boxhead.model.entities.utils;

import javafx.geometry.Point2D;

public enum Direction {
	NORTH(0,1),
	
	NORTH_EAST(1,1),
	
	EAST(1,0),
	
	SOUTH_EAST(1,-1),
	
	SOUTH(0,-1),

	SOUTH_WEST(-1,-1),
	
	WEST(-1,0),
	
	NORTH_WEST(-1,1);
	
	private final Point2D direction;
	
	Direction(final int x, final int y) {
		this.direction = new Point2D(x, y);
	}
	
	public final Point2D traduce() {
		return this.direction;
	}
}
