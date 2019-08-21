package byog.Core;

import static byog.Core.Parameters.getBaseParameters;

public class Hallway {
    private Point start;
    private Point end;
    private int length;

    public Hallway() {

    }

    public Hallway(Point start, Point end) {
        this.start = start;
        this.end = end;

        if (Point.onHorizontalLine(start, end)) {
            this.length = end.getX() - start.getX();
        } else if (Point.onVerticalLine(start, end)) {
            this.length = end.getY() - start.getY();
        }
    }

    public Point getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "Hallway{" +
                "start=" + start +
                ", end=" + end +
                ", length=" + length +
                '}';
    }

    /**
     * Checks to see if the 2 given points are on a vertical or horizontal line and then
     * correspondingly draws the wall tiles with a single tile width
     */
    public void drawHallway() {
        if (Point.onHorizontalLine(this.start, this.end)) {
            this.drawHorizontalHallway();
        } else if (Point.onVerticalLine(this.start, this.end)) {
            this.drawVerticalHallway();
        }
    }

    /**
     * Checks to see if the 2 given points are on a vertical or horizontal line and then
     * correspondingly fills the wall boundaries with floor tiles
     */
    public void fillHallway() {
        if (Point.onHorizontalLine(this.start, this.end)) {
            this.fillHorizontalHallway();
        } else if (Point.onVerticalLine(this.start, this.end)) {
            this.fillVerticalHallway();
        }
    }

    private void drawHorizontalHallway() {
        for (int x = start.getX(); x < end.getX(); x++) {
            getBaseParameters().getWorld()[x][this.getStart().getY() + 1] = getBaseParameters().getWall();
        }

        for (int x = start.getX(); x < end.getX(); x++) {
            getBaseParameters().getWorld()[x][this.getStart().getY() - 1] = getBaseParameters().getWall();
        }
    }

    private void drawVerticalHallway() {
        for (int y = start.getY(); y < end.getY(); y++) {
            getBaseParameters().getWorld()[this.getStart().getX() + 1][y] = getBaseParameters().getWall();
        }

        for (int y = start.getY(); y < end.getY(); y++) {
            getBaseParameters().getWorld()[this.getStart().getX() - 1][y] = getBaseParameters().getWall();
        }
    }

    private void fillHorizontalHallway() {
        for (int x = start.getX(); x < end.getX(); x++) {
            getBaseParameters().getWorld()[x][this.getStart().getY()] = getBaseParameters().getFloor();
        }
    }

    public void fillVerticalHallway() {
        for (int y = start.getY(); y < end.getY(); y++) {
            getBaseParameters().getWorld()[this.getStart().getX()][y] = getBaseParameters().getFloor();
        }
    }

}


