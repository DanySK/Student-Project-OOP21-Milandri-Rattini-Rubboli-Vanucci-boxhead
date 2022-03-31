package boxhead.model.entities.gun;

import boxhead.model.entities.EntityType;
import boxhead.model.entities.utils.Direction;
import javafx.geometry.Point2D;

/**
 * Normal shot of {@link GunImpl}
 */
public class Bullet extends AbstractShot {
	
	private static final double HEIGHT = 7;
	private static final double WIDTH = 3;
	private final Trajectory trajectory;

	/**
	 * Constructor of Bullet for Pistol and Uzi, where the Bullet has a starting point and a direction.
	 * @param start
	 * 			The starting point.
	 * @param direction
	 * 			The direction.
	 * @param damage
	 * 			The damage of the Bullet.
	 */
	public Bullet(final Point2D start, final Direction direction, final int damage) {
		super(start, EntityType.BULLET, damage);
		this.setBoundingBox(HEIGHT, WIDTH);
		this.trajectory = new StraightTrajectory(start, direction);
	}
	
	/**
	 * Constructor of Bullet for Shotgun, where the Bulled has a starting point and a target point.
	 * @param from
	 * 			The starting point.
	 * @param towards
	 * 			The target point
	 * @param damage
	 * 			The damage of the Bullet.
	 */
	public Bullet(final Point2D from, final Point2D towards, final int damage) {
		super(from, EntityType.BULLET, damage);
		this.setBoundingBox(HEIGHT, WIDTH);
		this.trajectory = new StraightTrajectory(from, towards);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Trajectory getTrajectory() {
		return this.trajectory;
	}
}
