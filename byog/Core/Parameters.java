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
    Random randomGenerator;
    TERenderer tileRenderer = new TERenderer();
    TETile[][] world = new TETile[baseWorld.getWidth()][baseWorld.getHeight()];

    int[][] numericWorld = new int[baseWorld.getWidth()][baseWorld.getHeight()];
    ArrayList<Room> finalRooms = new ArrayList<>();

    TETile floor = Tileset.FLOOR;
    TETile wall = Tileset.WALL;
    TETile player = Tileset.PLAYER;
    TETile nothing = Tileset.NOTHING;
    TETile water = Tileset.WATER;

    public void initializeWorld() {
        for (int i = 0; i < getBaseWorld().getWidth() ; i++) {
            for (int j = 0; j < getBaseWorld().getHeight(); j++) {
                getBaseParameters().getWorld()[i][j] = getBaseParameters().wall;

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

    public int getNumberOfPaints() {
        return numberOfPaints;
    }

    public void setNumberOfPaints(int numberOfPaints) {
        this.numberOfPaints = numberOfPaints;
    }

    public static Parameters getBaseParameters() {
        return baseParameters;
    }

    public Room getBaseWorld() {
        return baseWorld;
    }

    public void setBaseWorld(Room baseWorld) {
        this.baseWorld = baseWorld;
    }

    public static long getSEED() {
        return SEED;
    }

    public static void setSEED(long SEED) {
        Parameters.SEED = SEED;
    }

    public Random getRandomGenerator() {
        return randomGenerator;
    }

    public void setRandomGenerator(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public TERenderer getTileRenderer() {
        return tileRenderer;
    }

    public void setTileRenderer(TERenderer tileRenderer) {
        this.tileRenderer = tileRenderer;
    }

    public TETile[][] getWorld() {
        return world;
    }

    public void setWorld(TETile[][] world) {
        this.world = world;
    }

    public int[][] getNumericWorld() {
        return numericWorld;
    }

    public void setNumericWorld(int[][] numericWorld) {
        this.numericWorld = numericWorld;
    }

    public ArrayList<Room> getFinalRooms() {
        return finalRooms;
    }

    public void setFinalRooms(ArrayList<Room> finalRooms) {
        this.finalRooms = finalRooms;
    }

    public TETile getFloor() {
        return floor;
    }

    public void setFloor(TETile floor) {
        this.floor = floor;
    }

    public TETile getWall() {
        return wall;
    }

    public void setWall(TETile wall) {
        this.wall = wall;
    }

    public TETile getPlayer() {
        return player;
    }

    public void setPlayer(TETile player) {
        this.player = player;
    }

    public TETile getNothing() {
        return nothing;
    }

    public void setNothing(TETile nothing) {
        this.nothing = nothing;
    }

    public TETile getWater() {
        return water;
    }

    public void setWater(TETile water) {
        this.water = water;
    }
}
