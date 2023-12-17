package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
    public int compare(Media media1, Media media2) {
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Nếu tiêu đề giống nhau, so sánh theo giá
        return Float.compare(media1.getCost(), media2.getCost());
    }
}

