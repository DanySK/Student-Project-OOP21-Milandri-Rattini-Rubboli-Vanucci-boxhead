package boxhead.model.entities.gun;

import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import boxhead.model.entities.utils.Direction;
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
	public Set<Optional<Shot>> attack(final Point2D pos, final Direction direction) {
		final Set<Optional<Shot>> attacks = new HashSet<>();
		if (System.currentTimeMillis() - this.lastShot <= rateOfFire || this.ammoInMagazine <= 0) {
			attacks.add(Optional.empty());
			return attacks;
		}
		this.ammoInMagazine--;
		this.lastShot = System.currentTimeMillis();
		switch(this.gunType) {
		case PISTOL:
		case UZI:
			attacks.add(Optional.of(new Bullet(pos, direction, damage)));
			return attacks;
		case SHOTGUN:
			Point2D offset = null;
			if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH))
				offset = Direction.EAST.traduce();
			if (direction.equals(Direction.EAST) || direction.equals(Direction.WEST))
				offset = Direction.NORTH.traduce();
			if (direction.equals(Direction.NORTH_EAST) || direction.equals(Direction.SOUTH_WEST))
				offset = Direction.NORTH_WEST.traduce();
			if (direction.equals(Direction.NORTH_WEST) || direction.equals(Direction.SOUTH_EAST))
				offset = Direction.NORTH_EAST.traduce();
			final Point2D bullet2 = new Point2D(direction.traduce().getX()*10 + offset.getX(),
												direction.traduce().getY()*10 + offset.getY());
			final Point2D bullet3 = new Point2D(direction.traduce().getX()*10 - offset.getX(),
												direction.traduce().getY()*10 - offset.getY());
			attacks.add(Optional.of(new Bullet(pos, direction, damage)));
			attacks.add(Optional.of(new Bullet(pos, bullet2, damage)));
			attacks.add(Optional.of(new Bullet(pos, bullet3, damage)));
			return attacks;
		}
		return attacks;
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
	 * {@inheritDoc}
	 */
	public void updateDamage(final int newDamage) {
		this.damage = newDamage;
		this.rechargeAmmo();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void updateRateOfFire(final long newRate) {
		this.rateOfFire = newRate;
		this.rechargeAmmo();
	}
	
	/**
	 * {@inheritDoc}
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
