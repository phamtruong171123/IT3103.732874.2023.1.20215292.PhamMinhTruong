package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    public void start(Stage stage) throws Exception {
        Parent root;

        root = FXMLLoader.load(getClass().getResource("/hust/soict/globalict/javafx/Painter.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();

        // Kiểm tra URL của FXML
        java.net.URL resource = getClass().getResource("/hust/soict/globalict/javafx/Painter.fxml");
        if (resource != null) {
            System.out.println("FXML URL: " + resource.toString());
        } else {
            System.out.println("Không thể tìm thấy FXML URL");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
