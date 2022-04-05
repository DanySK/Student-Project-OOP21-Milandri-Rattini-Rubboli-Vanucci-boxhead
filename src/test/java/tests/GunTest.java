package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import boxhead.model.entities.Player;
import boxhead.model.entities.gun.ShotManager;
import boxhead.model.entities.gun.ShotManagerImpl;
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
		
	}
}
