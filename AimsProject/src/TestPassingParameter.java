public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD=new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD=new DigitalVideoDisc("Cinderella");

        swap(jungleDVD,cinderellaDVD);
        System.out.println("Jungle dvd title: "+jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
       // changeTitle(jungleDVD,cinderellaDVD.getTitle());
        System.out.println("Jungle dvd title: "+jungleDVD.getTitle());
    }
    public static void swap(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        DigitalVideoDisc temp=new DigitalVideoDisc(dvd1.getTitle()); // tạo dvd temp=dvd1
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(temp.getTitle());

    }
  /*   public static void changeTitle(DigitalVideoDisc dvd,String title){
        String oldTitle=dvd.getTitle();
        dvd.setTitle(title);
        dvd=new DigitalVideoDisc(oldTitle);
    } */
}
