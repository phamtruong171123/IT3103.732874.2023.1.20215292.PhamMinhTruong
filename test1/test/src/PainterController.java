import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup identical;

    private boolean isEraserMode = false;

    @FXML
    void drawButtonPressed(MouseEvent event) {
        isEraserMode = false;
    }

    @FXML
    void eraserButtonPressed(MouseEvent event) {
        isEraserMode = true;
    }
    @FXML
    void clearButtonPressed(MouseEvent event) {
        drawingAreaPane.getChildren().clear();
       
    }
    

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isEraserMode) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}
