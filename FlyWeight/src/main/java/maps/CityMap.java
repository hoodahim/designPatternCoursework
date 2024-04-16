package maps;



import java.util.Random;

public class CityMap implements Map {
    @Override
    public TerrainType createTile() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        if (randomNumber == 1) {
            return TerrainType.ROAD;
        } else if (randomNumber == 2) {
            return TerrainType.FOREST;
        } else return TerrainType.BUILDING;
    }
}
