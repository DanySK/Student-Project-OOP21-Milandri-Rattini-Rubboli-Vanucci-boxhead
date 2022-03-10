package boxhead.game;

import boxhead.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			final ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.show();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(final String[] args) {
		Application.launch(args);
	}
}