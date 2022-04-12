package boxhead.controller.level;

import boxhead.controller.game.GameLevelImpl;
import boxhead.model.level.Round;
import boxhead.model.level.RoundImpl;
import boxhead.view.GameView;
import boxhead.view.RoundView;

public class RoundController{

	private final Round round;
	private final RoundView roundView;
	private boolean isRoundVital;
	private boolean isRoundInactive;
	private GameView gameView;
	
	public RoundController(final GameLevelImpl gameLevel) {
        this.round = new RoundImpl(gameLevel.getZombieController().getZombieModel());
        this.roundView = new RoundView(gameLevel.getGameView().getRoundLabel());
        this.isRoundVital = false;
        this.isRoundInactive = true;
    }
	
	/*
	 * Updates rounds based on its boolean values
	 */
	public void update() {
		this.round.update();
		
		//this.roundView.setRound(this.round.getCurrentRound())
		
		if (this.round.isRoundActive() && !this.isRoundVital) {
            this.isRoundVital = true;
            this.roundView.setRound(this.round.getCurrentRound());
            this.isRoundInactive = false;
           
        } else if (!this.round.isRoundActive()) {
                this.isRoundVital = false;
                this.isRoundInactive = true;
	}
	}

}
