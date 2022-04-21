package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import boxhead.model.entities.Player;
import boxhead.model.entities.gun.Bullet;
import boxhead.model.entities.gun.Gun;
import boxhead.model.entities.gun.Gun.GunType;
import boxhead.model.entities.gun.GunFactory;
import boxhead.model.entities.gun.Shot;
import boxhead.model.entities.gun.ShotManager;
import boxhead.model.entities.gun.ShotManagerImpl;
import boxhead.model.entities.utils.Direction;
import boxhead.model.entities.zombies.Zombie;
import boxhead.model.entities.zombies.ZombieModel;
import boxhead.model.entities.zombies.ZombieModelImpl;
import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

/**
 * Test for Gun and their use.
 */
public class GunTest {
	
	private static final int PISTOL_DAMAGE = 30;
	private static final int UZI_DAMAGE = 25;
	private static final int SHOTGUN_DAMAGE = 50;
	
	private final Player player;
	private final ShotManager manager;
	private final ZombieModel zombieModel;
	private final Set<Point2D> spawns;
	private final Point2D position;
	
	public GunTest() {
		final Set<BoundingBox> obstacles = new HashSet<>();
        final Point2D zombiePos = new Point2D(0, 6);
        this.position = new Point2D(1, 1);
        this.spawns = new HashSet<>();
        this.spawns.add(zombiePos);
        this.player = new Player();
        this.zombieModel = new ZombieModelImpl();
        this.manager = new ShotManagerImpl(zombieModel);
        this.manager.setWalls(obstacles);
        this.zombieModel.setWalls(obstacles);
        this.zombieModel.setPlayer(this.player);
        this.zombieModel.setSpawnPoints(spawns);
	}
	
	@Test
	public void testShotManager() {
		Shot bullet1;
		Shot bullet2;
        int active = 0;
        assertTrue(Integer.valueOf(this.manager.getShotsActive().size()).equals(active));

        bullet1 = new Bullet(new Point2D(0,0), new Point2D(100, 0), 100);
        this.manager.addShot(bullet1);
        active++;
        assertTrue(Integer.valueOf(this.manager.getShotsActive().size()).equals(active));
        assertFalse(bullet1.hasEnded());
        
        bullet2 = new Bullet(new Point2D(0,0), new Point2D(0,66), 100);
        this.manager.addShot(bullet2);
        active++;
        assertTrue(Integer.valueOf(this.manager.getShotsActive().size()).equals(active));
        assertFalse(bullet2.hasEnded());
        
        final Set<BoundingBox> walls = new HashSet<>();
        walls.add(new BoundingBox(60, 0, 1, 1));
        walls.add(new BoundingBox(0, 66, 1, 1));
        this.manager.setWalls(walls);
        for (int i = 0; i < 12; i++) {
        	this.manager.update();
        }
        final Set<Shot> ended = this.manager.getShotsEnded();
        assertTrue(ended.contains(bullet1) && ended.contains(bullet2)); 
	}
	
	@Test
	public void testGunImpl() {
		final Gun uzi = new GunFactory().getGun(this.position, GunType.UZI);
		final Gun shotgun = new GunFactory().getGun(this.position, GunType.SHOTGUN);
		this.player.setPosition(this.position);
		this.zombieModel.setZombiesToSpawn(1);
		this.zombieModel.update();
		assertTrue(Integer.valueOf(zombieModel.getZombies().size()).equals(1));
		
		//PISTOL
		final Zombie z = this.zombieModel.getZombies().stream().findFirst().get();
		int zombieHP = z.getHealth();
		this.player.getCurrentGun().attack(position, Direction.SOUTH).forEach(s -> {
			this.manager.addShot(s.get());
		});
		this.manager.update();
		assertTrue(z.getHealth() == (zombieHP - PISTOL_DAMAGE));
		
		//UZI
		this.player.unlockGun(uzi);
		this.player.nextGun();
		assertTrue(this.player.getCurrentGun().equals(uzi));
		this.player.getCurrentGun().attack(position, Direction.SOUTH).forEach(s -> {
			this.manager.addShot(s.get());
		});
		this.manager.update();
		assertTrue(z.getHealth() == (zombieHP - PISTOL_DAMAGE - UZI_DAMAGE));
		
		//SHOTGUN
		this.player.unlockGun(shotgun);
		this.player.nextGun();
		assertTrue(this.player.getCurrentGun().equals(shotgun));
		this.player.getCurrentGun().attack(position, Direction.SOUTH).forEach(s -> {
			this.manager.addShot(s.get());
		});
		z.setHealth(200);
		zombieHP = z.getHealth();
		//The zombie gets hit by two out of the three bullets generated.
		this.manager.update();
		assertTrue(z.getHealth() == (zombieHP - 2*SHOTGUN_DAMAGE));
	}
}
