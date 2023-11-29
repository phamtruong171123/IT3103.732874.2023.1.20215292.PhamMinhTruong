package hust.soict.dsai.aims.media;

import java.util.*;

public abstract class Media {
    protected int id;
    private   String title;
    private  String category;
    private  float cost;
    private static int nbMedia=0;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
    new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE=
    new MediaComparatorByCostTitle();
   

    public String getTitle() {
        return title;
    }

    public Media(String title) {
        this.title = title;
         this.id=nbMedia;
        nbMedia++;
       
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
       
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
         this.id=nbMedia;
        nbMedia++;
    }

 public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Media otherMedia = (Media) obj;
        return Objects.equals(title, otherMedia.title);
    }

  
    

  public static void main(String[] args) {
        List<Media> medias=new ArrayList<Media>();
        CompactDisc cd = new CompactDisc( "Lover", "Country", 20f, "TaylorSwift");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Hello", "Pop", 18f);
        Book book = new Book("Get richer","Selfhelf",5f);
        DigitalVideoDisc dvd1=new DigitalVideoDisc("Avenger","SuperHero",18f);
        medias.add(cd);
        medias.add(dvd);
        medias.add(book);
        medias.add(dvd1);

        Collections.sort(medias,Media.COMPARE_BY_COST_TITLE);
        for(Media media:medias){
            
            System.out.println(media.toString());
        }

  }
}
