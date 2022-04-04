package boxhead.view.spriteutils;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import boxhead.model.entities.EntityType;
import boxhead.model.entities.gun.Gun.GunType;
import boxhead.model.entities.utils.Direction;

public class Sprite {
	
	/**
	 * FIXME find out best size of sprites
	 */
	private static final int ZOMBIE_HEIGHT = 10;
    private static final int ZOMBIE_WIDTH = 10;
    
    private static final int PLAYER_HEIGHT = 10;
    private static final int PLAYER_WIDTH = 10;
    
    private static final int BULLET_HEIGHT = 8;
    private static final int BULLET_WIDTH = 3;
    
    private static final int PASSIVE_HEIGHT = 20;
    private static final int PASSIVE_WIDTH = 20;
    
    private final EntityType type;
    private ImageView imageView;
    private final SnapshotParameters snapshot;
    
    public Sprite(final EntityType type) {
        this.type = type;
        this.setImageView();
        this.snapshot = new SnapshotParameters();
        this.snapshot.setFill(Color.TRANSPARENT);
    }

    /**
     * TODO Replace placeholder with PNG 
     */
	private void setImageView() {
		this.imageView=new ImageView();
		switch(this.type) {
		case ZOMBIE:
			this.imageView.setFitHeight(ZOMBIE_HEIGHT);
			this.imageView.setFitWidth(ZOMBIE_WIDTH);
			updateZombieImage(this.imageView,Direction.EAST);
		case PLAYER:
			this.imageView.setFitHeight(PLAYER_HEIGHT);
			this.imageView.setFitWidth(PLAYER_WIDTH);
			updatePlayerImage(this.imageView,Direction.EAST,GunType.PISTOL);
		case BULLET:
			this.imageView.setFitHeight(BULLET_HEIGHT);
			this.imageView.setFitWidth(BULLET_WIDTH);
			this.imageView.setImage(new Image(getClass().getResourceAsStream("bullet.png")));;
		case AMMO:
			this.imageView.setFitHeight(PASSIVE_HEIGHT);
			this.imageView.setFitWidth(PASSIVE_WIDTH);
			this.imageView.setImage(null);
		case WALL:
			this.imageView.setFitHeight(PASSIVE_HEIGHT);
			this.imageView.setFitWidth(PASSIVE_WIDTH);
			this.imageView.setImage(new Image(getClass().getResourceAsStream("wall.png")));
		default:
			this.imageView.setFitHeight(PASSIVE_HEIGHT);
			this.imageView.setFitWidth(PASSIVE_WIDTH);
			this.imageView.setImage(null);	
		}
	}
	/**
	 * Update player image
	 * @param image
	 * @param direction
	 * @param gun
	 */
	public void updatePlayerImage(final ImageView image, Direction direction, GunType gun) {
		String filename=gun.toString().toLowerCase() + "-" + direction.toString().toLowerCase();
		image.setImage(new Image(getClass().getResourceAsStream("/player/" + filename)));
	}
		

//        switch (direction) {
//        case NORTH:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//
//        case NORTH_EAST:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//        case EAST:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//        case SOUTH_EAST:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//        case SOUTH:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//        case SOUTH_WEST:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//        case WEST:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//        case NORTH_WEST:
//            switch (gun) {
//            case PISTOL:
//                image.setImage(PLACEHOLDER);
//                break;
//            case UZI:
//                image.setImage(PLACEHOLDER);
//                break;
//            case SHOTGUN:
//                image.setImage(PLACEHOLDER);
//                break;
//            }
//            break;
//        }
 
	/**
	 * Update zombie image
	 * @param image
	 * @param direction
	 */
	public void updateZombieImage(final ImageView image, Direction direction) {
		String filename=direction.toString();
		image.setImage(new Image(getClass().getResourceAsStream("/zombie/" + filename)));
//        switch (direction) {
//        case NORTH:
//        	image.setImage(PLACEHOLDER);
//        	break;
//        case NORTH_EAST:
//        	image.setImage(PLACEHOLDER);
//            break;
//        case EAST:
//        	image.setImage(PLACEHOLDER);
//        	break;
//        case SOUTH_EAST:
//        	image.setImage(PLACEHOLDER);
//        	break;
//        case SOUTH:
//        	image.setImage(PLACEHOLDER);
//            break;
//        case SOUTH_WEST:
//        	image.setImage(PLACEHOLDER);
//            break;
//        case WEST:
//        	image.setImage(PLACEHOLDER);
//            break;
//        case NORTH_WEST:
//        	image.setImage(PLACEHOLDER);
//            break;
//        }
	}
	/**
	 * Return the image view
	 * @return ImageView
	 */
	public final ImageView getImageView() {
        return this.imageView;
    }
	
	/**
	 * Return the snapshot of the image
	 * @return Image
	 */
	public final Image getImage() {
        return this.imageView.snapshot(this.snapshot, null);
    }
	
}
