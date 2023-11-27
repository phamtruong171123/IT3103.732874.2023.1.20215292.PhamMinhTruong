package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book {
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
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
    public List<String> getAuthor() {
        return author;
    }
    public void setAuthor(List<String> author) {
        this.author = author;
    }
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> author = new ArrayList<String>();
}
