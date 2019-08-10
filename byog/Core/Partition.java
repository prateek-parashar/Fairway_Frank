package byog.Core;

import static byog.Core.Parameters.getBaseParameters;

public class Partition {
    private int width;
    private int height;
    private Point leftCorner;
    private Point centre;

    public Partition() {

    }

    public Partition(int width, int height, Point leftCorner) {
        this.width = width;
        this.height = height;
        this.leftCorner = leftCorner;
        this.centre = new Point(this.width / 2, this.height / 2);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point getLeftCorner() {
        return leftCorner;
    }

    public void setLeftCorner(Point leftCorner) {
        this.leftCorner = leftCorner;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    /** Splits the given partition vertically with a random chosen point in the x axis
     * @return - list of the 2 new Partition objects
     */
    public Partition[] verticalSplit() {
        Partition[] returnList = new Partition[2];
        Partition basePartition = this;
        int breakPoint = getBaseParameters().getRandomGenerator().nextInt(basePartition.getWidth());

        double ratio = (double) breakPoint / this.getWidth();

        if((ratio < 0.40) || (ratio > 0.60)) {
            return this.verticalSplit();
        } else {
            Point leftCorner1 = basePartition.getLeftCorner();
            Point leftCorner2 = new Point(basePartition.getLeftCorner().getX() + breakPoint, basePartition.getLeftCorner().getY());

            int width1 = leftCorner2.getX() - leftCorner1.getX();
            int width2 = basePartition.getWidth() - breakPoint;

            Partition partition1 = new Partition(width1, basePartition.getHeight(), leftCorner1);
            Partition partition2 = new Partition(width2, basePartition.getHeight(), leftCorner2);

            returnList[0] = partition1;
            returnList[1] = partition2;

            return returnList;
        }

    }

    /** Splits the given partition horizontally with a random chosen point in the y axis
     * @return - list of the 2 new Partition objects
     */
    public Partition[] horizontalSplit() {
        Partition[] returnList = new Partition[2];
        Partition basePartition = this;
        int breakPoint = getBaseParameters().getRandomGenerator().nextInt(basePartition.getHeight());

        double ratio = (double) breakPoint / this.getHeight();

        if((ratio < 0.40) || (ratio > 0.60)) {
            return this.horizontalSplit();
        } else {

            Point leftCorner1 = basePartition.getLeftCorner();
            Point leftCorner2 = new Point(basePartition.getLeftCorner().getX(), basePartition.getLeftCorner().getY() + breakPoint);

            int height1 = leftCorner2.getY() - leftCorner1.getY();
            int height2 = basePartition.getHeight() - breakPoint;

            Partition partition1 = new Partition(basePartition.getWidth(), height1, leftCorner1);
            Partition partition2 = new Partition(basePartition.getWidth(), height2, leftCorner2);

            returnList[0] = partition1;
            returnList[1] = partition2;

            return returnList;
        }
    }

    public Room createRoom() {
        int roomWidth = Parameters.MIN_ROOM_SIZE + getBaseParameters().getRandomGenerator().
                                                                nextInt(this.width - 5);
        int roomHeight = Parameters.MIN_ROOM_SIZE + getBaseParameters().getRandomGenerator().
                                                                nextInt(this.height - 5);
        int xCoordinate = this.getLeftCorner().getX() + getBaseParameters().getRandomGenerator()
                                                                .nextInt(this.width - roomWidth);
        int yCoordinate = this.getLeftCorner().getY() + getBaseParameters().getRandomGenerator()
                                                                .nextInt(this.height - roomHeight);

        Room newRoom = new Room(roomWidth, roomHeight, new Point(xCoordinate, yCoordinate));

        return newRoom;
    }
}