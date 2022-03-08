package entities;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;

public abstract class AbstractEntity implements Entity {
	
	private Point2D position;
	private EntityType entityType;
	private double height;
	private double width;
	
	public AbstractEntity(Point2D position,EntityType entityType) {
		this.position=position;
		this.entityType=entityType;
	}

	public void setPosition(Point2D position) {
		this.position=position;
	}

	public Point2D getPosition() {
		return this.position;
	}

	public void setBoundingBox(double height, double width) {
		this.height=height;
		this.width=width;

	}

	public BoundingBox getBoundingBox() {
		return new BoundingBox(this.position.getX(),this.position.getY(),this.width,this.height);
	}

	public double getHeight() {
		return this.height;
	}

	public double getWidth() {
		return this.width;
	}

}
