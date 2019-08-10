package byog.Core;

import static byog.Core.Parameters.getBaseParameters;


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

    public void setRoot(Partition root) {
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
    public Partition[] randomSplitAndGrow(int toss) {
        Partition[] newPartitions;
        if (toss == 1) {
                newPartitions = this.root.horizontalSplit();
            } else {
                newPartitions =  this.root.verticalSplit();
            }
        return newPartitions;
    }

    /** Checks to see if the Binary tree is a leaf with no nodes */
    public boolean isNull() {
        return ((this.leftChild == null) && (this.rightChild == null));
    }

   /** Function to print all the tree leaves */
   public void printPartitions() {
       if (this.isNull()) {
           System.out.println(this.root.getLeftCorner());
           System.out.println(this.root.getWidth());
           System.out.println(this.root.getHeight());
           System.out.println(this.root.getCentre());
       } else {
           this.leftChild.printPartitions();
           this.rightChild.printPartitions();
       }
   }

   /** Creates and stores the room in each and every partition at the leaves end of the tree */
   public void generateRooms() {
       if(this.isNull()) {
           getBaseParameters().getFinalRooms().add(this.root.createRoom());
       } else {
           this.leftChild.generateRooms();
           this.rightChild.generateRooms();
       }
   }


}
