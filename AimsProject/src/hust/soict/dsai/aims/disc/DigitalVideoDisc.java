package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private  String title;
    private  String category;
    private  String director;
    private int length;
        private  float cost;
        private static int nbDigitalVideoDisc=0;
        private int id;

    
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id=nbDigitalVideoDisc;
        nbDigitalVideoDisc+=1;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
         this.id=nbDigitalVideoDisc;
        nbDigitalVideoDisc+=1;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
         this.id=nbDigitalVideoDisc;
        nbDigitalVideoDisc+=1;
    }
    

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
         this.id=nbDigitalVideoDisc;
        nbDigitalVideoDisc+=1;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DVD - ");
        
        if (title != null) {
            builder.append(title);
        }
        builder.append(" - ");
        
        if (category != null) {
            builder.append(category);
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
        
        if (cost >= 0) {
            builder.append(String.format("%.2f $", cost));
        }
    
        return builder.toString();
    }
    

    public int getID(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }


  

}