package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

import static byog.Core.Parameters.getBaseParameters;

/** This class is used to demarcate the first screen that the user sees upon starting the game.
 * It contains the game loop to accept the user input for starting or to quit the game and it also acts as the
 * gateway to accept the Seed parameter from the user to randomly generate the world
 */
public class startScreen {

    private boolean newGame;
    private boolean quitGame;

    private char newGameCommand = 'N';
    private char quitGameCommand = 'Q';
    private char startGameCommand = 'S';

    Point centre = new Point(Parameters.WIDTH / 2, Parameters.HEIGHT / 2);
    private Font bigFont = new Font("Monaco", Font.BOLD, 35);
    private Font mediumFont  = new Font("Monaco", Font.BOLD, 20);
    private Font smallFont = new Font("Monaco", Font.BOLD, 15);

    public startScreen() {

    }

    /** Draws the Welcome screen on the StdDraw canvas with options for the user to choose from. */
    public void drawWelcomeScreen() {
        StdDraw.setPenColor(Color.white);
        StdDraw.setFont(this.bigFont);
        this.write("Frank The Possum", centre.getX(), centre.getY() + 10);

        StdDraw.setFont(this.mediumFont);
        this.write("(N)ew Game", centre.getX(), centre.getY());
        this.write("(Q)uit Game", centre.getX(), centre.getY() - 2);

        StdDraw.show();
    }

    /** Draws the screen in which the user inputs the Seed in the game */
    private void drawSeedInputScreen(String userInput) {
            StdDraw.clear(Color.BLACK);
            StdDraw.setPenColor(Color.yellow);
            StdDraw.setFont(this.mediumFont);
            this.write("Input a 5 digit Seed for your unique world", centre.getX(), centre.getY() + 5);

            StdDraw.setPenColor(Color.white);
            StdDraw.setFont(this.smallFont);
        this.write("Press 'S' to start the game", centre.getX(), centre.getY() - 6);
        this.write("Use W, A, S, D to move the character", centre.getX(), centre.getY() - 8);

            StdDraw.setPenColor(Color.yellow);
            this.write(userInput, centre.getX(), centre.getY());
    }

    /** Starts the loop to accept the user input.
     * It accepts only 3 charaters as valid namely the fields
     * newGameCommand which starts a new game
     * quitGameCommand which quits the system window
     * startGameCommand which is accepted only after the user chooses to start a new game and inputs the seed
     */
    private void playerInput() {
        while (StdDraw.hasNextKeyTyped()) {
            char input = Character.toUpperCase(StdDraw.nextKeyTyped());
            System.out.println(input);
            if (input == newGameCommand) {
                this.newGame = true;
            } else if (input == quitGameCommand) {
                this.quitGame = true;
                System.exit(0);
            } else if ((input == startGameCommand) && this.newGame) {
                getBaseParameters().setBeginGame(true);
            }
        }
    }

    /** Writes the given string at the requested coordinates on StdDraw canvas */
    private void write(String s, int xPos, int yPos) {
        StdDraw.text(xPos, yPos, s);
        StdDraw.show();
    }

    /** Checks to see if the input string consists exclusively of cardinal numbers */
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /** Initiates the loop which requests a 5 digit Cardinal number for each input pressed by the user
     * Upon receiving a valid input, the number is written on the screen to show the input to the user
     * @return --> 5 Digit input in long form
     */
    private long solicitSeedInput() {
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
        return Long.parseLong(input);
    }

    /** The go to method of the class which handles the transition from the welcome screen to the Seed
     * input and updates the Seed parameter in the Class Parameters.
     */
    public void initializeGame() {

        while (!this.newGame && !quitGame) {
            this.playerInput();
        }
        long typedSeed = this.solicitSeedInput();
        getBaseParameters().setSEED(typedSeed);
        while (!getBaseParameters().isBeginGame()) {
            this.playerInput();
        }
    }
}
