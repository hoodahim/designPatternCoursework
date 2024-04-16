import maps.TerrainType;

import java.util.EnumMap;
import java.util.Map;

public class TerrainImageFactory {
    private static final Map<TerrainType, TerrainImage> images = new EnumMap<>(TerrainType.class);

    public static TerrainImage getTerrainImage(TerrainType type) {
        TerrainImage image = images.get(type);
        if (image == null) {
            switch (type) {
                case BUILDING:
                    image = new TerrainImage("building.png");
                    break;
                case FOREST:
                    image = new TerrainImage("forest.png");
                    break;
                case ROAD:
                    image = new TerrainImage("road.png");
                    break;
                case SWAMP:
                    image = new TerrainImage("swamp.png");
                    break;
                case WATER:
                    image = new TerrainImage("water.png");
                    break;
            }
            images.put(type, image);
        }
        return image;
    }
}
