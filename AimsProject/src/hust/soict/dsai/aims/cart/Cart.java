package hust.soict.dsai.aims.cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import hust.soict.dsai.aims.media.*;

public class Cart {

    private ObservableList<Media> itemOrdered = FXCollections.observableArrayList();

    public Cart() {

    }

    public void addMedia(Media media) {
        if (!itemOrdered.contains(media)) {
            itemOrdered.add(media);
            System.out.println("Đã thêm thành công");
        } else {
            System.out.println("Đã tồn tại!");
        }
    }

    public void removeMedia(Media media) {
        if (itemOrdered.contains(media)) {
            itemOrdered.remove(media);
            System.out.println("Đã xóa thành công!");
        } else {
            System.out.println("Không thể xóa!");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public Media search(String title) {
        for (Media media : itemOrdered) {
            if (media.getTitle().equals(title)) return media;
        }
        return null;
    }

    public void printCart() {
        for (Media media : itemOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost is: " + totalCost()); // in ra tổng tiền trong giỏ hàng;

    }

    public static void main(String[] args) {
        Cart anOrder = new Cart();
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        Media dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addMedia(dvd3); // thêm dvd1
        anOrder.addMedia(dvd1); // them dvd2
        anOrder.addMedia(dvd2); // thêm dvd3
        //anOrder.removeDigitalVideoDisc(dvd2); // xóa đĩa 2

        anOrder.printCart();

        // anOrder.Search("Aladin");
    }

    public ObservableList<Media> getItemOrdered() {
    return itemOrdered;
}

}
