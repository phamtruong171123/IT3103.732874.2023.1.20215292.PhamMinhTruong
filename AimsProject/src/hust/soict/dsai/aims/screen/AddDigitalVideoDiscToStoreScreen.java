package hust.soict.dsai.aims.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends Application {
    private static Store store;
    public AddDigitalVideoDiscToStoreScreen(){}
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        this.store = store;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDigitalVideoDiscToStoreScreen.fxml"));
        DVDController controller = new DVDController(store);
        loader.setController(controller);
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Add DVD to Store");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showGUI() {
        launch();
    }

    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Director 1", "Category 1", "DVD Title 1", 15.0f);
        store.addMedia(dvd1);
        AddDigitalVideoDiscToStoreScreen a=new AddDigitalVideoDiscToStoreScreen(store);
        a.showGUI();
    }
}
