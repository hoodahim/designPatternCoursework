package maps;

import terrainTypes.Building;
import terrainTypes.Forest;
import terrainTypes.Road;
import terrainTypes.Tile;

import java.util.Random;

public class CityMap implements Map {
    @Override
    public Tile createTile() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        if (randomNumber == 1) {
            return new Road();
        } else if (randomNumber == 2) {
            return new Forest();
        } else return new Building();
    }

    @Override
    public char display() {
        return createTile().getCharacter();
    }
}
