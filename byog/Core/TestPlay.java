package byog.Core;

import static byog.Core.Parameters.getBaseParameters;

public class TestPlay {
    public static void main(String[] args) {
        long currentSeed = 64511135;
        getBaseParameters().setSEED(currentSeed);

        BSPTree gameTree = new BSPTree(getBaseParameters().getBaseWorld());
        gameTree.createPartitions(3);
        gameTree.drawPartitions();

        getBaseParameters().tileRenderer.initialize(80, 40);
        getBaseParameters().tileRenderer.renderFrame(getBaseParameters().world);

    }
}
