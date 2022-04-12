package boxhead.model.level;

import javafx.geometry.Point2D;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import boxhead.model.entities.Wall;
import boxhead.view.world.tile.TileType;

/**
 * Implementation of {@link Level}
 */
public class LevelImpl implements Level {

	private final Map<Point2D, Integer> blocks;
	private final List<Wall> walls;
	private final Set<Point2D> zombieSpawns;
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
		zombieSpawns = new HashSet<>();
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
			switch (TileType.getFromId(id)) {
			case WALL:
				this.walls.add(new Wall(point, tileSize * scale, tileSize * scale));
				break;
			case ZOMBIE_SPAWN:
				this.zombieSpawns.add(point);
				break;
			case AMMO_SPAWN:
				break;
			case GROUND:
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
	public Set<Point2D> getZombieSpawnPoints() {
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
