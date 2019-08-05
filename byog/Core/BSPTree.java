package byog.Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    /** Splits the given room vertically with a random chosen point in the x axis
     * @param SEED
     * @return - list of the 2 new Room objects
     */
    public List<Room> verticalSplit(long SEED) {
        ArrayList<Room> returnList = new ArrayList<>();
        Room baseRoom = this.root;
        Random random = new Random(SEED);
        int breakPoint = random.nextInt(baseRoom.getWidth());

        Point leftCorner1 = baseRoom.getLeftCorner();
        Point leftCorner2 = new Point(baseRoom.getLeftCorner().getX() + breakPoint, baseRoom.getLeftCorner().getY());

        int width1 = leftCorner2.getX() - leftCorner1.getX();
        int width2 = baseRoom.getWidth() - breakPoint;

        Room room1 = new Room(baseRoom.getHeight(), width1, leftCorner1);
        Room room2 = new Room(baseRoom.getHeight(), width2, leftCorner2);

        if((room1.roomRatio() > 0.45) &&  (room2.roomRatio() > 0.45)) {
            returnList.add(room1);
            returnList.add(room2);
        }
        return verticalSplit(SEED);
    }

    /** Splits the given room horizontally with a random chosen point in the y axis
     * @param SEED
     * @return - list of the 2 new Room objects
     */
    public List<Room> horizontalSplit(long SEED) {
        ArrayList<Room> returnList = new ArrayList<>();
        Room baseRoom = this.root;
        Random random = new Random(SEED);
        int breakPoint = random.nextInt(baseRoom.getHeight());

        Point leftCorner1 = baseRoom.getLeftCorner();
        Point leftCorner2 = new Point(baseRoom.getLeftCorner().getX(), baseRoom.getLeftCorner().getY() + breakPoint);

        int height1 = leftCorner2.getY() - leftCorner1.getY();
        int height2 = baseRoom.getHeight() - breakPoint;

        Room room1 = new Room(height1, baseRoom.getWidth(), leftCorner1);
        Room room2 = new Room(height2, baseRoom.getWidth(), leftCorner2);

        if((room1.roomRatio() > 0.45) &&  (room2.roomRatio() > 0.45)) {
            returnList.add(room1);
            returnList.add(room2);
        }
        return verticalSplit(SEED);
    }
}
