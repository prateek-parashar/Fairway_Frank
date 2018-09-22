package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world that contains RANDOM tiles.
 */
public class RandomWorldDemo {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    /**
     * Fills the given 2D array of tiles with RANDOM tiles.
     * @param tiles
     */
    public static void fillWithRandomTiles(TETile[][] tiles) {
        int height = tiles[0].length;
        int width = tiles.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = randomTile();
            }
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.NOTHING;
            default: return Tileset.NOTHING;
        }
    }

    public static void drawUpper(TETile[][] world, Position p, int size, TETile t) {
        int rowLength = size;
        int originalPosition = p.pX;

        while (size > 0) {
            p.pX = originalPosition + size - 1;
            for (int i = p.pX; i < p.pX + rowLength; i++) {
                world[i][p.pY] = t;
            }

            p.pY -= 1;
            rowLength += 2;
            size -= 1;
        }
        p.pX = originalPosition;
        p.pY -= 1;
    }

    public static void addHexagon(TETile[][] world, Position p, int size, TETile t) {
        drawUpper(world, p, size, t);
        //drawLower(world, p, size, t);
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        fillWithRandomTiles(randomTiles);

        Position p = new Position(10, 10);
        TETile t = Tileset.WATER;
        addHexagon(randomTiles, p, 4, t);
        ter.renderFrame(randomTiles);
    }


}
