import javafx.scene.image.Image;
import maps.CityMap;
import maps.Map;
import maps.TerrainType;
import maps.WildernessMap;

public class ForestController {
    private static final int GRID_WIDTH = 6;
    private static final int GRID_HEIGHT = 5;
    private Terrain[][] terrains;

    public ForestController(String mapType){
        Map map = createMap(mapType);
        terrains = new Terrain[GRID_HEIGHT][GRID_WIDTH];
        for (int i = 0; i < GRID_HEIGHT; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                terrains[i][j] = new Terrain(TerrainImageFactory.getTerrainImage(map.createTile()));
            }
        }
    }

    public Image getTerrainImage(int row, int col) {
        Terrain terrain = terrains[row][col];
        return terrain.getTerrainImage().getImage();
    }
    public int getGridWidth() {
        return GRID_WIDTH;
    }

    public int getGridHeight() {
        return GRID_HEIGHT;
    }

    public Map createMap(String mapType) {
        if (mapType.equalsIgnoreCase("cityMap")){
            return new CityMap();
        }
        else return new WildernessMap();
    }
}
