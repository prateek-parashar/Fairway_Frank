package byog.Core;

import java.util.ArrayList;
import java.util.Random;

import static byog.Core.Parameters.getBaseParameters;

public class TestPlay {
    public static void main(String[] args) {
        long currentSeed = 123456;
        getBaseParameters().getTileRenderer().initialize(getBaseParameters().getBaseWorld().getWidth(),
                                                                getBaseParameters().getBaseWorld().getHeight());
        getBaseParameters().setRandomGenerator(new Random(currentSeed));
        getBaseParameters().initializeWorld();

        BSPTree gameTree = splitAndGrow(getBaseParameters().getBaseWorld(), 5);

        gameTree.generateRooms();
        gameTree.generateHallways();

        gameTree.storePartitions();

        renderHallways(getBaseParameters().getFinalHallways());
        renderRooms(getBaseParameters().getFinalRooms());
        fillHallways(getBaseParameters().getFinalHallways());

        getBaseParameters().getTileRenderer().renderFrame(getBaseParameters().getWorld());

    }

    public static BSPTree splitAndGrow(Partition r, int iterations) {
        BSPTree baseTree = new BSPTree(r);

        if(iterations > 0) {
            int toss = iterations % 2;
            Partition[] childPartitions = baseTree.randomSplitAndGrow(toss);
            baseTree.addLeftChild(splitAndGrow(childPartitions[0], iterations - 1));
            baseTree.addRightChild(splitAndGrow(childPartitions[1], iterations - 1));
        }
        return baseTree;
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
