package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static byog.Core.BSPTree.splitAndGrow;
import static byog.Core.Parameters.getBaseParameters;

public class TestPlay {
    public static void main(String[] args) {
        getBaseParameters().getTileRenderer().initialize(getBaseParameters().getBaseWorld().getWidth(),
                getBaseParameters().getBaseWorld().getHeight());
        getBaseParameters().getStartScreen().drawWelcomeScreen();
        getBaseParameters().getStartScreen().initializeGame();
        getBaseParameters().initializeWorld();

        getBaseParameters().setRandomGenerator(new Random(getBaseParameters().getSEED()));

        BSPTree gameTree = splitAndGrow(getBaseParameters().getBaseWorld(), 5);

        gameTree.generateRooms();
        gameTree.generateHallways();

        gameTree.storePartitions();

        renderHallways(getBaseParameters().getFinalHallways());
        renderRooms(getBaseParameters().getFinalRooms());
        fillHallways(getBaseParameters().getFinalHallways());


        StdDraw.clear(Color.BLACK);

        while (getBaseParameters().isBeginGame()) {
            getBaseParameters().getPlayer().enableMovement();
        }
    }

    public static void printPartitions(ArrayList<Partition> partitionList) {
        for (Partition p : partitionList) {
            System.out.println(p);
        }
    }

    public static void printRooms(ArrayList<Room> roomList) {
        for (Room r : roomList) {
            System.out.println(r);
        }
    }

    public static void printHallways(ArrayList<Hallway> hallwayList) {
        for (Hallway h : hallwayList) {
            System.out.println(h);
        }
    }

    public static void renderRooms(ArrayList<Room> roomList) {
        for (Room r : roomList) {
            r.drawRoom();
        }
    }

    public static void renderHallways(ArrayList<Hallway> hallwayList) {
        for (Hallway h : hallwayList) {
            h.drawHallway();
        }
    }

    public static void fillHallways(ArrayList<Hallway> hallwayList) {
        for (Hallway h : hallwayList) {
            h.fillHallway();
        }
    }
}
