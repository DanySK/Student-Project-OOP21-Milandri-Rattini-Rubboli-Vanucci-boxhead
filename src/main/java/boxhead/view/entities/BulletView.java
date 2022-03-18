package boxhead.view.entities;

import boxhead.model.entities.EntityType;
import boxhead.view.spriteutils.Sprite;
import javafx.geometry.Point2D;

public class BulletView implements ShotView {

	private final Sprite sprite;
	
	public BulletView() {
		this.sprite = new Sprite(EntityType.BULLET);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRotation(final Point2D pivot, final Point2D second) {
		final double disX = second.getX() - pivot.getX();
		final double disY = second.getY() - pivot.getY();
		final double angle = Math.atan2(disY, disX);
		this.setDirection(angle);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDirection(double angle) {
		this.getSprite().getImageView().setRotate(this.getSprite().getImageView().getRotate() + angle);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Sprite getSprite() {
		return this.getSprite();
	}
	
}
