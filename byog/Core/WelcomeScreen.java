package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

import static byog.Core.Parameters.getBaseParameters;

public class WelcomeScreen {
    private Font bigFont = new Font("Monaco", Font.BOLD, 30);
    private Font mediumFont  = new Font("Monaco", Font.BOLD, 20);
    private Font smallFont = new Font("Monaco", Font.BOLD, 10);

    public WelcomeScreen() {

    }

    public void initialiseWelcomeScreen() {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(Color.white);
        StdDraw.setFont(this.bigFont);
        StdDraw.text(getBaseParameters().getBaseWorld().getCentre().getX(),
                getBaseParameters().getBaseWorld().getCentre().getY() + 10,
                "Frank the Possum");
        StdDraw.setFont(this.mediumFont);
        StdDraw.text(getBaseParameters().getBaseWorld().getCentre().getX(),
                getBaseParameters().getBaseWorld().getCentre().getY(),
                "N for New Game");
        StdDraw.text(getBaseParameters().getBaseWorld().getCentre().getX(),
                getBaseParameters().getBaseWorld().getCentre().getY() - 2,
                "L to Load Game");
        StdDraw.text(getBaseParameters().getBaseWorld().getCentre().getX(),
                getBaseParameters().getBaseWorld().getCentre().getY() - 4,
                "Q to Quit Game");

        StdDraw.show();
    }
}
