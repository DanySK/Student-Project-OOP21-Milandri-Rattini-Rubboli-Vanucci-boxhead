package boxhead.view.world.tile;

import javafx.scene.image.WritableImage;

/**
 * Interface to create a set of tile, a collection of image
 *
 */
public interface TileSet {
	/**
	 * Method to load the image of a tileSet
	 *
	 * @param url
	 */
	void loadImage(String url);

	/**
	 * Method necessary to populate the gameWorld
	 *
	 * @param size
	 */
	void loadTiles(int size);

	/**
	 * Method to get a tile from the index
	 *
	 * @param index
	 * @return WritableImage
	 */
	WritableImage getTile(int index);
}
