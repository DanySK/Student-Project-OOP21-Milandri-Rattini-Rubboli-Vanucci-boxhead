package boxhead.controller.level;

import boxhead.model.entities.Player;
import boxhead.model.level.Camera;
import javafx.geometry.Point2D;

/**
 * The controller that will handle the cameras.
 */
public class CameraController {
    private final Camera camera;
    
    public CameraController (final double x, final double y, final double mapW, final double mapH, 
    		final double camW, final double camH) {
    	this.camera=new Camera(x,y,mapW,mapH,camW,camH);
    }
    /**
     * Center on player
     * @param player
     */
    public final void centerOnPlayer(final Player player) {
        this.camera.centerOnPlayer(player);
    }
    /**
     * Return the camera center
     * @return Point2D
     */
    public final Point2D getCenter() {
        return this.camera.getCenter();
    }
    /**
     * Return camera 
     * @return Camera
     */
    public final Camera getCamera() {
        return this.camera;
    }
}
