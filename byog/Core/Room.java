package byog.Core;

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

    public double roomRatio() {
        return this.getHeight() / this.getWidth();
    }

    public void drawRoom() {

    }
}


