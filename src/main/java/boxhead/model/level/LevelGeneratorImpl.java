package boxhead.model.level;

import javafx.geometry.Point2D;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import boxhead.view.level.LevelView;
import boxhead.view.level.LevelViewImpl;
import boxhead.view.world.tile.TileFactory;
import boxhead.view.world.tile.TileFactoryImpl;

/**
 * Implementation of {@link LevelGenerator}.
 */
public class LevelGeneratorImpl implements LevelGenerator {
	private static Map<Point2D, Integer> level = new HashMap<>();
	private final TileFactory tFactory;

	/**
	 * Contructor that takes only tileSize.
	 * @param ts
	 */
	public LevelGeneratorImpl(final double ts) {
		tFactory = new TileFactoryImpl(ts);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Pair<Level, LevelView> loadLevel(final double width, final double height, final double tileSize) {
		final Map<Point2D, Integer> level = readLevel();
		return new Pair<>(LevelGeneratorImpl.generateLevel(level, width, height, tileSize),
				LevelGeneratorImpl.generateLevelView(level, tFactory));
	}
	
	/**
	 * Method to read the level from a file.
	 * @return Map with Point2D and type of the tile(in integer).
	 */
	private final Map<Point2D, Integer> readLevel() {
		BufferedReader br = null;
		try {
			final InputStream is = getClass().getResourceAsStream("/prova.txt");
			br = new BufferedReader(new InputStreamReader(is));
			int y = 0;
			int x = 0;
			while ((x < 15) && (y < 29)) {
				final String line = br.readLine();
				while (y < 29) {
					final String numbers[] = line.split(" ");
					final int num = Integer.parseInt(numbers[y]);
					LevelGeneratorImpl.level.put(new Point2D(y, x), num);
					y++;
				}
				if (y == 29) {
					y = 0;
					x++;
				}
			}
			br.close();
		} catch (final Exception e) {
		}
		return LevelGeneratorImpl.level;
	}

	/**
	 * Method to intanties a new LevelImpl.
	 * @param level
	 * @param width
	 * @param height
	 * @param tileSize
	 * @return
	 */
	private static Level generateLevel(final Map<Point2D, Integer> level, final double width, final double height, final double tileSize) {
		return new LevelImpl(level, width, height, tileSize);

	}

	private static LevelView generateLevelView(final Map<Point2D, Integer> level, final TileFactory tf) {
		return new LevelViewImpl(level, tf);
	}
}
