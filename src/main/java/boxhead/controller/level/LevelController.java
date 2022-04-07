package boxhead.controller.level;

import java.util.Set;

import boxhead.model.level.Level;
import boxhead.model.level.LevelGenerator;
import boxhead.model.level.LevelGeneratorImpl;
import boxhead.view.level.LevelView;
import javafx.geometry.BoundingBox;

/**
 * Controller for Level and and LevelView
 */
public class LevelController {

	private Level l;
	private LevelView lv;

	private final LevelGenerator lGenerator;

	public LevelController(final double w, final double h, final double ts, final double renderScale) {
		lGenerator = new LevelGeneratorImpl();
		l.setScale(renderScale);
		lv.SetScale(renderScale);
	}

	public final Level getLevel() {
		return this.l;
	}
}
