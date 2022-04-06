package boxhead.model.entities.gun;

import boxhead.controller.game.GameWorld;
import boxhead.model.entities.Player;
import boxhead.model.entities.gun.Gun.GunType;

/**
 * Class that is used to manage the upgrades of the weapons.
 */
public class GunUpgradeManager {
	
	private final GameWorld gameWorld;
	private final Player player;
	
	public GunUpgradeManager(final GameWorld world, final Player player) {
		this.gameWorld = world;
		this.player = player;
	}
	
	public final void checkUpgrades(final int streak) {
		switch(streak) {
		case 3:
			this.player.getSelectedGun(GunType.PISTOL).updateRateOfFire(newRate);
			this.gameWorld.getGameView().renderGunUpgrade("Pistol+: Faster Fire");
		break;
		case 5:
			this.player.getSelectedGun(GunType.PISTOL).updateDamage(newDamage);
			this.gameWorld.getGameView().renderGunUpgrade("Pistol+: More Damage");
		break;
		case 8:
			this.player.getSelectedGun(GunType.PISTOL).updateMagazine(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Pistol+: Double Ammo");
		break;
		case 10:
			this.player.unlockGun(new GunFactory().getGun(this.player.getPosition(), GunType.UZI));
			this.gameWorld.getGameView().renderGunUnlock("New Weapon: UZI");
		break;
		case 13:
			this.player.getSelectedGun(GunType.PISTOL).updateDamage(newDamage);
			this.gameWorld.getGameView().renderGunUpgrade("Pistol+: Even More Damage");
		break;
		case 17:
			this.player.getSelectedGun(GunType.UZI).updateMagazine(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("UZI+: Double Ammo");
		break;
		case 18:
			this.player.getSelectedGun(GunType.UZI).updateDamage(newDamage);
			this.gameWorld.getGameView().renderGunUpgrade("UZI+: More Damage");
		break;
		case 20:
			this.player.unlockGun(new GunFactory().getGun(this.player.getPosition(), GunType.SHOTGUN));
			this.gameWorld.getGameView().renderGunUnlock("New Weapon: Shotgun");
		break;
		case 21:
			this.player.getSelectedGun(GunType.PISTOL).updateRateOfFire(newRate);
			this.gameWorld.getGameView().renderGunUpgrade("UZI+: Faster Fire");
		break;
		case 23:
			this.player.getSelectedGun(GunType.UZI).updateMagazine(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Shotgun+: Double Ammo");
		break;
		case 26:
			this.player.getSelectedGun(GunType.UZI).updateRateOfFire(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Shotgun+: Faster Fire");
		break;
		case 30:
			this.player.getSelectedGun(GunType.UZI).updateMagazine(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Pistol+: Quad Ammo");
		break;
		case 32:
			this.player.getSelectedGun(GunType.UZI).updateDamage(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Shotgun+: More Damage");
		break;
		case 35:
			this.player.getSelectedGun(GunType.UZI).updateRateOfFire(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Pistol+: Even Faster Fire");
		break;
		case 36:
			this.player.getSelectedGun(GunType.UZI).updateMagazine(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Shotgun+: Quad Ammo");
		break;
		case 38:
			this.player.getSelectedGun(GunType.UZI).updateRateOfFire(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("UZI+: Even Faster Fire");
		break;
		case 40:
			this.player.getSelectedGun(GunType.UZI).updateMagazine(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("UZI+: Quad Ammo");
		break;
		case 43:
			this.player.getSelectedGun(GunType.UZI).updateDamage(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("Shotgun+: Even More Damage");
		break;
		case 45:
			this.player.getSelectedGun(GunType.UZI).updateDamage(newSize);
			this.gameWorld.getGameView().renderGunUpgrade("UZI+: Even More Damage");
		break;
		case 48:
			this.player.getSelectedGun(GunType.UZI).updateRateOfFire(newRate);
			this.gameWorld.getGameView().renderGunUpgrade("Shotgun+: Even Faster Fire");
		break;		
		}
	}
}
