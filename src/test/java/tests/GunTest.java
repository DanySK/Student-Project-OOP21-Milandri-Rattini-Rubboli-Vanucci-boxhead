package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import boxhead.model.entities.Player;
import boxhead.model.entities.gun.Bullet;
import boxhead.model.entities.gun.Shot;
import boxhead.model.entities.gun.ShotManager;
import boxhead.model.entities.gun.ShotManagerImpl;
import boxhead.model.entities.utils.Direction;
import boxhead.model.entities.zombies.ZombieModel;
import boxhead.model.entities.zombies.ZombieModelImpl;
import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

/**
 * Test for Gun and their use.
 */
public class GunTest {
	
	private static final int PISTOL_MAGAZINE_SIZE = 10;
	private static final int UZI_MAGAZINE_SIZE = 39;
	private static final int SHOTGUN_MAGAZINE_SIZE = 8;
	
	private final Player player;
	private final ShotManager manager;
	private final ZombieModel zombieModel;
	private final Set<Point2D> spawns;
	private final Point2D position;
	
	public GunTest() {
		final Set<BoundingBox> obstacles = new HashSet<>();
        final Point2D zombiePos = new Point2D(40, 60);
        this.position = new Point2D(1, 1);
        this.spawns = new HashSet<>();
        this.spawns.add(zombiePos);
        this.player = new Player();
        this.zombieModel = new ZombieModelImpl();
        this.manager = new ShotManagerImpl(zombieModel);
        this.manager.setWalls(obstacles);
        this.zombieModel.setObstacles(obstacles);
        this.zombieModel.setPlayer(this.player);
        this.zombieModel.setSpawnPoints(spawns);
	}
	
	@Test
	public void testShotManager() {
		Shot bullet;
        int active = 0;
        int ended = 0;
        assertTrue(Integer.valueOf(this.manager.getShotsActive().size()).equals(active));
        assertTrue(Integer.valueOf(this.manager.getShotsEnded().size()).equals(ended));

        bullet = new Bullet(new Point2D(0,0), Direction.EAST, 100);
        this.manager.addShot(bullet);
        active++;
        assertTrue(Integer.valueOf(this.manager.getShotsActive().size()).equals(active));
        assertFalse(bullet.hasEnded());
        
        bullet = new Bullet(new Point2D(0,0), new Point2D(0,100), 100);
        this.manager.addShot(bullet);
        active++;
        assertTrue(Integer.valueOf(this.manager.getShotsActive().size()).equals(active));
        assertFalse(bullet.hasEnded());
	}
}
