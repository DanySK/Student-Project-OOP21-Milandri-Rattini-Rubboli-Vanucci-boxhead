package boxhead.view.entities;

import boxhead.model.entities.EntityType;
import boxhead.view.spriteutils.Sprite;

public class AmmoView {
	
	private final Sprite sprite;
	
	public AmmoView() {
		this.sprite = new Sprite(EntityType.AMMO);
	}
	
	public final Sprite getSprite() {
		return this.sprite;
	}
}
