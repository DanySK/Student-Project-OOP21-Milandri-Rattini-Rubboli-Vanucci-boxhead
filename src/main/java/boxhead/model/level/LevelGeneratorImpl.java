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

public class LevelGeneratorImpl implements LevelGenerator {
	private static Map<Point2D, Integer> level = new HashMap<>();
	private int x;
	private int y;
	private Point2D pos = new Point2D(x, y);
	private final TileFactory tFactory;

	public LevelGeneratorImpl(final double ts) {
		tFactory = new TileFactoryImpl(ts);
	}

	private Map<Point2D, Integer> readLevel() {

		try {
			final InputStream is = getClass().getResourceAsStream("/boxhead.level.txt/prova.txt");
			final BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int y = 0;
			int x = 0;

			while ((y < 28) && (x < 14)) {

				final String line = br.readLine();

				while (y < 29) {

					final String numbers[] = line.split(" ");

					final int num = Integer.parseInt(numbers[y]);

					LevelGeneratorImpl.level.put(pos = new Point2D(x, y), num);
					y++;
				}
				if (y == 28) {
					y = 0;
					x++;

				}
			}
			br.close();

		} catch (final Exception e) {
		}
		return LevelGeneratorImpl.level;

	}

	private static Level generateLevel(final Map<Point2D, Integer> l, final double w, final double h, final double ts) {
		return new LevelImpl(l, w, h, ts);

	}

	private static LevelView generateLevelView(final Map<Point2D, Integer> level, final TileFactory tf, final double ts,
			final double w, final double h) {
		return new LevelViewImpl(level, tf, ts, w, h);

	}

	@Override
	public Pair<Level, LevelView> loadLevel(final double w, final double h, final double ts) {
		final Map<Point2D, Integer> level = readLevel();
		return new Pair<>(LevelGeneratorImpl.generateLevel(level, w, h, ts),
				LevelGeneratorImpl.generateLevelView(level, tFactory, ts, w, h));
	}

}
