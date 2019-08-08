package byog.Core;

import static byog.Core.Parameters.getBaseParameters;

public class TestPlay {
    public static void main(String[] args) {
        long currentSeed = 64511135;
        getBaseParameters().tileRenderer.initialize(50, 50);
        getBaseParameters().setSEED(currentSeed);
        getBaseParameters().initializeWorld();
        getBaseParameters().initializeNumericWorld();

//        getBaseParameters().printNumericWorld();

        System.out.println("#########################");
        System.out.println("#########################");
        System.out.println("#########################");


        BSPTree gameTree = splitAndGrow(getBaseParameters().getBaseWorld(), 3);
//        BSPTree gameTree = new BSPTree(getBaseParameters().getBaseWorld());
        gameTree.drawPartitions();

        gameTree.storeLeaves();
//        System.out.println(getBaseParameters().numberOfPaints + " ");

//        getBaseParameters().getFinalRooms().get(1).drawRoom();
        getBaseParameters().printNumericWorld();
        gameTree.printPartitions();

        getBaseParameters().tileRenderer.renderFrame(getBaseParameters().getWorld());

    }

    public static BSPTree splitAndGrow(Room r, int iterations) {
        BSPTree baseTree = new BSPTree(r);

        if(iterations > 0) {
            int toss = iterations % 2;
            Room[] childRooms = baseTree.randomSplitAndGrow(toss);
            baseTree.addLeftChild(splitAndGrow(childRooms[0], iterations - 1));
            baseTree.addRightChild(splitAndGrow(childRooms[1], iterations - 1));
        }
        return baseTree;
    }
}
