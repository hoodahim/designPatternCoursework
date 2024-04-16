import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;

import java.awt.*;

public class ForestView extends Application {
    private static final int TERRAIN_SIZE = 90;
    private ForestController controller = new ForestController("wildernessMap");
    private final int CANVAS_WIDTH = controller.getGridWidth() * TERRAIN_SIZE;
    private final int CANVAS_HEIGHT = controller.getGridHeight() * TERRAIN_SIZE;
    private Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    @Override
    public void start(Stage stage){
        StackPane pane = new StackPane();
        pane.getChildren().add(canvas);
        stage.setScene(new Scene(pane));
        stage.setTitle("Forest Map Generator");
        stage.show();
        drawTrees();
    }

    private void drawTrees() {
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        for (int i = 0; i < controller.getGridHeight(); i++) {
            for (int j = 0; j < controller.getGridWidth(); j++) {
                Image imageToDraw = controller.getTerrainImage(i, j);
                gc.drawImage(imageToDraw, j * TERRAIN_SIZE, i * TERRAIN_SIZE, TERRAIN_SIZE, TERRAIN_SIZE);
            }
        }
    }

}
