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
            this.length = start.getX() - end.getX();
        } else if (Point.onVerticalLine(start, end)) {
            this.length = start.getY() - start.getY();
        }
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void drawHorizontalHallway() {
        for (int x = start.getX() ; x < length; x++) {
            getBaseParameters().getWorld()[x][this.getStart().getY() + 1] = getBaseParameters().getWall();
        }

        for (int x = start.getX() ; x < length; x++) {
            getBaseParameters().getWorld()[x][this.getStart().getY() - 1] = getBaseParameters().getWall();
        }
    }

    public void drawVericalHallway() {
        for (int y = start.getY() ; y < length; y++) {
            getBaseParameters().getWorld()[this.getStart().getX() + 1][y] = getBaseParameters().getWall();
        }

        for (int y = start.getY() ; y < length; y++) {
            getBaseParameters().getWorld()[this.getStart().getX() - 1][y] = getBaseParameters().getWall();
        }
    }

}


