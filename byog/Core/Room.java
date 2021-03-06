package byog.Core;

import static byog.Core.Parameters.getBaseParameters;

public class Room {
    private int width;
    private int height;
    private Point leftCorner;

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

    public int getHeight() {
        return height;
    }

    public Point getLeftCorner() {
        return leftCorner;
    }

    @Override
    public String toString() {
        return "Room{" +
                "width=" + width +
                ", height=" + height +
                ", leftCorner=" + leftCorner +
                '}';
    }

    /**
     * Used to draw the current room
     * First we fill the entire room with Wall tiles and then
     * we fill the room with floor tiles leaving the boundary walls intact
     */
    public void drawRoom() {
        for (int i = this.getLeftCorner().getX(); i < this.getWidth() + this.getLeftCorner().getX(); i++) {
            for (int j = this.getLeftCorner().getY(); j < this.getHeight() + this.getLeftCorner().getY(); j++) {
                getBaseParameters().getWorld()[i][j] = getBaseParameters().getWall();
            }
        }

        for (int i = getLeftCorner().getX() + 1; i < this.getWidth() + this.getLeftCorner().getX() - 1; i++) {
            for (int j = this.getLeftCorner().getY() + 1; j < this.getHeight() + this.getLeftCorner().getY() - 1; j++) {
                getBaseParameters().getWorld()[i][j] = getBaseParameters().getFloor();
            }
        }
    }

}
