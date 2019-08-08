package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.Random;

public class Parameters {

    int numberOfPaints = 0;

    private static final Parameters baseParameters = new Parameters();
    private Room baseWorld = new Room(50, 50, new Point(0, 0));
    private static long SEED;
    Random randomGenerator = new Random(SEED);
    TERenderer tileRenderer = new TERenderer();
    TETile[][] world = new TETile[baseWorld.getWidth()][baseWorld.getHeight()];

    int[][] numericWorld = new int[baseWorld.getWidth()][baseWorld.getHeight()];
    ArrayList<Room> finalRooms = new ArrayList<>();

    TETile floor = Tileset.FLOOR;
    TETile wall = Tileset.WALL;
    TETile player = Tileset.PLAYER;
    TETile nothing = Tileset.NOTHING;
    TETile water = Tileset.WATER;

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

    public int[][] getNumericWorld() {
        return numericWorld;
    }

    public ArrayList<Room> getFinalRooms() {
        return finalRooms;
    }

    public void setFinalRooms(ArrayList<Room> finalRooms) {
        this.finalRooms = finalRooms;
    }

    public void initializeWorld() {
        for (int i = 0; i < getBaseWorld().getWidth() ; i++) {
            for (int j = 0; j < getBaseWorld().getHeight(); j++) {
                getBaseParameters().getWorld()[i][j] = getBaseParameters().water;

            }

        }
    }

    public void initializeNumericWorld() {
        for (int i = 0; i < getBaseWorld().getWidth(); i++) {
            for (int j = 0; j < getBaseWorld().getHeight(); j++) {
                getBaseParameters().numericWorld[i][j] = 0;

            }

        }
    }

    public void printNumericWorld() {
        for (int i = 0; i < getBaseWorld().getWidth(); i++) {
            for (int j = 0; j < getBaseWorld().getHeight(); j++) {
                System.out.print(getBaseParameters().getNumericWorld()[i][j]);
            }
            System.out.println("");
        }
    }
}
