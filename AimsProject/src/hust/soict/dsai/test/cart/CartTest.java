package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;


public class CartTest {
    public static void main(String[] args) {
        Cart cart=new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);

        cart.addDigitalVideoDisc(dvd1,dvd2,dvd3);
        cart.printCart();
        cart.Search("Avenger");
        Store store=new Store();
        store.addDVD(dvd1,dvd2,dvd3);
        store.removeDVD(dvd2);
    }
}