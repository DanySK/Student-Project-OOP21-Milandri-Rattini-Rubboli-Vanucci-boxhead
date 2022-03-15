package boxhead.model.gun;

import boxhead.model.entities.AbstractEntity;
import boxhead.model.entities.EntityType;
import boxhead.model.entities.utils.Direction;
import javafx.geometry.Point2D;

public abstract class AbstractShot extends AbstractEntity implements Shot {
	
	private final int damage;

	public AbstractShot(Point2D position, EntityType entityType, final int damage) {
		super(position, entityType);
		this.damage = damage;
	}

	protected abstract Trajectory getTrajectory();
	
//	@Override
//	public final Point2D getSpeed() {
//		final double vel = this.getTrajectory().getSpeed();
//		return this.getTrajectory().getSpeed();
//	}

	@Override
	public Direction getDirection() {
		return this.getTrajectory().getDirection();
	}

	@Override
	public void update() {
		this.getTrajectory().update();
	}

	@Override
	public final boolean hasEnded() {
		return this.getTrajectory().hasEnded();
	}

	@Override
	public final int getDamage() {
		return this.damage;
	}
	
	/**
	 * It has no effects
	 */
	@Override
	public void setSpeed(Point2D speed) {
		
	}
	
	/**
	 * It has no effects
	 */
	@Override
	public void setDirection(Direction direction) {
		
	}
}
