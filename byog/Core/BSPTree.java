package byog.Core;

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

    /** Randomly splits the baseNode vertically or horizontally */
    public void randomSplit() {
            int toss = getBaseParameters().randomGenerator.nextInt(1);
            if (toss == 0) {
                this.root.horizontalSplit();
            } else {
                this.root.verticalSplit();
            }
    }

}
