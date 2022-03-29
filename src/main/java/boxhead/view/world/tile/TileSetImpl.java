package boxhead.view.world.tile;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class TileSetImpl implements TileSet {

	private Image src;
	private final List<WritableImage> tiles;

	/**
	 * Constructor with url of the image
	 *
	 * @param url
	 */
	public TileSetImpl(final String url) {
		this();
		loadImage(url);
	}

	/**
	 * Constructor if image of the TileSet is not known yet.
	 */
	public TileSetImpl() {
		tiles = new LinkedList<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadImage(final String url) {
		src = new Image(getClass().getResourceAsStream(url));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WritableImage getTile(final int index) {

		return tiles.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void Tiles(final int size) {
		final PixelReader pxR = src.getPixelReader();
		final int w = size;
		final int h = size;
		for (int i = 0; i < (src.getHeight() / size); i++) {
			for (int j = 0; j < (src.getWidth() / size); j++) {
				tiles.add(new WritableImage(pxR, j * size, i * size, w, h));
			}
		}

	}

}
