package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

import static byog.Core.Parameters.getBaseParameters;

public class startScreen {

    private boolean newGame;

    private char newGameCommand = 'N';
    private char quitGameCommand = 'Q';
    private char startGameCommand = 'S';

    Point centre = new Point(Parameters.WIDTH / 2, Parameters.HEIGHT / 2);
    private Font bigFont = new Font("Monaco", Font.BOLD, 35);
    private Font mediumFont  = new Font("Monaco", Font.BOLD, 20);
    private Font smallFont = new Font("Monaco", Font.BOLD, 15);

    public startScreen() {

    }

    public void drawWelcomeScreen() {
        StdDraw.setPenColor(Color.white);
        StdDraw.setFont(this.bigFont);
        this.write("Frank The Possum", centre.getX(), centre.getY() + 10);

        StdDraw.setFont(this.mediumFont);
        this.write("(N)ew Game", centre.getX(), centre.getY());
        this.write("(Q)uit Game", centre.getX(), centre.getY() - 2);

        StdDraw.show();
    }

    public void drawSeedInputScreen(String userInput) {
            StdDraw.clear(Color.BLACK);
            StdDraw.setPenColor(Color.yellow);
            StdDraw.setFont(this.mediumFont);
            this.write("Input a 5 digit Seed for your unique world", centre.getX(), centre.getY() + 5);

            StdDraw.setPenColor(Color.white);
            StdDraw.setFont(this.smallFont);
            this.write("Use W, A, S, D to move the character", centre.getX(), centre.getY() - 8);

            StdDraw.setPenColor(Color.yellow);
            this.write(userInput, centre.getX(), centre.getY());
    }

    public void playerInput() {
        while (StdDraw.hasNextKeyTyped()) {
            char input = Character.toUpperCase(StdDraw.nextKeyTyped());
            System.out.println(input);
            if (input == newGameCommand) {
                this.newGame = true;
            } else if (input == quitGameCommand) {
                getBaseParameters().setQuitGame(true);
            }
        }
    }

    public void write(String s, int xPos, int yPos) {
        StdDraw.text(xPos, yPos, s);
        StdDraw.show();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public long solicitSeedInput() {
        String input = "";
        this.drawSeedInputScreen(input);

        while (input.length() < 5) {
            if (!StdDraw.hasNextKeyTyped()) {
                continue;
            }
            char key = StdDraw.nextKeyTyped();

            if (isNumeric(Character.toString(key))) {
                input += String.valueOf(key);
                this.drawSeedInputScreen(input);
            }
        }
        StdDraw.pause(500);
        return Long.parseLong(input);
    }

    
    public void initializeGame() {

        while (!this.newGame) {
            this.playerInput();
        }
        long typedSeed = this.solicitSeedInput();
        getBaseParameters().setSEED(typedSeed);
    }
}
