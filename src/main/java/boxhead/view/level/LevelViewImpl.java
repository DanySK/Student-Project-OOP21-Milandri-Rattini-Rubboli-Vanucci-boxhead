 package boxhead.view.level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import boxhead.view.world.tile.Tile;
import boxhead.view.world.tile.TileFactory;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Pair;

public class LevelViewImpl implements LevelView {

	private final TileFactory tf;
	private final Set<Tile> tiles;
	//private static Map<Point2D, Integer> blocks = new HashMap<>();
	private Set<Pair<Point2D, Image>> levelRendered;
	//private Map<Point2D, Integer> levelTmp = new HashMap<>();
	private Set<Pair<Point2D, Image>> levelBackground;
	private static Point2D pos;
	private final double ts;
	private final double w;
	private final double h;
	private double scale;

	/**
	 * Constructor of the levelview
	 *
	 * @param level - Map<Point2D, Integer> to be transformed in relative tiles
	 * @param tf    - tileFactory to create tiles
	 * @param ts    - tile size
	 * @param w     - width of the level
	 * @param h     - height of the level
	 */
	public LevelViewImpl(final Map<Point2D, Integer> blocks, final TileFactory tf, final double ts, final double w,
			final double h) {
		this.tf = tf;
		tiles = tf.createTiles(blocks, ts);
		this.ts = ts;
		this.w = w;
		this.h = h;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final public Set<Tile> getLevelMap() {
		return tiles;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Set<Pair<Point2D, Image>> renderLevelMap() {
		Set<Pair<Point2D, Image>> result;
		if (levelRendered == null) {
			result = new HashSet<>();
			tiles.stream().forEach(t -> {
				result.add(new Pair<>(t.getRelativePos(), t.getTile()));
			});
			levelRendered = result;
		} else {
			result = levelRendered;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
//	@Override
//	public final Set<Pair<Point2D, Image>> renderLevelBackground() {
//		final Set<Pair<Point2D, Image>> result;
//		if (levelBackground == null) {
//			result = new HashSet<>();
//			for (int x = 0; x < w; x++) {
//				for (int y = 0; y < h; y++) {
//					LevelViewImpl.pos = new Point2D(x, y);
//					final Tile t = tf.createTile(this.blocks.get(LevelViewImpl.pos), LevelViewImpl.pos, ts);
//					result.add(new Pair<>(t.getPos(), t.getTile()));
//				}
//			}
//			levelBackground = result;
//		} else {
//			result = levelBackground;
//		}
//		return result;
//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setScale(final double scale) {
		this.scale = scale;
		tiles.forEach(t -> t.setRenderScale(scale));
		levelRendered = null;
		levelBackground = null;

	}
}