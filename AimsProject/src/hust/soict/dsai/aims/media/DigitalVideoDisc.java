package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{
  
    private int length;
    private String director;
    private static int nbDigitalVideoDisc=0;
    public DigitalVideoDisc(String title) {
        super(title);
       }


    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        this.id=nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) {
       super(title,category,cost);
       this.director=director;
       this.id=nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title,category,cost);
        this.director=director;
        this.length=length;
        this.id=nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DVD - ");
        
        if (super.getTitle() != null) {
            builder.append(super.getTitle());
        }
        builder.append(" - ");
        
        if (super.getCategory() != null) {
            builder.append(super.getCategory());
        }
        builder.append(" - ");
        
        if (director != null) {
            builder.append(director);
        }
        builder.append(" - ");
        
        if (length > 0) {
            builder.append(length).append(" minutes");
        }
        builder.append(": ");
        
        if (super.getCost() >= 0) {
            builder.append(String.format("%.2f $", super.getCost()));
        }
    
        return builder.toString();
    }
    

    public int getID(){
        return id;
    }
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    } 
    public void play(){
        System.out.println("Playing DVD: "+this.getTitle());
        System.out.println("DVD length: "+this.getLength());
        System.out.println("Category: " + getCategory());
        System.out.println("Director: " + getDirector());
        System.out.println("Cost: " + getCost() + " $");
    }

}