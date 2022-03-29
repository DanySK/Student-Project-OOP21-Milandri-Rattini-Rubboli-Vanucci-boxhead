package boxhead.controller.entities;

import boxhead.view.entities.*;
import boxhead.model.entities.zombies.*;


public interface ZombieController {

	/**
     * @return the model of Zombie
     */
    ZombieModel getZombieModel();


    /**
     * @return the view of Zombie
     */
    ZombieView getZombieView();

    /**
     * Updates model and view of Zombies
     */
    void update();
    
}
