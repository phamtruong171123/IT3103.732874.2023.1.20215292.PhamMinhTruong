package hust.soict.dsai.aims.cart;

import java.util.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {

    private ArrayList<Media> itemOrdered;
    public Cart(){
        itemOrdered=new ArrayList<Media>();
    }
    
    public void addMedia(Media media){
        if(!itemOrdered.contains(media)){
            itemOrdered.add(media);
            System.out.println("Đã thêm thành công");
        }else{
            System.out.println("Đã tồn tại!");
        }
    }

    public void removeMedia(Media media){
        if(itemOrdered.contains(media)){
            itemOrdered.remove(media);
            System.out.println("Đa xóa thành công!");
        }else{
            System.out.println("Không thể xóa!");
        }
    } 

    public float totalCost() {
        float total = 0;
        for(Media media:itemOrdered){
            total+=media.getCost();
        }
        return total;
    } 
    
    
  /*   public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] != null) {
                System.out.printf("%d. %s\n", (i + 1), itemsOrdered[i].toString());
            }
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    } */
/* 
    public void Search(int id) {
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getID() == id) { // nếu thấy
                System.out.print("TÌm thấy thành công: ");
                System.out.println(itemsOrdered[i].toString()); // in ra thông tin đĩa
                return;
            }
        }
        System.out.println("Không tìm thấy đĩa");
        
    } */
    public Media Search(String title){
        for(Media media: itemOrdered){
            if(media.getTitle().equals(title)) return media;
        }
        return null;
    }
     public void printCart(){
        for(Media media:itemOrdered){
            System.out.println(media.toString());
        }
        System.out.println("Total cost is: " + totalCost()); //in ra tổng tiền trong giỏ hàng;
   
    } 
    
   
    
    

    public static void main(String[] args) {
        Cart anOrder = new Cart();
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        Media dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        anOrder.addMedia(dvd3); // thêm dvd1
        anOrder.addMedia(dvd1); //them dvd2
        anOrder.addMedia(dvd2); //thêm dvd3
        //anOrder.removeDigitalVideoDisc(dvd2); // xóa đĩa 2
        
        anOrder.printCart();

       // anOrder.Search("Aladin");
    }

    public List<Media> getItemOrdered() {
        return itemOrdered;
    }
}