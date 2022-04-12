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
import boxhead.view.spriteutils.Sprite;
import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ZombieTest {
	
	ImageView image=new ImageView();
	Direction direction=Direction.NORTH_EAST;
	
	@Test
	public void updateZombieImage() {
	String filename=this.direction.toString().toLowerCase();
	this.image.setImage(new Image(Sprite.class.getResourceAsStream("/zombie/" + filename + ".png")));
	return;
	}
	
}
