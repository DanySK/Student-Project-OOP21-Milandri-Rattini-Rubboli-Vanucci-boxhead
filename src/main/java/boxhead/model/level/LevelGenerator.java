package boxhead.model.level;

import boxhead.view.level.LevelView;

import javafx.util.Pair;

public interface LevelGenerator {

	/**
	 * @return
	 *
	 *
	 */
	public Pair<Level, LevelView> loadLevel(final double w, final double h, final double ts);

}
