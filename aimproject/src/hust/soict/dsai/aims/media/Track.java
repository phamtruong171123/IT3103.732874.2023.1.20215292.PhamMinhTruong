package hust.soict.dsai.aims.media;

import java.util.*;
public class Track implements Playable{
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public String play(){
        String content="Playing Track: "+this.getTitle()+" length: "+ this.getLength();
     return content;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Track otherTrack = (Track) obj;
        return Objects.equals(title, otherTrack.title) && length == otherTrack.length;
    }
}
