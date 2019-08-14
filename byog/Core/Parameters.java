package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.Random;

public class Parameters {

    private int numberOfPaints = 0;
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
    private TETile water = Tileset.WATER;

    private startScreen startScreen = new startScreen();

    private Player player = new Player(baseWorld.getCentre());

    private boolean beginGame;
    private boolean quitGame;

    public boolean isBeginGame() {
        return beginGame;
    }

    public void setBeginGame(boolean beginGame) {
        this.beginGame = beginGame;
    }

    public boolean isQuitGame() {
        return quitGame;
    }

    public void setQuitGame(boolean quitGame) {
        this.quitGame = quitGame;
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

    public Partition getBaseWorld() {
        return baseWorld;
    }

    public void setBaseWorld(Partition baseWorld) {
        this.baseWorld = baseWorld;
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

    public void setTileRenderer(TERenderer tileRenderer) {
        this.tileRenderer = tileRenderer;
    }

    public TETile[][] getWorld() {
        return world;
    }

    public void setWorld(TETile[][] world) {
        this.world = world;
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

    public TETile getPlayerTile() {
        return playerTile;
    }

    public void setPlayerTile(TETile playerTile) {
        this.playerTile = playerTile;
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

    public ArrayList<Partition> getFinalPartitions() {
        return finalPartitions;
    }

    public void setFinalPartitions(ArrayList<Partition> finalPartitions) {
        this.finalPartitions = finalPartitions;
    }

    public static int getMinRoomSize() {
        return MIN_ROOM_SIZE;
    }

    public static void setMinRoomSize(int minRoomSize) {
        MIN_ROOM_SIZE = minRoomSize;
    }

    public ArrayList<Hallway> getFinalHallways() {
        return finalHallways;
    }

    public void setFinalHallways(ArrayList<Hallway> finalHallways) {
        this.finalHallways = finalHallways;
    }

    public startScreen getStartScreen() {
        return startScreen;
    }

    public void setStartScreen(startScreen startScreen) {
        this.startScreen = startScreen;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void initializeWorld() {
        for (int i = 0; i < getBaseWorld().getWidth() ; i++) {
            for (int j = 0; j < getBaseWorld().getHeight(); j++) {
                getBaseParameters().getWorld()[i][j] = getBaseParameters().nothing;
            }

        }
    }

}
