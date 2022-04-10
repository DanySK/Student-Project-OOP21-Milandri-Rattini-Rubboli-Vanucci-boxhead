package boxhead.model.level;

import org.apache.commons.math3.util.Pair;

import boxhead.view.level.LevelView;

public interface LevelGenerator {

	/**
	 * @return
	 *
	 *
	 */
	public Pair<Level, LevelView> loadLevel(final double w, final double h, final double ts);

}
