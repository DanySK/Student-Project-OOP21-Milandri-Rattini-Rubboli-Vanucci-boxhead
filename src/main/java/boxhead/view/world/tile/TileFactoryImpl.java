package boxhead.view.world.tile;

import java.util.Map;
import java.util.Set;

import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileFactoryImpl implements TileFactory {
	private double tileSize;
	private final TileSet tiles;

	/**
	 * Constructor, URL of the image for TileSet, size of the tile in the image
	 *
	 * @param url
	 * @param s
	 */

	public TileFactoryImpl(final double s) {
		tileSize = s;
		tiles = new TileSetImpl();
		tiles.Tiles((int) tileSize);
		;
	}

	@Override
	public void setTileSize(final double size) {
		tileSize = size;

	}

	@Override
	public Tile createTile(final Integer t, final Point2D pos, final double s) {

		return new Tile() {

			private final ImageView img = new ImageView(tiles.getTile(t));
			private final SnapshotParameters SP = new SnapshotParameters();
			private final Point2D p = pos;
			private final double size = s;
			private double scale = 1.0;

			@Override
			public Image getTile() {
				return img.snapshot(SP, null);
			}

			@Override
			public double getSize() {
				return size * scale;
			}

			@Override
			public void setRenderScale(final double scale) {
				this.scale = scale;
				img.setFitHeight(s * scale);
				img.setFitWidth(s * scale);

			}

			@Override
			public double getRenderScale() {
				return scale;
			}

			@Override
			public Point2D getRelativePos() {
				return p.multiply(getSize());
			}

			@Override
			public Point2D getPos() {
				return p;
			}

			@Override
			public double getX() {
				return p.getX();
			}

			@Override
			public double getY() {
				return p.getY();
			}

		};
	}

	@Override
	public Set<Tile> createTiles(final Map<Point2D, Integer> tile, final double s) {

		return null;
	}

}
