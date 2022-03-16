package boxhead.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameViewManager {

	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;

	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 800;

	private Stage menuStage;

	public GameViewManager() {
		initializeStage();

	}

	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GameViewManager.GAME_WIDTH, GameViewManager.GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
	}

	public void createNewGame(final Stage menuStage) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		gameStage.show();
	}
}
