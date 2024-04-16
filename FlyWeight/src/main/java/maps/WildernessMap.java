package maps;

import java.util.Random;

public class WildernessMap implements Map{

    @Override
    public TerrainType createTile() {
        Random random = new Random();
        int randomNumber = random.nextInt(3)+1;
        if (randomNumber == 1) {
            return TerrainType.SWAMP;
        } else if (randomNumber == 2) {
            return TerrainType.FOREST;
        } else return TerrainType.WATER;

    }
}
