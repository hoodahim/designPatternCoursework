package maps;

import terrainTypes.*;

import java.util.Random;

public class WildernessMap implements Map{

    @Override
    public Tile createTile() {
        Random random = new Random();
        int randomNumber = random.nextInt(3)+1;
        if (randomNumber == 1) {
            return new Swamp();
        } else if (randomNumber == 2) {
            return new Forest();
        } else return new Water();

    }

    @Override
    public char display() {
        return createTile().getCharacter();
    }
}
