package boxhead.model.level;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Point2D;

public class LevelGeneratorImpl implements LevelGenerator {
	static Map<Point2D, Integer> level = new HashMap<>();
	int x;
	int y;
	Point2D pos = new Point2D(x, y);

	@Override
	public void loadLevel() {

		try {
			final InputStream is = getClass().getResourceAsStream("/boxhead.level.txt/prova.txt");
			final BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int y = 0;
			int x = 0;

			while ((y < 20) && (x < 3)) {

				final String line = br.readLine();

				while (y < 20) {

					final String numbers[] = line.split(" ");

					final int num = Integer.parseInt(numbers[y]);

					LevelGeneratorImpl.level.put(pos = new Point2D(x, y), num);
					y++;
				}
				if (y == 20) {
					y = 0;
					x++;

				}
			}
			br.close();

		} catch (final Exception e) {
		}

	}

}
