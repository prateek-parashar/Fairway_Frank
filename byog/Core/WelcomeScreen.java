package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

import static byog.Core.Parameters.getBaseParameters;

public class WelcomeScreen {

    private boolean newGame;

    private Font bigFont = new Font("Monaco", Font.BOLD, 30);
    private Font mediumFont  = new Font("Monaco", Font.BOLD, 20);
    private Font smallFont = new Font("Monaco", Font.BOLD, 10);

    public WelcomeScreen() {

    }

    public void drawWelcomeScreen() {
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
        StdDraw.show();
    }

    public void playerInput() {
        while (StdDraw.hasNextKeyTyped()) {
            char input = Character.toUpperCase(StdDraw.nextKeyTyped());
            System.out.println(input);
            if (input == 'N') {
                this.newGame = true;
            }
        }
    }
}
