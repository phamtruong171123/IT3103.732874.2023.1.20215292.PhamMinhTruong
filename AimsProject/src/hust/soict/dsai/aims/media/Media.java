package hust.soict.dsai.aims.media;

public abstract class Media {
    protected int id;
    private   String title;
    private  String category;
    private  float cost;
   

    public String getTitle() {
        return title;
    }

    public Media(String title) {
        this.title = title;
        
       
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
      
    }
    

  
}
