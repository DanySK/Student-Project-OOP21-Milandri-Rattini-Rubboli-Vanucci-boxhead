package boxhead.model.entities.utils;

import javafx.geometry.Point2D;

public enum Direction {
	NORTH(0,1,90),
	
	NORTH_EAST(0.707,0.707,135),
	
	EAST(1,0,0),
	
	SOUTH_EAST(0.707,-0.707,315),
	
	SOUTH(0,-1,270),

	SOUTH_WEST(-0.707,-0.707,225),
	
	WEST(-1,0,180),
	
	NORTH_WEST(-0.707,0.707,135),
	
	NULL(0,0,-1);
	
	private final Point2D direction;
	private final double angle;
	
	Direction(final double x, final double y, final double angle) {
		this.direction = new Point2D(x, y);
		this.angle = angle;
	}
	
	public final double getX() {
		return this.direction.getX();
	}
	
	public final double getY() {
		return this.direction.getY();
	}
	
	public final Point2D traduce() {
		return this.direction;
	}
	
	public final double getAngle() {
		return this.angle;
	}
}
