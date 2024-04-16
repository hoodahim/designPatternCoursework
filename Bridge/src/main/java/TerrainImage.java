import javafx.scene.image.Image;

public class TerrainImage implements Flyweight{
    private final Image image;

    public TerrainImage(String imagePath) {
        this.image = new Image(imagePath);
    }

    @Override
    public Image getImage() {
        return image;
    }
}
