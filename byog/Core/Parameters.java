package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class Parameters {
    private static final Parameters baseParameters = new Parameters();
    private Room baseWorld = new Room(40, 80, new Point(0, 0));
    private static long SEED;
    Random randomGenerator = new Random(SEED);
    TERenderer tileRenderer = new TERenderer();
    TETile[][] world = new TETile[baseWorld.getWidth()][baseWorld.getHeight()];
    TETile floor = Tileset.FLOOR;
    TETile wall = Tileset.WALL;
    TETile player = Tileset.PLAYER;

    public static Parameters getBaseParameters() {
        return baseParameters;
    }

    public Room getBaseWorld() {
        return baseWorld;
    }

    public static long getSEED() {
        return SEED;
    }

    public TERenderer getTileRenderer() {
        return tileRenderer;
    }

    public TETile[][] getWorld() {
        return world;
    }

    public TETile getFloor() {
        return floor;
    }

    public TETile getWall() {
        return wall;
    }

    public TETile getPlayer() {
        return player;
    }

    public void setSEED(long value) {
        baseParameters.SEED = value;
    }
}
