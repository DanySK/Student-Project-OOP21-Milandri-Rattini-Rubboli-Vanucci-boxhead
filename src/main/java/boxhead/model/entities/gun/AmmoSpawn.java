package boxhead.model.entities.gun;

import java.util.Set;

import javafx.geometry.Point2D;

public interface AmmoSpawn {
	
	Set<Ammo> getAmmoActive();
	
	void setAmmoSpawnPoints(Set<Point2D> ammoSpawnPoints);
	
	void removeAmmo(Ammo ammo);
	
	void update();
}
