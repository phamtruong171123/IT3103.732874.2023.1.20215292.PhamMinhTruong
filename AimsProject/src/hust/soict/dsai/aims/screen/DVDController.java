package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class DVDController {
    private Store store;

    public DVDController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    private TextField categoryTextField;

    @FXML
    private TextField costTextField;

    @FXML
    private TextField directorTextField;

    @FXML
    private void initialize() {
     
    }
    @FXML
    private TextField titleTextField;

    @FXML
    private void handleAddDVD(ActionEvent event) {
        String director = directorTextField.getText();
        String category = categoryTextField.getText();
        String title = titleTextField.getText();
        float cost = Float.parseFloat(costTextField.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(director, category, title, cost);

       store.addMedia(dvd);
    }
}
