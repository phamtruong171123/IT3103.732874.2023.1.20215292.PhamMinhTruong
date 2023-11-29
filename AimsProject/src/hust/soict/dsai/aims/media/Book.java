package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
   
    private List<String> author = new ArrayList<String>();
    private static int nbBook=0;

    public List<String> getAuthor() {
        return author;
    }
    
    public Book(String title, String category, float cost) {
        super(title, category, cost);
        this.id=nbBook;
        nbBook++;
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
}
