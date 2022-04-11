package boxhead.controller.level;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.Set;

import org.apache.commons.math3.util.Pair;

import boxhead.model.level.Level;
import boxhead.model.level.LevelGenerator;
import boxhead.model.level.LevelGeneratorImpl;
import boxhead.view.level.LevelView;

/**
 * Controller for Level and and LevelView
 */
public class LevelController {

	private static final int TILE_SIZE = 128;

	private Level l;
	private LevelView lv;

	private final LevelGenerator lGenerator;

	/**
	 *
	 * @param w
	 * @param h
	 * @param ts
	 * @param renderScale
	 */
	public LevelController(final double w, final double h, final double ts, final int renderScale) {
		lGenerator = new LevelGeneratorImpl(LevelController.TILE_SIZE);
		l.setScale(renderScale);
		lv.setScale(renderScale);
	}

	public final Level getLevel() {
		return l;
	}

	public final void generateMap(final double w, final double h, final int ts) {
		lGenerator.readLevel();
	}

	/**
	 * @return Level Map.
	 */
	public final Level getMap() {
		return l;
	}

	/**
	 * @return Set<Pair<Point2D, Image>> Map elements coordinates
	 */
	public final Set<Pair<Point2D, Image>> render() {
		return lv.renderLevelMap();
	}

	/**
	 *
	 * @return {@link LevelView}
	 */
	public final LevelView getLevelView() {
		return lv;
	}

	/**
	 *
	 * @param scale
	 */
	public final void resize(final double scale) {
		lv.setScale(scale);
	}

	/**
	 *
	 * @param w  level's width
	 * @param h  level's height
	 * @param ts Tiles size
	 *
	 *           public final void generateLevel(final double w, final double h,
	 *           final double ts) { final Pair<Level, LevelView> result =
	 *           lGenerator.loadLevel(w, h, ts); l = result.getKey(); lv =
	 *           result.getValue(); }
	 */

}
