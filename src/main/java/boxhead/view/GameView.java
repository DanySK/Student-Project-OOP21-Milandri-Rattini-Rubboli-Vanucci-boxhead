package boxhead.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameView implements Initializable {

	private AnchorPane gamePane;
	private Canvas gameMap;
	private Label ammos;
	private Label labelHP;

	/*
	 * private void initializeStage() { gamePane = new AnchorPane(); gameScene = new
	 * Scene(gamePane, GameViewManager.GAME_WIDTH, GameViewManager.GAME_HEIGHT);
	 * gameStage = new Stage(); gameStage.setScene(gameScene); }
	 *
	 * public void createNewGame(final Stage menuStage) { this.menuStage =
	 * menuStage; this.menuStage.hide(); gameStage.show(); }
	 */
	@Override
	public void initialize(final URL path, final ResourceBundle src) {
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		gamePane.setPrefWidth(screenSize.getWidth() / 2);
		gamePane.setPrefHeight(screenSize.getHeight() / 2);
		gameMap.setHeight(screenSize.getHeight() / 2);
		gameMap.setWidth(screenSize.getWidth() / 2);

	}

	public void resize(final double w, final double h) {
		gameMap.setWidth(w);
		gameMap.setHeight(h);
	}

	public double getWidth() {
		return gamePane.getWidth();
	}

	public double getHeight() {
		return gamePane.getHeight();
	}
}
