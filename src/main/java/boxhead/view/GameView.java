package boxhead.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Pair;

public class GameView implements Initializable {
	
	// View elements
	@FXML
	private AnchorPane gamePane;
	@FXML
	private Canvas gameMap;
	@FXML
	private Label magazineAmmo;
	@FXML
	private Label healthPoints;
	@FXML
	private Label gameRound;
	@FXML
	private Label killStreak;
	@FXML
	private Label gunName;
	@FXML
	private Label gunUpgrade;

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
		gamePane.setPrefWidth(screenSize.getWidth());
		gamePane.setPrefHeight(screenSize.getHeight());
		gameMap.setHeight(screenSize.getHeight());
		gameMap.setWidth(screenSize.getWidth());

	}
	
	/*
	 * Resizes the pane
	 */
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
	
	/*
	 * Does a pane reset
	 */
	public final void clear() {
	        this.gameMap.getGraphicsContext2D().clearRect(0, 0, this.gameMap.getWidth(), this.gameMap.getHeight());
	    }
	
	/*
	 * Check if the given point is between two another points
	 */
    private boolean isBetween(final Point2D p, final Point2D s, final Point2D e) {
        final double cooX = p.getX();
        final double cooY = p.getY();
        return cooX >= s.getX() && cooX <= e.getX() && s.getY() <= cooY && cooY <= e.getY();
    }
    
    /*
     * Render method
     */
    public final void render(final Image img, final Point2D pos) {
        this.gameMap.getGraphicsContext2D().drawImage(img, pos.getX(), pos.getY());
    }
    
    /*
     * Renders the ammo label setting a magazine text      
     */
    public final void renderAmmoLabel(final String magazineAmmo) {
    	this.magazineAmmo.setTextFill(Color.BLACK);
    	this.magazineAmmo.setText("Ammo: "+magazineAmmo);
    }

    /*
     * Renders the HP label setting the health text
     */
    public final void renderHPLabel(final String hp) {
    	this.healthPoints.setTextFill(Color.GREEN);
    	this.healthPoints.setText("HP: " + hp);
    }
    
    /*
     * Renders the kill streak of the player
     */
    public final void renderKillStreak(final String killStreak) {
    	this.killStreak.setTextFill(Color.CHOCOLATE);
    	this.killStreak.setText("Streak: " +killStreak);
    }
    
    /*
     * Renders the gun upgrade text with the upgrade the player just got
     */
    public final void renderGunUpgrade(final String gunUpgradeText) {
		this.gunUpgrade.setTextFill(Color.FUCHSIA);
        this.gunUpgrade.setText(gunUpgradeText);
    }
    
    /*
     * Renders the gun unlock text with the upgrade the player just got
     */
    public final void renderGunUnlock(final String gunUnlockText) {
		this.gunUpgrade.setTextFill(Color.GREEN);
        this.gunUpgrade.setText(gunUnlockText);
    }
    
    /*
     * Renders the given object after steps calculation
     */
    public final void completeRender(final Set<Pair<Point2D, Image>> objToRender, final Point2D start, final Point2D end,
            final Point2D offset, final double tileSize) {
        final Point2D step = new Point2D(tileSize, tileSize);
        final Point2D startStep = start.subtract(step);
        final Point2D endStep = end.add(step);

        objToRender.forEach(s -> {
            final Point2D point = s.getKey();
            if (isBetween(point, startStep, endStep)) {
                render(s.getValue(), s.getKey().subtract(offset));
            }
        });
    }
    
    /** 
     * @return gaameRound label
     */
    public final Label getRoundLabel() {
        return this.gameRound;
    }
    
    /** 
     * @return healthPoints label
     */
    public final Label getHPLabel() {
        return this.healthPoints;
    }
    
    /** 
     * @return gunName label
     */
    public final Label getGunName() {
        return this.gunName;
        }
    
    /** 
     * @return gunUpgrade label
     */
    public final Label getGunUpgrade() {
    	return this.gunUpgrade;
    }
    
    /** 
     * Does a render draw call
     */
    public final GraphicsContext getRenderer() {
        return this.gameMap.getGraphicsContext2D();
    }
}
