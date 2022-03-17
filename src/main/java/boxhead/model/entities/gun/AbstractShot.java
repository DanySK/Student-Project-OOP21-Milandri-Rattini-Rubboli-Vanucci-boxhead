package boxhead.model.entities.gun;

import boxhead.model.entities.AbstractEntity;
import boxhead.model.entities.EntityType;
import boxhead.model.entities.utils.Direction;
import javafx.geometry.Point2D;

/**
 * Abstract shot that implements shot and that will be extended by Bullet
 */
public abstract class AbstractShot extends AbstractEntity implements Shot {
	
	private final int damage;

	public AbstractShot(Point2D position, EntityType entityType, final int damage) {
		super(position, entityType);
		this.damage = damage;
	}
	
	/**
	 * @return
	 * 			The trajectory of the shot
	 */
	protected abstract Trajectory getTrajectory();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Point2D getSpeed() {
		final double vel = this.getTrajectory().getSpeed();
		final Point2D dir = this.getTrajectory().getDirection().traduce();
		return new Point2D(vel * dir.getX(), vel * dir.getY());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Direction getDirection() {
		return this.getTrajectory().getDirection();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		this.getTrajectory().update();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean hasEnded() {
		return this.getTrajectory().hasEnded();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int getDamage() {
		return this.damage;
	}
	
	/**
	 * Not implemented because it's not necessary to change the speed of an attack
	 */
	@Override
	public void setSpeed(Point2D speed) {
		
	}
	
	/**
	 * Not implemented because it's not necessary to change the direction of an attack
	 */
	@Override
	public void setDirection(Direction direction) {
		
	}
}
