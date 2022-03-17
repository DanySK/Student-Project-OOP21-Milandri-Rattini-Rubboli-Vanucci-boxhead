package boxhead.model.entities;

import boxhead.model.entities.utils.Direction;
import javafx.geometry.Point2D;
import javafx.geometry.BoundingBox;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import boxhead.model.entities.*;
import boxhead.model.entities.utils.*;
import boxhead.model.entities.gun.*;
import boxhead.model.entities.gun.Gun.GunType;
public class Player extends AbstractHealthEntity {
	
	private static final int MAX_HEALTH=100;
	
	private LinkedList<Gun> guns;
	private Set<BoundingBox>obstacles;
	private final List<Boolean> iscolliding;
	private Gun currentGun;
	private int gunIndex;
	
	public Player(Point2D speed, Direction direction, Point2D position, EntityType entityType, double health) {
		super(Point2D.ZERO, Direction.WEST, Point2D.ZERO, EntityType.PLAYER, MAX_HEALTH);
		this.guns = new LinkedList<>();
		this.currentGun=new GunFactory().getGun(position,GunType.PISTOL);
		this.guns.add(this.currentGun);
		this.iscolliding=new ArrayList<>();
		this.gunIndex=0;
	}
	
	 /**
     * Return current gun
     * @return Gun currentGun 
     */
	public final Gun getCurrentGun() {
		return this.currentGun;
	}
	
	/**
     * Set current gun
     * @param Gun gun 
     */
	public final void setCurrentGun(Gun gun) {
		this.currentGun=gun;
	}
	
	/**
     * Check collision in the next position
     * @param Point2D nextPosition
     */
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
     * Unlock a new gun
     * @param Gun gun that has been unlocked
     */
	public void unlockGun(Gun gun) {
		this.guns.add(gun);
	}

	/**
     * Set currentGun to the next gun in the inventory
     */
	public void nextGun() {
		if(this.gunIndex+1<this.guns.size()) {
			this.currentGun=this.guns.get(gunIndex++);
		} else {
			this.gunIndex=0;
			this.currentGun=this.guns.get(gunIndex);
		}
	}
	
	/**
     * Set currentGun to the previous gun in the inventory
     */
	public void previousGun() {
		if(this.gunIndex>0) {
			this.currentGun=this.guns.get(gunIndex--);
		} else {
			this.gunIndex=this.guns.size();
			this.currentGun=this.guns.get(gunIndex);
		}
	}
}