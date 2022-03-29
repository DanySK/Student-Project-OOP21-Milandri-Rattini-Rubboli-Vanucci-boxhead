package boxhead.controller.entities;

import boxhead.model.entities.Player;
import boxhead.view.entities.PlayerView;

/**
 * Interface to model the {@link Player} Controller.
 */
public interface PlayerController {

	Player getPlayer();
	
	PlayerView getPlayerView();
	
	void update();
}
