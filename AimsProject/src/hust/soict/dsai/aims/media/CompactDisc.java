package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.Track;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks;
    private static int nbCD=0;
   

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
        this.id=nbCD;
        nbCD++;
    }

 

    public void displayInfo() {
        System.out.println("CD Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Artist: " + artist);
        System.out.println("Cost: " + getCost() + " $");
        System.out.println("CD Length: " + getCDLength() + " minutes");

        System.out.println("\nTracks:");

        for (Track track : tracks) {
            System.out.println("Track Title: " + track.getTitle());
            System.out.println("Track Length: " + track.getLength() + " minutes");
        }
    }

    

    private int getCDLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void addTrack(Track track){
        if(!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Track "+track.getTitle()+" đã được thêm thành công!");
        }else{
            System.out.println("Track" +track.getTitle()+" đã tồn tại!");
        }
    }
    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Đã xóa Track "+track.getTitle()+" thành công!");

        }
        else{
            System.out.println("Không thể xóa Track chưa tồn tại!");
        }
    }
        public int getLength(){
            int totalLength=0;
            for(Track track:tracks){
                totalLength+=track.getLength();
            }
            return totalLength;
        }

public void play(){
        System.out.println("CD Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Artist: " + artist);
        System.out.println("Director: " + getDirector());
        System.out.println("Cost: " + getCost() + " $");
        System.out.println("CD Length: " + getCDLength() + " minutes");
    
        
        System.out.println("\nTracks:");
        for (Track track : tracks) {
           track.play();
        }
    }
}

