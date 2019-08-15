package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

import static byog.Core.Parameters.getBaseParameters;

public class Player {
    private Point currentPosition;
    private Point previousPosition;
    private Point upPosition;
    private Point downPosition;
    private Point leftPosition;
    private Point rightPosition;

    public Player(Point startPosition) {
        this.currentPosition = startPosition;
        this.previousPosition = new Point(startPosition.getX(), startPosition.getY());
        this.upPosition = new Point(startPosition.getX(), startPosition.getY() + 1);
        this.downPosition = new Point(startPosition.getX(), startPosition.getY() - 1);
        this.leftPosition = new Point(startPosition.getX() - 1, startPosition.getY());
        this.rightPosition = new Point(startPosition.getX() + 1, startPosition.getY());

    }


    public void moveUp() {

        if (this.upPosition.liesOnWall()) {
            return;
        } else {
            this.previousPosition.updateHere(this.currentPosition);
            this.currentPosition.updateUp();
            this.upPosition.updateUp();
            this.downPosition.updateUp();
            this.leftPosition.updateUp();
            this.rightPosition.updateUp();
        }
    }

    public void moveDown() {
        if (this.downPosition.liesOnWall()) {
            return;
        } else {
            this.previousPosition.updateHere(this.currentPosition);
            this.currentPosition.updateDown();
            this.upPosition.updateDown();
            this.downPosition.updateDown();
            this.leftPosition.updateDown();
            this.rightPosition.updateDown();
        }
    }

    public void moveLeft() {
        if (this.leftPosition.liesOnWall()) {
            return;
        } else {
            this.previousPosition.updateHere(this.currentPosition);
            this.currentPosition.updateLeft();
            this.upPosition.updateLeft();
            this.downPosition.updateLeft();
            this.leftPosition.updateLeft();
            this.rightPosition.updateLeft();
        }
    }

    public void moveRight() {
        if (this.rightPosition.liesOnWall()) {
            return;
        } else {
            this.previousPosition.updateHere(this.currentPosition);
            this.currentPosition.updateRight();
            this.upPosition.updateRight();
            this.downPosition.updateRight();
            this.leftPosition.updateRight();
            this.rightPosition.updateRight();
        }
    }

    public void drawPlayer() {
        StdDraw.clear(Color.BLACK);
        getBaseParameters().getWorld()[this.previousPosition.getX()][this.previousPosition.getY()]
                                            = getBaseParameters().getFloor();
        getBaseParameters().getWorld()[this.currentPosition.getX()][this.currentPosition.getY()]
                                            = getBaseParameters().getPlayerTile();
        getBaseParameters().getTileRenderer().renderFrame(getBaseParameters().getWorld());
    }

    public void enableMovement() {
        StdDraw.enableDoubleBuffering();
        this.drawPlayer();
        while (StdDraw.hasNextKeyTyped()) {
            char move = Character.toUpperCase(StdDraw.nextKeyTyped());
            switch (move) {
                case 'W':
                    this.moveUp();
                    break;
                case 'A':
                    this.moveLeft();
                    break;
                case 'S':
                    this.moveDown();
                    break;
                case 'D':
                    this.moveRight();
                    break;
            }
            this.drawPlayer();
        }
    }
}
