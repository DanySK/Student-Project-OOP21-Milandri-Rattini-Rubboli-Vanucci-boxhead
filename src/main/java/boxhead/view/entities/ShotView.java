package boxhead.view.entities;

import javafx.geometry.Point2D;
import boxhead.view.spriteutils.Sprite;

public interface ShotView {

	/**
	 * Used to calculate the rotation of the Shot sprite
	 * @param pivot
	 * @param second
	 */
	void setRotation(Point2D pivot, Point2D second);
	
	/**
	 * Used to set the direction of the shot sprite
	 * @param angle
	 */
	void setDirection(double angle);
	
	/**
	 * @return
	 * 			The sprite of the Shot
	 */
	Sprite getSprite();
}
