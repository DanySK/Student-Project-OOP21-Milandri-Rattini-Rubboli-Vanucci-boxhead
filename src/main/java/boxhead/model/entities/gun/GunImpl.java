package boxhead.model.gun;

import java.util.Optional;

import boxhead.model.entities.EntityType;
import javafx.geometry.Point2D;

public class GunImpl extends AbstractGun {
	
	private final GunType gunType;
	private final int damage;
	private final long rateOfFire;
	private final int magazineSize;
	private final String name;
	
	private long lastShot;
	private int ammoInMagazine;
	
	public GunImpl(final Point2D position,final GunType gunType, final String name, final Integer damage, final Long rateOfFire, final Integer magazineSize) {
		super(position);

		this.gunType = gunType;
        this.name = name;
        this.damage = damage;
        this.rateOfFire = rateOfFire;
        this.magazineSize = magazineSize;

        this.ammoInMagazine = magazineSize;
        this.lastShot = 0;
    }
	

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Optional<Shot> attack(Point2D towards) {
		return null;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public GunType getGunType() {
		return gunType;
	}
}
