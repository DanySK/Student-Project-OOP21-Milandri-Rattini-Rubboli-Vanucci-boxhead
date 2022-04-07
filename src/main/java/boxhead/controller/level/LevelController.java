package boxhead.controller.level;

import boxhead.model.level.Level;
import boxhead.model.level.LevelGenerator;
import boxhead.model.level.LevelGeneratorImpl;
import boxhead.view.level.LevelView;

/**
 * Controller for Level and and LevelView
 *
 * @author USER
 *
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

}
