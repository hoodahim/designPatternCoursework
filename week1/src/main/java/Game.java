import maps.CityMap;
import maps.Map;
import maps.WildernessMap;

public class Game {
    public void main(String mapType){
        Map  map = createMap(mapType);
        System.out.println(map.mapTitle());
        for(int i=0; i<5;i++){
            for(int j=0;j<=5;j++){
                map.createTile();
                System.out.print(map.display() );
            }
            System.out.println();
        }
    }

    public Map createMap(String mapType) {
        if (mapType.equalsIgnoreCase("cityMap")){
            return new CityMap();
        }
        else return new WildernessMap();
    }
}
