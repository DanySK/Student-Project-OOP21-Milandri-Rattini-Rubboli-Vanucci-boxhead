package boxhead.view.spriteutils;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import boxhead.model.entities.EntityType;

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
    
    public Sprite(final EntityType type) {
        this.type = type;
        this.setImageView();
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
			this.imageView.setImage(PLACEHOLDER);
		case PLAYER:
			this.imageView.setFitHeight(PLAYER_HEIGHT);
			this.imageView.setFitWidth(PLAYER_WIDTH);
			this.imageView.setImage(PLACEHOLDER);
		case BULLET:
			this.imageView.setFitHeight(BULLET_HEIGHT);
			this.imageView.setFitWidth(BULLET_WIDTH);
			this.imageView.setImage(PLACEHOLDER);
		case AMMO:
			this.imageView.setFitHeight(PASSIVE_HEIGHT);
			this.imageView.setFitWidth(PASSIVE_WIDTH);
			this.imageView.setImage(PLACEHOLDER);
		case WALL:
			this.imageView.setFitHeight(PASSIVE_HEIGHT);
			this.imageView.setFitWidth(PASSIVE_WIDTH);
			this.imageView.setImage(PLACEHOLDER);
		default:
			this.imageView.setFitHeight(PASSIVE_HEIGHT);
			this.imageView.setFitWidth(PASSIVE_WIDTH);
			this.imageView.setImage(PLACEHOLDER);	
		}
	}
}
