package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemInStore; // lưu trữ các mặt hàng bằng danh sách liên kết
   

    public Store() {
        itemInStore = new ArrayList<Media>();
       
    }

    public void addDVD(Media media) {
        itemInStore.add(media);
       
        System.out.println("Đĩa "+media.getTitle()+" được thêm thành công!");
    }

    public void addMedia(Media... medias) {
        for (Media media : medias) {
            itemInStore.add(media);
            System.out.println("Đĩa "+media.getTitle()+" được thêm thành công!");
            
        }
    }
    public void removeMedia(Media media){
        itemInStore.remove(media);
      
        System.out.println("Đã xóa đĩa "+media.getTitle());
    }
    public void removeMedia(Media... medias){
        for(Media media: medias){
            itemInStore.remove(media);
         
            System.out.println("Đã xóa đĩa "+media.getTitle());
        }
    }
    public void printStore(){
        System.out.println("*******************************Store*******************************");
        for(Media media:itemInStore){
            System.out.println(media.toString());
        }
        System.out.println("*******************************************************************");
    }

    public static void main(String[] args){
        Store store=new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        store.addMedia(dvd1,dvd2,dvd3);
        store.printStore();
        store.removeMedia(dvd2);
        store.printStore();
    }
   
}