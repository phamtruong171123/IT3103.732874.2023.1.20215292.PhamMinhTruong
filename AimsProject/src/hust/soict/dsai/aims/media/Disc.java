package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Disc extends Media{
    private int length;
    private String director;
    private String artist;
    private List<Track> tracks= new ArrayList<Track>();
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Disc(String title){
        super(title);
    }
 
    public String getArtist() {
        return artist;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    
    }
    

