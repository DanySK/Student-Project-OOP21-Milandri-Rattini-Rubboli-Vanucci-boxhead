package boxhead.model.entities.gun;

import boxhead.model.entities.ActiveEntity;

public interface Shot extends ActiveEntity {
	
	/**
	 * @return True if the shot has ended his trajectory
	 */
	boolean hasEnded();
	
	/**
	 * @return The amount of damage the shot does
	 */
	int getDamage();
}
