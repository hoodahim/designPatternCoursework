package maps;

import terrainTypes.Tile;

public interface Map {
    public Tile createTile();

    public char display();
}
