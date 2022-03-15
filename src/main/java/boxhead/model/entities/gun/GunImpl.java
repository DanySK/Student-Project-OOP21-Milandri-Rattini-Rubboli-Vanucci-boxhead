package boxhead.model.entities.gun;

import java.time.Duration;
import java.util.Optional;

import javafx.geometry.Point2D;

/**
 * Implementation of {@link Gun}.
 */
public class GunImpl extends AbstractGun {
	
	private final GunType gunType;
	private int damage;
	private long rateOfFire;
	private int magazineSize;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Shot> attack() {
		if (System.currentTimeMillis() - this.lastShot <= rateOfFire || this.ammoInMagazine <= 0) {
			return Optional.empty();
		}
		this.ammoInMagazine--;
		this.lastShot = System.currentTimeMillis();
		switch(gunType) {
		case PISTOL:
			//TODO
		case UZI:
			return Optional.empty();
		case SHOTGUN:
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getDamage() {
		return this.damage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GunType getGunType() {
		return this.gunType;
	}
	
	/**
	 * Used to get the remaining ammos.
	 * @return
	 * 			The amount of ammos left.
	 */
	public int getCurrentAmmo() {
		return this.ammoInMagazine;
	}
	
	/**
	 * Used to recharge the gun.
	 */
	public void rechargeAmmo() {
		this.ammoInMagazine = this.magazineSize;
	}
	
	/**
	 * Used to upgrade the gun's damage.
	 * @param newDamage
	 */
	public void updateDamage(final int newDamage) {
		this.damage = newDamage;
		this.rechargeAmmo();
	}
	
	/**
	 * Used to upgrade the gun's rate of fire.
	 * @param newRate
	 */
	public void updateRateOfFire(final long newRate) {
		this.rateOfFire = newRate;
		this.rechargeAmmo();
	}
	
	/**
	 * Used to upgrade the magazine size.
	 * @param newSize
	 */
	public void updateMagazine(final int newSize) {
		this.magazineSize = newSize;
		this.rechargeAmmo();
	}
	
	/**
	 * A builder to create the specific gun.
	 */
	public static class Builder {

		private static final int DEFAULT_DAMAGE = 30;
        private static final long DEFAULT_RATE_OF_FIRE = 100;
        private static final int DEFAULT_MAGAZINE_SIZE = 15;
        
        private final String name;
        private final Point2D position;
        private final GunType gunType;
        private Optional<Integer> damage;
        private Optional<Long> rateOfFire;
        private Optional<Integer> magazineSize;
        
        /**
         * Creates a simple gun with default values.
         * @param position
         * 			Starting position of the gun.
         * @param type
         * 			Gun's type.
         * @param name
         * 			The gun's name.
         */
        public Builder(final Point2D position,final GunType type, final String name) {
            this.position = position;
            this.gunType = type;
            this.name = name;
            this.damage = Optional.empty();
            this.rateOfFire = Optional.empty();
            this.magazineSize = Optional.empty();
        }
        
        /**
         * Used to set the damage of the gun.
         * @param damage
         * 		The damage of the gun.
         * @return
         * 		A Builder with gun's damage set.
         */
        public final Builder damage(final int damage) {
            this.damage = Optional.of(damage);
            return this;
        }
        
        /**
         * Used to set the rate of fire of the gun.
         * @param duration
         * 		The rafe of fire of the gun.
         * @return
         * 		A Builder with gun's rate of fire set.
         */
        public final Builder rateOfFire(final Duration duration) {
            this.rateOfFire = Optional.of(duration.toMillis());
            return this;
        }
        
        /**
         * Used to set the magazine size of the gun.
         * @param magazineSize
         * 		The magazine size of the gun.
         * @return
         * 		A Builder with gun's magazine size set.
         */
        public final Builder magazineSize(final int magazineSize) {
            this.magazineSize = Optional.of(magazineSize);
            return this;
        }
        
        /**
         * @return
         * 		A {@link GunImpl} with the specific settings.
         */
        public final Gun build() {
            return new GunImpl(this.position, this.gunType, this.name,
            		this.damage.orElse(DEFAULT_DAMAGE),
            		this.rateOfFire.orElse(DEFAULT_RATE_OF_FIRE),
                    this.magazineSize.orElse(DEFAULT_MAGAZINE_SIZE));
        }

	}
}
