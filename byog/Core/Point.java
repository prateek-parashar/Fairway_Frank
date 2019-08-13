package byog.Core;

public class Point {
    private int x;
    private int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /** Returns true if 2 point lie in a vertical line */

    public static boolean onVerticalLine(Point p1, Point p2) {
        return (p1.getX() - p2.getX()) == 0;
    }

    /** Returns true if 2 point lie in a horizontal line */

    public static boolean onHorizontalLine(Point p1, Point p2) {
        return (p1.getY() - p2.getY()) == 0;
    }

    /** Method to check if a point lies in the given room floor */
    public boolean liesInRoom(Room r) {
        if ((this.getX() > r.getLeftCorner().getX() + 1 &&
                (this.getX() < (r.getLeftCorner().getX() - 1) + r.getWidth()))) {
            if ((this.getY() > r.getLeftCorner().getY() + 1) &&
                    (this.getY() < (r.getLeftCorner().getY() - 1) + r.getHeight())) {
                return true;
            }
        } return false;
    }

    public void updateUp() {
        int newY = this.getY() + 1;
        this.setY(newY);
    }

    public void updateDown() {
        int newY = this.getY() - 1;
        this.setY(newY);
    }

    public void updateLeft() {
        int newX = this.getX() - 1;
        this.setX(newX);
    }

    public void updateRight() {
        int newX = this.getX() + 1;
        this.setX(newX);
    }
}
