package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class Parameters {
    private Room baseWorld;
    private static long SEED;
    TERenderer tileRenderer = new TERenderer();
    TETile[][] world = new TETile[baseWorld.getWidth()][baseWorld.getHeight()];
    TETile floor = Tileset.FLOOR;
    TETile wall = Tileset.WALL;
    TETile player = Tileset.PLAYER;
}
