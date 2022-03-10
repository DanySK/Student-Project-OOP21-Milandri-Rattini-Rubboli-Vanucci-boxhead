package boxhead.model.entities;

import javafx.geometry.Point2D;

public class Wall extends AbstractEntity {
	
	public Wall(final Point2D position, final double width, final double height) {
		super(position,EntityType.WALL);
		super.setBoundingBox(width,height);
	}
}
