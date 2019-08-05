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
    // Draws the top portion of the hexagon
    private static void drawUpper(TETile[][] world, Position p, int size, TETile t) {
        int rowLength = size;
        int originalPosition = p.pX;

        while (size > 0) {
            p.pX = originalPosition + size - 1;
            for (int i = p.pX; i < p.pX + rowLength; i++) {
                world[i][p.pY] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
            }

            p.pY -= 1;
            rowLength += 2;
            size -= 1;
        }
        p.pX = originalPosition;
    }

    // Draws the lower half of the hexagon
    private static void drawLower(TETile[][] world, Position p, int size, TETile t) {
        int rowLength = size + (size - 1) * 2;
        int originalPosition = p.pX;

        while (size > 0) {
            try {
                for (int i = p.pX; i < p.pX + rowLength; i++) {
                    world[i][p.pY] = TETile.colorVariant(t, 39, 32, 52, RANDOM);
                }
            } catch (Exception e) {
                // handle exception
                throw new IllegalArgumentException("Get out of here");
            }
            size--;
            rowLength -= 2;
            p.pX += 1;
            p.pY -= 1;
        }
        p.pX = originalPosition;
    }

    public static void addHexagon(TETile[][] world, Position p, int size, TETile t) {
        if (size < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }
        drawUpper(world, p, size, t);
        drawLower(world, p, size, t);
    }

    /** Method to draw vertical hexagons */
    private static void drawVerticalHexagons(TETile[][] world, Position p, int size, int length, TETile t) {
        int originalX = p.pX;
        int originalY = p.pY;
        while (length > 0) {
            addHexagon(world, p, size, t);
            length--;
        }
        p.pX = originalX;
        p.pY = originalY;
    }

    private static void updatePosition(Position p, int size, char side) {
        switch (side) {
            case 'L': p.pX = p.pX - (size + 2);
                      p.pY = p.pY - size;
                      break;
            case 'R': p.pX = p.pX + size + (size - 1) * 2 - 2;
                      p.pY = p.pY - size;
                      break;
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        fillWithRandomTiles(randomTiles);

        Position p = new Position(20, 40);
        TETile t = Tileset.TREE;
        drawVerticalHexagons(randomTiles, p, 3, 5, t);
        updatePosition(p, 3, 'L');
        drawVerticalHexagons(randomTiles, p, 3, 4, t);
        updatePosition(p, 3, 'L');
        drawVerticalHexagons(randomTiles, p, 3, 3, t);

        p.pX = 20;
        p.pY = 40;
        updatePosition(p, 3, 'R');
        drawVerticalHexagons(randomTiles, p, 3, 4, t);
        updatePosition(p, 3, 'R');
        drawVerticalHexagons(randomTiles, p, 3, 3, t);

        ter.renderFrame(randomTiles);
    }
}
