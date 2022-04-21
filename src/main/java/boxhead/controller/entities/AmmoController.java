package boxhead.controller.entities;

import java.util.Map;
import java.util.Set;

import boxhead.model.entities.gun.Ammo;
import boxhead.view.entities.AmmoView;
import javafx.geometry.BoundingBox;

public interface AmmoController {
	
	Set<BoundingBox> getAmmos();
	
	Map<Ammo, AmmoView> getAmmoView();
	
	void removeAmmo(BoundingBox ammo);
	
	void update();
}
