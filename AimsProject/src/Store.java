import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemInStore; // lưu trữ các mặt hàng bằng danh sách liên kết
    private int amount;

    public Store() {
        itemInStore = new ArrayList<>();
        amount = 0;
    }

    public void addDVD(DigitalVideoDisc disc) {
        itemInStore.add(disc);
        amount++;
        System.out.println("Đĩa "+disc.getTitle()+" được thêm thành công!");
    }

    public void addDVD(DigitalVideoDisc... discs) {
        for (DigitalVideoDisc disc : discs) {
            itemInStore.add(disc);
            System.out.println("Đĩa "+disc.getTitle()+" được thêm thành công!");
            amount++;
        }
    }
    public void removeDVD(DigitalVideoDisc disc){
        itemInStore.remove(disc);
        amount--;
        System.out.println("Đã xóa đĩa "+disc.getTitle());
    }
    public void removeDVD(DigitalVideoDisc... discs){
        for(DigitalVideoDisc disc: discs){
            itemInStore.remove(disc);
            amount--;
            System.out.println("Đã xóa đĩa "+disc.getTitle());
        }
    }
    public void printStore(){
        System.out.println("*******************************Store*******************************");
        for(DigitalVideoDisc disc:itemInStore){
            System.out.println(disc.toString());
        }
        System.out.println("*******************************************************************");
    }

    public static void main(String[] args){
        Store store=new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        store.addDVD(dvd1,dvd2,dvd3);
        store.printStore();
        store.removeDVD(dvd2);
        store.printStore();
    }
   
}
