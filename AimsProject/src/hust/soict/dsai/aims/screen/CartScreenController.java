package hust.soict.dsai.aims.screen;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;


public class CartScreenController {

    private Cart cart;
   
    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Label totalcost;
   

    private void updateTotalCost() {
        float total = cart.totalCost();
        totalcost.setText(  total + " $");
    }
 

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

      @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media=tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.setItems(this.cart.getItemOrdered());
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> Observable,Media oldValue,Media newValue){
                    if(newValue!=null){
                        updateButtonBar(newValue);
                    }
                }
            }
        );
        updateTotalCost();
      
    }
      public void updateButtonBar(Media media){
            btnRemove.setVisible(true);
            if(media instanceof Playable){
                btnPlay.setVisible(true);
            }else btnPlay.setVisible(false);
        }

        @FXML
        void btnPlaceOrderPressed(ActionEvent event) {
            showAlert("Order", "Successfull!");
            cart.getItemOrdered().clear();
            updateTotalCost();
        }
    
       
        @FXML
        void btnPlayPressed(ActionEvent event) {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media instanceof Playable) {
                showAlert("Music", ((Playable) media).play());
            }
        }
    
        private void showAlert(String title, String content) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();
        }

}
