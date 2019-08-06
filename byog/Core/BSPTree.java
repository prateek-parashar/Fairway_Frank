package byog.Core;

import java.util.ArrayList;
import java.util.List;

import static byog.Core.Parameters.getBaseParameters;


public class BSPTree {
    private Room root;
    private BSPTree leftChild = null;
    private BSPTree rightChild = null;

    public BSPTree() {

    }

    public BSPTree(Room root) {
        this.root = root;
    }

    public BSPTree(Room root, BSPTree leftChild, BSPTree rightChild) {
        this.root = root;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Room getRoot() {
        return root;
    }

    public void setRoot(Room root) {
        this.root = root;
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

    /** Randomly splits the baseNode vertically or horizontally and grow the tree with the resulting rooms */
    public void randomSplitAndGrow() {
            int toss = getBaseParameters().randomGenerator.nextInt(1);
            if (toss == 0) {
                Room[] newRooms = this.root.horizontalSplit();
                this.leftChild.root = newRooms[0];
                this.rightChild.root = newRooms[1];
            } else {
                Room[] newRooms =  this.root.verticalSplit();
                this.leftChild.root = newRooms[0];
                this.rightChild.root = newRooms[1];
            }
    }

    /** Does a pre - order traversal of the tree and creates partitions along the way */
    public void createPartitions(int iterations) {
        while (iterations > 0) {
            this.randomSplitAndGrow();
            this.leftChild.createPartitions(iterations - 1);
            this.rightChild.createPartitions(iterations - 1);
        }
    }

    /** Checks to see if the Binary tree is a leaf with no nodes */
    public boolean isNull() {
        return ((this.leftChild == null) && (this.rightChild == null));
    }

   public void drawPartitions() {
        if (this.isNull()) {
            this.root.drawRoom();
        } else {
            this.leftChild.drawPartitions();
            this.rightChild.drawPartitions();
        }
   }

}
