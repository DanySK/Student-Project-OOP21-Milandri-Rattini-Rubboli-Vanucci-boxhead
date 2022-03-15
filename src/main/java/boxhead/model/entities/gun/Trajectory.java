package boxhead.model.entities.gun;

import javafx.geometry.Point2D;
import boxhead.model.entities.utils.Direction;

/**
 * Represents the trajectory of the shot
 */
public interface Trajectory {
	
	/**
	 * 
	 * @return The position at the current moment
	 */
	Point2D getCurrentPosition();
	
	/**
	 * 
	 * @return The direction at the current moment
	 */
	Direction getDirection();
	
	/**
	 * 
	 * @return The speed of the movement
	 */
	double getSpeed();
	
	/**
	 * 
	 * @return True if the movement has ended
	 */
	boolean hasEnded();
	
	/**
	 * Used to update the movement
	 */
	void update();
}
