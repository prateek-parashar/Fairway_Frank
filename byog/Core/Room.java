package byog.Core;

import java.util.ArrayList;
import java.util.List;

import static byog.Core.Parameters.getBaseParameters;

public class Room {
    private int height;
    private int width;
    private Point leftCorner;
    private Point centre = new Point(this.width / 2, this.height / 2);

    public Room() {

    }

    public Room(int height, int width, Point leftCorner) {
        this.height = height;
        this.width = width;
        this.leftCorner = leftCorner;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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
    public double roomRatio() {
        return this.getHeight() / this.getWidth();
    }

    /** Splits the given room vertically with a random chosen point in the x axis
     * @return - list of the 2 new Room objects
     */
    public Room[] verticalSplit() {
        Room[] returnList = new Room[1];
        Room baseRoom = this;
        int breakPoint = getBaseParameters().randomGenerator.nextInt(baseRoom.getWidth());

        Point leftCorner1 = baseRoom.getLeftCorner();
        Point leftCorner2 = new Point(baseRoom.getLeftCorner().getX() + breakPoint, baseRoom.getLeftCorner().getY());

        int width1 = leftCorner2.getX() - leftCorner1.getX();
        int width2 = baseRoom.getWidth() - breakPoint;

        Room room1 = new Room(baseRoom.getHeight(), width1, leftCorner1);
        Room room2 = new Room(baseRoom.getHeight(), width2, leftCorner2);

        if((room1.roomRatio() > 0.45) &&  (room2.roomRatio() > 0.45)) {
            returnList[0] = room1;
            returnList[1] = room2;
        }
        return this.verticalSplit();
    }

    /** Splits the given room horizontally with a random chosen point in the y axis
     * @return - list of the 2 new Room objects
     */
    public Room[] horizontalSplit() {
        Room[] returnList = new Room[1];
        Room baseRoom = this;
        int breakPoint = getBaseParameters().randomGenerator.nextInt(baseRoom.getWidth());

        Point leftCorner1 = baseRoom.getLeftCorner();
        Point leftCorner2 = new Point(baseRoom.getLeftCorner().getX(), baseRoom.getLeftCorner().getY() + breakPoint);

        int height1 = leftCorner2.getY() - leftCorner1.getY();
        int height2 = baseRoom.getHeight() - breakPoint;

        Room room1 = new Room(height1, baseRoom.getWidth(), leftCorner1);
        Room room2 = new Room(height2, baseRoom.getWidth(), leftCorner2);

        if((room1.roomRatio() > 0.45) &&  (room2.roomRatio() > 0.45)) {
            returnList[0] = room1;
            returnList[1] = room2;
        }
        return this.horizontalSplit();
    }

    /** Used to draw the current room with a Floor tile */
    public void drawRoom() {
        for (int i = this.getLeftCorner().getX(); i < this.getWidth(); i++) {
            for (int j = this.getLeftCorner().getY(); j < this.getHeight(); j++) {
                getBaseParameters().world[i][j] = getBaseParameters().getFloor();
            }
        }
    }

}


