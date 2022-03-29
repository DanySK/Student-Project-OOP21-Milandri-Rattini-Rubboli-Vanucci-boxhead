package boxhead.controller.entities;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import boxhead.model.entities.gun.Shot;
import boxhead.view.entities.ShotView;
import javafx.geometry.BoundingBox;

/**
 * Controller that manages the shots with {@link ShotManager} and {@link ShotView}.
 */
public interface ShotController {

	/**
	 * @return
	 * 			A set with all the active shots.
	 */
	Set<Shot> getShotsModel();
	
	/**
	 * @param obstacles
	 * 			A set with all the obstacles in the world with which the shots can crash.
	 */
	void setObstacles(Set<BoundingBox> obstacles);
	
	/**
	 * @return
	 * 			A map with all the active shots mapped with their shotView.
	 */
	Map<Shot, ShotView> getShots();
	
	/**
	 * Used to add a new shot to the model and view.
	 * @param shot
	 */
	void addShot(Optional<Shot> shot);
	
	/**
	 * Method to update the inner logic.
	 */
	void update();
}
