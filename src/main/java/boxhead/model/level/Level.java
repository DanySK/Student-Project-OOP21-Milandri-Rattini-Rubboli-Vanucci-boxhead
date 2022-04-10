package boxhead.model.level;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;

import boxhead.model.entities.Wall;

/**
 * Interface that models a level made up by blocks.
 */
public interface Level {
	/**
	 * Method the retrieve all the block of the level.
	 *
	 * @return A map with the position of the block associated with the type
	 *         represented by an integer.
	 */
	Map<Point2D, Integer> getBlocks();

	/**
	 * Method to retrieve all the walls of the level.
	 *
	 * @return A list the all the walls.
	 */
	List<Wall> getWalls();

	/**
	 * Method to get all the zombie spawn points of the level.
	 *
	 * @return A list with all the zombieSpawnPoints.
	 */
	List<Point2D> getZombieSpawnPoints();

	/**
	 * @return The width of the level.
	 */
	double getWidth();

	/**
	 * @return The height of the level.
	 */
	double getHeight();

	/**
	 * @return The size of a single tile.
	 */
	double getTileSize();

	void setScale(double scale);
}
