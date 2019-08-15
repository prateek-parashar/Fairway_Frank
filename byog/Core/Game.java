package byog.Core;

import java.util.Random;

import static byog.Core.Parameters.getBaseParameters;
import static byog.Core.TestPlay.splitAndGrow;


public class Game {
    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {
        getBaseParameters().getTileRenderer().initialize(getBaseParameters().getBaseWorld().getWidth(),
                getBaseParameters().getBaseWorld().getHeight());

        getBaseParameters().initializeWorld();

        getBaseParameters().getStartScreen().drawWelcomeScreen();
        getBaseParameters().getStartScreen().initializeGame();

        getBaseParameters().setRandomGenerator(new Random(getBaseParameters().getSEED()));

        BSPTree partitionTree = splitAndGrow(getBaseParameters().getBaseWorld(), 5);

        partitionTree.generateRooms();

        partitionTree.generateHallways();

        partitionTree.renderHallways(getBaseParameters().getFinalHallways());

        partitionTree.renderRooms(getBaseParameters().getFinalRooms());

        partitionTree.fillHallways(getBaseParameters().getFinalHallways());

        while (getBaseParameters().isBeginGame()) {
            getBaseParameters().getPlayer().enableMovement();
        }

    }
}
