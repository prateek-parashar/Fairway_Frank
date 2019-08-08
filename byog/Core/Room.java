package byog.Core;

import static byog.Core.Parameters.getBaseParameters;

public class Room {
    private int width;
    private int height;
    private Point leftCorner;
    private Point centre = new Point(this.width / 2, this.height / 2);

    public Room() {

    }

    public Room(int width, int height, Point leftCorner) {
        this.width = width;
        this.height = height;
        this.leftCorner = leftCorner;
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

    /** Returns the ratio of the height and width of the room */
    public double roomRatioHorizontal() {
        double x = (double)this.getHeight() / this.getWidth();
        return x;
    }

    public double roomRatioVertical() {
        double x = (double)this.getWidth() / this.getHeight();
        return x;
    }

    /** Splits the given room vertically with a random chosen point in the x axis
     * @return - list of the 2 new Room objects
     */
    public Room[] verticalSplit() {
        Room[] returnList = new Room[2];
        Room baseRoom = this;
        int breakPoint = getBaseParameters().randomGenerator.nextInt(baseRoom.getWidth());

        Point leftCorner1 = baseRoom.getLeftCorner();
        Point leftCorner2 = new Point(baseRoom.getLeftCorner().getX() + breakPoint, baseRoom.getLeftCorner().getY());

        int width1 = leftCorner2.getX() - leftCorner1.getX();
        int width2 = baseRoom.getWidth() - breakPoint;

        Room room1 = new Room(width1, baseRoom.getHeight(), leftCorner1);
        Room room2 = new Room(width2, baseRoom.getHeight(), leftCorner2);

        if((room1.roomRatioVertical() > 0.30) &&  (room2.roomRatioVertical() > 0.30)) {
            returnList[0] = room1;
            returnList[1] = room2;

            return returnList;
        } else {
            return this.verticalSplit();
        }
    }

    /** Splits the given room horizontally with a random chosen point in the y axis
     * @return - list of the 2 new Room objects
     */
    public Room[] horizontalSplit() {
        Room[] returnList = new Room[2];
        Room baseRoom = this;
        int breakPoint = getBaseParameters().randomGenerator.nextInt(baseRoom.getHeight());

        Point leftCorner1 = baseRoom.getLeftCorner();
        Point leftCorner2 = new Point(baseRoom.getLeftCorner().getX(), baseRoom.getLeftCorner().getY() + breakPoint);

        int height1 = leftCorner2.getY() - leftCorner1.getY();
        int height2 = baseRoom.getHeight() - breakPoint;

        Room room1 = new Room(baseRoom.getWidth(), height1, leftCorner1);
        Room room2 = new Room(baseRoom.getWidth(), height2, leftCorner2);

        if((room1.roomRatioHorizontal() > 0.30) &&  (room2.roomRatioHorizontal() > 0.30)) {
            returnList[0] = room1;
            returnList[1] = room2;

            return returnList;
        } else {
            return this.horizontalSplit();
        }
    }

    /** Used to draw the current room with a Floor tile */
    public void drawRoom() {
        for (int i = this.getLeftCorner().getX(); i < this.getWidth() + this.getLeftCorner().getX(); i++) {
            for (int j = this.getLeftCorner().getY(); j < this.getHeight() + this.getLeftCorner().getY(); j++) {
                getBaseParameters().getNumericWorld()[i][j] = 1;
                getBaseParameters().getWorld()[i][j] = getBaseParameters().getFloor();
                getBaseParameters().numberOfPaints += 1;
            }
        }
    }

}