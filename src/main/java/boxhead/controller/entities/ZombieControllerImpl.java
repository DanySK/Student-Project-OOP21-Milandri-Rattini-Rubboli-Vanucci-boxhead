package boxhead.controller.entities;

import java.util.HashSet;
import java.util.Set;

import javafx.geometry.Point2D;
import javafx.util.Pair;
import boxhead.controller.game.GameWorld;
import boxhead.model.entities.utils.Direction;
import boxhead.model.entities.zombies.ZombieAIImpl;
import boxhead.model.entities.zombies.ZombieModel;
import boxhead.model.entities.zombies.ZombieModelImpl;
import boxhead.view.entities.ZombieView;
import boxhead.view.entities.ZombieViewImpl;

/**
 * {@link ZombieController} implementation
 *
 */
public class ZombieControllerImpl implements ZombieController {

    private final ZombieModel zombies;
    private final GameWorld gameController;
    private final ZombieView zombieView;

    /**
     * Instantiates a {@link ZombieControllerImpl}
     * @param gameController game controller
     */
    public ZombieControllerImpl(final GameWorld gameController) {
        this.gameController = gameController;
        this.zombies = new ZombieModelImpl();
        this.zombieView = new ZombieViewImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void update() {
        this.zombies.update();
        this.updateView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final ZombieModel getZombieModel() {
        return this.zombies;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final ZombieView getZombieView() {
        return this.zombieView;
    }

    /**
     * Update zombieview for every zombie 
     */
    private void updateView() {
        final Set<Pair<Point2D, Direction>> positions = new HashSet<>();
        this.zombies.getZombies().forEach(zombie -> {
            positions.add(new Pair<>(zombie.getPosition(), ZombieAIImpl.getDirectionToPlayer(zombie, this.gameController.getPlayerController().getPlayer())));
        });
        this.zombieView.setPositionsAndDirections(positions);
        this.zombieView.update();
    }

}
