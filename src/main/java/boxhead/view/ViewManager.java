package boxhead.view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewManager {

	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private final AnchorPane mainPane;
	private final Scene mainScene;
	private final Stage mainStage;

	private final static int MENU_BUTTONS_START_X = 100;
	private final static int MENU_bUTTON_START_Y = 150;

	List<BoxheadButton> menuButtons;

	/**
	 * Construct a viewManager
	 */

	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, ViewManager.WIDTH, ViewManager.HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButton();
	}

	/**
	 *
	 * @return the stage
	 */
	public Stage getMainStage() {
		return mainStage;
	}

	private void addMenuButton(final BoxheadButton button) {
		button.setLayoutX(ViewManager.MENU_BUTTONS_START_X);
		button.setLayoutY(ViewManager.MENU_bUTTON_START_Y + (menuButtons.size() * 100));
		menuButtons.add(button);
		mainPane.getChildren().add(button);

	}

	private void createButton() {
		createStartButton();
		createScoreButton();
		createExitButton();

	}

	private void createStartButton() {
		final BoxheadButton startButton = new BoxheadButton("START!");
		addMenuButton(startButton);

		startButton.setOnAction(event -> {
			final GameViewManager gameManager = new GameViewManager();
			gameManager.createNewGame(mainStage);

		});
	}

	private void createScoreButton() {
		final BoxheadButton scoreButton = new BoxheadButton("SCORE");
		addMenuButton(scoreButton);
	}

	private void createExitButton() {
		final BoxheadButton exitButton = new BoxheadButton("EXIT");
		addMenuButton(exitButton);

		exitButton.setOnAction(arg0 -> mainStage.close());
	}

}
