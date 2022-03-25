package boxhead.model.level;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import boxhead.model.entities.Wall;
import boxhead.view.world.tile.Tile.TileType;
import javafx.geometry.Point2D;

/**
 * Implementation of {@link Level}
 */
public class LevelImpl implements Level {

	private final Map<Point2D, TileType> blocks;
	private final List<Wall> walls;
	private final List<Point2D> zombieSpawns;
	private final double width;
	private final double height;
	private final double tileSize;
	private double scale = 1.0;
	
	/**
	 * Constructor of the level.
	 * @param blocks
	 * @param width
	 * @param height
	 * @param tileSize
	 */
	public LevelImpl(final Map<Point2D, TileType> blocks, final double width, final double height, final double tileSize) {
		this.blocks = blocks;
		this.walls = new LinkedList<>();
		this.zombieSpawns = new LinkedList<>();
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		this.loadObjects();
	}
	/**
	 * Internal method to load all the objects.
	 */
	private void loadObjects() {
		blocks.forEach((point, type) -> {
			switch(type) {
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
	public Map<Point2D, TileType> getBlocks() {
		return this.blocks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Wall> getWalls() {
		return this.walls;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Point2D> getZombieSpawnPoints() {
		return this.zombieSpawns;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getWidth() {
		return this.width;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getHeight() {
		return this.height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getTileSize() {
		return this.tileSize;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setScale(double scale) {
		this.scale = scale;
	}

}
