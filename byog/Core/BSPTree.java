package byog.Core;

import java.util.ArrayList;

import static byog.Core.Parameters.getBaseParameters;

/**
 * This class is used as a data structure to allow recursive solution to the problems at hand.
 * Usage of this data structure ensures that we do not end up with overlapping rooms
 *
 * @Source --> https://eskerda.com/bsp-dungeon-generation/
 */
public class BSPTree {
    private Partition root;
    private BSPTree leftChild = null;
    private BSPTree rightChild = null;


    public BSPTree() {

    }

    public BSPTree(Partition root) {
        this.root = root;
    }

    public BSPTree(Partition root, BSPTree leftChild, BSPTree rightChild) {
        this.root = root;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void addLeftChild(BSPTree bspTree) {
        this.setLeftChild(bspTree);
    }

    public void addRightChild(BSPTree bspTree) {
        this.setRightChild(bspTree);
    }

    public Partition getRoot() {
        return root;
    }

    public BSPTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSPTree leftChild) {
        this.leftChild = leftChild;
    }

    public BSPTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSPTree rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Resursively creates a BSP Tree with the given world partition
     */
    public static BSPTree splitAndGrow(Partition r, int iterations) {
        BSPTree baseTree = new BSPTree(r);

        if (iterations > 0) {
            int toss = iterations % 2;
            Partition[] childPartitions = baseTree.randomSplitAndGrow(toss);
            baseTree.addLeftChild(splitAndGrow(childPartitions[0], iterations - 1));
            baseTree.addRightChild(splitAndGrow(childPartitions[1], iterations - 1));
        }
        return baseTree;
    }

    /**
     * Randomly splits the baseNode vertically or horizontally and grow the tree with the resulting rooms
     */
    public Partition[] randomSplitAndGrow(int toss) {
        Partition[] newPartitions;
        if (toss == 0) {
            newPartitions = this.root.horizontalSplit();
        } else {
            newPartitions = this.root.verticalSplit();
        }
        return newPartitions;
    }

    /**
     * Checks to see if the Binary tree is a leaf with no nodes
     */
    public boolean isNull() {
        return ((this.leftChild == null) && (this.rightChild == null));
    }

    /**
     * Function to print all the tree leaves
     */
    public void storePartitions() {
        if (this.isNull()) {
            getBaseParameters().getFinalPartitions().add(this.root);
        } else {
            this.leftChild.storePartitions();
            this.rightChild.storePartitions();
        }
    }

    /**
     * Creates and stores the room in each and every partition at the leaves end of the tree
     */
    public void generateRooms() {
        if (this.isNull()) {
            getBaseParameters().getFinalRooms().add(this.root.createRoom());
        } else {
            this.leftChild.generateRooms();
            this.rightChild.generateRooms();
        }
    }

    /**
     * Creates hallways between 2 given partition at the leaves of the tree
     */
    public void generateHallways() {
        if (this.isNull()) {
            return;
        } else {
            Hallway hallWay = new Hallway(this.getLeftChild().getRoot().getCentre(),
                    this.getRightChild().getRoot().getCentre());
            getBaseParameters().getFinalHallways().add(hallWay);
            this.leftChild.generateHallways();
            this.rightChild.generateHallways();
        }
    }

    /**
     * Draws the rooms on the TETile[][] world paramter
     */
    public void renderRooms(ArrayList<Room> roomList) {
        for (Room r : roomList) {
            r.drawRoom();
        }
    }

    /**
     * Draws the walls of the hallways between the centre points of 2 sister partitions of the tree
     */
    public void renderHallways(ArrayList<Hallway> hallwayList) {
        for (Hallway h : hallwayList) {
            h.drawHallway();
        }
    }

    /**
     * Fill the drawn hallways with floor tiles
     */
    public void fillHallways(ArrayList<Hallway> hallwayList) {
        for (Hallway h : hallwayList) {
            h.fillHallway();
        }
    }
}
