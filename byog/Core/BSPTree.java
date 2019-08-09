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
    public void addLeftChild(BSPTree bspTree) {
        this.setLeftChild(bspTree);
    }

    public void addRightChild(BSPTree bspTree) {
        this.setRightChild(bspTree);
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
    public Room[] randomSplitAndGrow(int toss) {
        Room[] newRooms;
        if (toss == 1) {
                newRooms = this.root.horizontalSplit();
            } else {
                newRooms =  this.root.verticalSplit();
            }
        return newRooms;
    }

    /** Checks to see if the Binary tree is a leaf with no nodes */
    public boolean isNull() {
        return ((this.leftChild == null) && (this.rightChild == null));
    }

    /** Draws all the partitions of the main world / leaves of the tree */
   public void drawPartitions() {
        if (this.isNull()) {
            this.root.drawRoom();
        } else {
            this.leftChild.drawPartitions();
            this.rightChild.drawPartitions();
        }
   }

   /** Stores all the rooms in a ArrayList */
   public void storeLeaves() {
       if (this.isNull()) {
           getBaseParameters().getFinalRooms().add(this.root);
       } else {
           this.leftChild.storeLeaves();
            this.rightChild.storeLeaves();
       }
   }

   /** Function to print all the tree leaves */
   public void printPartitions() {
       if (this.isNull()) {
           System.out.println(this.root.getLeftCorner());
           System.out.println(this.root.getWidth());
           System.out.println(this.root.getHeight());
       } else {
           this.leftChild.printPartitions();
           this.rightChild.printPartitions();
       }
   }

}
