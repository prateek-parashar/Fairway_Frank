package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.Random;

public class Parameters {

    static int WIDTH = 70;
    static int HEIGHT = 40;

    private static final Parameters baseParameters = new Parameters();
    private Partition baseWorld = new Partition(WIDTH, HEIGHT, new Point(0, 0));
    private long SEED;
    private Random randomGenerator;
    private TERenderer tileRenderer = new TERenderer();
    private TETile[][] world = new TETile[baseWorld.getWidth()][baseWorld.getHeight()];

    private ArrayList<Partition> finalPartitions = new ArrayList<>();
    private ArrayList<Room> finalRooms = new ArrayList<>();
    private ArrayList<Hallway> finalHallways = new ArrayList<>();
    static int MIN_ROOM_SIZE = 4;

    private TETile floor = Tileset.FLOOR;
    private TETile wall = Tileset.WALL;
    private TETile playerTile = Tileset.PLAYER;
    private TETile nothing = Tileset.NOTHING;

    private startScreen startScreen = new startScreen();

    private Player player = new Player(baseWorld.getCentre());

    private boolean beginGame = false;

    public boolean isBeginGame() {
        return beginGame;
    }

    public void setBeginGame(boolean beginGame) {
        this.beginGame = beginGame;
    }

    public static Parameters getBaseParameters() {
        return baseParameters;
    }

    public Partition getBaseWorld() {
        return baseWorld;
    }

    public long getSEED() {
        return this.SEED;
    }

    public void setSEED(long SEED) {
        this.SEED = SEED;
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

    public TETile[][] getWorld() {
        return world;
    }

    public ArrayList<Room> getFinalRooms() {
        return finalRooms;
    }

    public TETile getFloor() {
        return floor;
    }

    public TETile getWall() {
        return wall;
    }

    public TETile getPlayerTile() {
        return playerTile;
    }

    public ArrayList<Partition> getFinalPartitions() {
        return finalPartitions;
    }

    public ArrayList<Hallway> getFinalHallways() {
        return finalHallways;
    }

    public startScreen getStartScreen() {
        return startScreen;
    }

    public Player getPlayer() {
        return player;
    }

    public void initializeWorld() {
        for (int i = 0; i < getBaseWorld().getWidth() ; i++) {
            for (int j = 0; j < getBaseWorld().getHeight(); j++) {
                getBaseParameters().getWorld()[i][j] = getBaseParameters().nothing;
            }

        }
    }

}
