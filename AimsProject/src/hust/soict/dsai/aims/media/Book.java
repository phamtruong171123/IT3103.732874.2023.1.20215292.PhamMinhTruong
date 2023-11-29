package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
   
    private List<String> author = new ArrayList<String>();
    

    public List<String> getAuthor() {
        return author;
    }
    
    public Book(String title, String category, float cost) {
        super(title, category, cost);
     
    }
    public Book(String title, String category, float cost,List<String> author){
        super(title, category, cost);
        this.author=author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }
    
    public void addAuthor(String authorName){
        if(!author.contains(authorName)){
        author.add(authorName);}
        else{
            System.out.println(authorName +" đã tồn tại!");
        }
    }
    public void removeAuthor(String authorName){
        if(author.contains(authorName)){
        author.remove(authorName);}
        else{
            System.out.println("Không thể xóa tác giả chưa tồn tại!");
        }
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book - ");

        if (super.getTitle() != null) {
            builder.append(super.getTitle());
        }
        builder.append(" - ");

        if (super.getCategory() != null) {
            builder.append(super.getCategory());
        }
        builder.append(" - ");

        if (super.getCost() >= 0) {
            builder.append(String.format("%.2f $", super.getCost()));
        }

        return builder.toString();
    }
}
