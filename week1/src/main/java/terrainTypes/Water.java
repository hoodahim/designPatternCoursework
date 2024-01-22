package terrainTypes;

public class Water implements Tile{
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "Water";
    }
}
