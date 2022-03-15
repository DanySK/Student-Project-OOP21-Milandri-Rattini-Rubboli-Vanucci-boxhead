package boxhead.model.entities;

import boxhead.model.entities.utils.Direction;
import javafx.geometry.Point2D;
import javafx.geometry.BoundingBox;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import boxhead.model.entities.*;
import boxhead.model.entities.utils.*;
import boxhead.model.entities.gun.*;
public class Player extends AbstractHealthEntity {
	
	private static final int MAX_HEALTH=100;
	
	private final Set<Gun> guns;
	private  Set<BoundingBox>obstacles;
	private final List<Boolean> iscolliding;
	private Gun currentGun;
	
	public Player(Point2D speed, Direction direction, Point2D position, EntityType entityType, double health) {
		super(Point2D.ZERO, Direction.WEST, Point2D.ZERO, EntityType.PLAYER, MAX_HEALTH);
		/**
		*FIXME controlla con Emi dopo implementazione di GunFactory
		*this.guns.add(new GunFactory().getGun);
		*/
		this.iscolliding=new ArrayList<>();
	}
	
	public final Gun getCurrentGun() {
		return this.currentGun;
	}
	
	public final void setCurrentGun(Gun gun) {
		this.currentGun=gun;
	}
	
	public void checkCollision(final Point2D nextPosition) {
        final BoundingBox playerBB = new BoundingBox(getPosition().getX() + nextPosition.getX(),
                getPosition().getY() + nextPosition.getY(), getWidth(), getHeight());

        this.obstacles.forEach(BB -> {
            if (Collision.isColliding(playerBB, BB)) {
                this.iscolliding.add(true);
            }
        });

        if (!this.iscolliding.isEmpty()) {
            setSpeed(Point2D.ZERO);
        } else {
            setSpeed(nextPosition);
        }
        this.iscolliding.clear();
	}	
	
	/**
	 * TODO gun update and update (EMI)
	 */
	
	public void unlockGun(Gun gun) {
		this.guns.add(gun);
	}
}	