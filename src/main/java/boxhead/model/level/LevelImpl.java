package boxhead.model.level;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import boxhead.model.entities.Wall;

/**
 * Implementation of {@link Level}
 */
public class LevelImpl implements Level {

	private final Map<Point2D, Integer> blocks;
	private final List<Wall> walls;
	private final List<Point2D> zombieSpawns;
	private final double width;
	private final double height;
	private final double tileSize;
	private double scale = 1.0;

	/**
	 * Constructor of the level.
	 *
	 * @param blocks
	 * @param width
	 * @param height
	 * @param tileSize
	 */
	public LevelImpl(final Map<Point2D, Integer> blocks, final double width, final double height,
			final double tileSize) {
		this.blocks = blocks;
		walls = new LinkedList<>();
		zombieSpawns = new LinkedList<>();
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		loadObjects();
	}

	/**
	 * Internal method to load all the objects.
	 */
	private void loadObjects() {
		blocks.forEach((point, id) -> {
			switch (type) {
			case WALL:
				this.walls.add(new Wall(point, tileSize * scale, tileSize * scale));
				break;
			case ZOMBIE_SPAWN:
				this.zombieSpawns.add(point);
				break;
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Point2D, Integer> getBlocks() {
		return blocks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Wall> getWalls() {
		return walls;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Point2D> getZombieSpawnPoints() {
		return zombieSpawns;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getTileSize() {
		return tileSize;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setScale(final double scale) {
		this.scale = scale;
	}

}
