package hust.soict.dsai.aims.cart.Cart;
import java.util.*;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int amount = 0; // số lượng giỏ hàng khởi tạo =0

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (amount == MAX_NUMBERS_ORDERED) {
            System.out.println("Giỏ hàng đã đầy");
            return;
        }
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] == null) {  // thêm đĩa vào vị trí trống đầu tiên của mảng
                itemsOrdered[i] = disc;
                amount++;   // thêm số lượng lên 1
                System.out.println("Đĩa đã được thêm");
                break;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (amount == MAX_NUMBERS_ORDERED) {
                System.out.println("Giỏ hàng đã đầy, không thể thêm");
                return;
            }

            for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
                if (itemsOrdered[i] == null) {
                    itemsOrdered[i] = dvd;
                    amount++;
                    System.out.println("Đĩa " + dvd.getTitle() + " đã được thêm");
                    break; // Chuyển đến DVD tiếp theo
                }
            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].equals(disc)) {
                // Dịch các mục phía sau lên một vị trí để cho mảng gồm liên tục các đĩa
                for (int j = i; j < MAX_NUMBERS_ORDERED - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[MAX_NUMBERS_ORDERED - 1] = null; // Đặt giá trị cuối cùng thành null
                amount--;   // giảm số lượng trong giỏ hàng đi 1
                System.out.println("Đã xóa thành công");
                break;
            }
        }
    }
    

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] == null)
                continue; // Bỏ qua các mục có giá trị null hay là không tồn tại
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] != null) {
                System.out.printf("%d. %s\n", (i + 1), itemsOrdered[i].toString());
            }
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void Search(int id) {
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getID() == id) { // nếu thấy
                System.out.print("TÌm thấy thành công: ");
                System.out.println(itemsOrdered[i].toString()); // in ra thông tin đĩa
                return;
            }
        }
        System.out.println("Không tìm thấy đĩa");
        
    }
    public void Search(String title){
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getTitle().equals(title)) {
                System.out.print("TÌm thấy thành công :");
               System.out.println(itemsOrdered[i].toString()); //in ra thông tin đĩa
               return;
            }
        }
    System.out.println("Không tìm thấy đĩa");
    }
    
   
    
    

    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3); // thêm dvd1
        anOrder.addDigitalVideoDisc(dvd1); //them dvd2
        anOrder.addDigitalVideoDisc(dvd2); //thêm dvd3
        //anOrder.removeDigitalVideoDisc(dvd2); // xóa đĩa 2
        System.out.println("Total cost is: " + anOrder.totalCost()); //in ra tổng tiền trong giỏ hàng;
        anOrder.printCart();

        anOrder.Search("Aladin");
    }
}
