package boxhead.model.gun;

import java.util.Optional;

import javafx.geometry.Point2D;
import boxhead.model.entities.Entity;

/**
 * Represents a generic gun that creates a {@link Shot}
 */

public interface Gun extends Entity{

	/**
	 * Used to separate Gun types
	 */
	enum GunType {
		/**
		 * Pistol has low ammos and low rateOfFire
		 */
		PISTOL,
		/**
		 * Uzi has more ammos and higher rateOfFire
		 */
		UZI,
		/**
		 * Shotgun has highdamage and different type of shot
		 */
		SHOTGUN
	}
	
	String getName();
	
	Optional<Shot> attack(Point2D towards);
	
	int getDamage();
	
	GunType getGunType();
}
