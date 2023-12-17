package hust.soict.dsai.aims.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.dsai.aims.media.*;

import hust.soict.dsai.aims.cart.Cart;

public class CartScreen extends Application {

    private static Cart cart; 
     public void showGUI() {
        launch();} 
    public CartScreen() {
    
    }

    public CartScreen(Cart cart) {
        this.cart = cart;
        
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            CartScreenController controller = new CartScreenController(cart);
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("Cart");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Director 1", "Category 1", "DVD Title 1", 15.0f);
        CompactDisc cd1 = new CompactDisc("CD Title 1", "Category 1", 12.0f, "Artist 1");
        Book book1 = new Book("Book Title 1", "Category 1", 8.0f);
Cart cart=new Cart();
        cart = new Cart();
        cart.addMedia(dvd1);
        cart.addMedia(cd1);
        Track track1 = new Track("hello", 12);
        Track track3 = new Track("hello1", 13);
        Track track2 = new Track("hello2", 14);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);
        cart.addMedia(book1);
        CartScreen c=new CartScreen(cart);
        c.showGUI();
    }
}

