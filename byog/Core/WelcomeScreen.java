package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class WelcomeScreen {

    private boolean newGame;
    Point centre = new Point(Parameters.WIDTH / 2, Parameters.HEIGHT / 2);
    private Font bigFont = new Font("Monaco", Font.BOLD, 30);
    private Font mediumFont  = new Font("Monaco", Font.BOLD, 20);
    private Font smallFont = new Font("Monaco", Font.BOLD, 18);

    public WelcomeScreen() {

    }

    public void drawWelcomeScreen() {
        StdDraw.clear(Color.BLACK);
        StdDraw.setPenColor(Color.white);
        StdDraw.setFont(this.bigFont);
        StdDraw.text(centre.getX(),
                centre.getY() + 10,
                "Frank the Possum");
        StdDraw.setFont(this.mediumFont);
        StdDraw.text(centre.getX(),
                centre.getY(),
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

    public void write(String s, Point p) {
        StdDraw.clear(Color.BLACK);
        StdDraw.text(centre.getX(),
                centre.getY() - 5,
                "Please enter a 5 digit Seed");
        this.drawWelcomeScreen();

        StdDraw.setPenColor(Color.white);
        
        StdDraw.setFont(this.smallFont);
        StdDraw.text(p.getX(), p.getY(), s);
        StdDraw.show();
    }

    public Long solicitSeedInput() {
        String input = "";
        this.write(input, new Point(centre.getX(), centre.getY() - 8));

        while (input.length() < 5) {
            if (!StdDraw.hasNextKeyTyped()) {
                continue;
            }
            char key = StdDraw.nextKeyTyped();
            input += String.valueOf(key);
            this.write(input, new Point(centre.getX(), centre.getY() - 8));
        }
        StdDraw.pause(500);
        return Long.parseLong(input);
    }

    
    public void initializeGame() {
        this.drawWelcomeScreen();
        while (!this.newGame) {
            this.playerInput();
        }
        long typedSeed = this.solicitSeedInput();
        System.out.println(typedSeed);
    }
}
