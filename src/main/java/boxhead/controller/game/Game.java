package boxhead.controller.game;

import boxhead.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
	/**
	 * set the beginning of the game
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			final ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.show();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Entry point
	 *
	 * @param args
	 */
	public static void main(final String[] args) {
		Application.launch(args);
	}
}