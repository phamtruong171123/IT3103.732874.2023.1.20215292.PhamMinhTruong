package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.*;
public class StoreScreen extends JFrame {
    
    private Store store;
    private List<Media> itemOrdered=new ArrayList<Media>();

    public StoreScreen(Store store) {
      
        this.store = store;
      
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        smUpdateStore.addActionListener(new UpdateStoreListener());

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class UpdateStoreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem source = (JMenuItem) e.getSource();
            String command = source.getText();
            
           
            switch (command) {
                case "Add Book":
                   
                    break;
                case "Add CD":
                    
                    break;
                case "Add DVD":
                   
                    break;
            }
        }
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Aims");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    private class ViewCartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        }
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemInStore();
        for (int i = 0; i < 9 ; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            if(cell.getIsAdded()==true){
               

                itemOrdered.add(mediaInStore.get(i));
                 System.out.println("Added to cart: " + mediaInStore.get(i).getTitle());
            }
            center.add(cell);
            
        }
        return center;
    }

   

    public static void main(String[] args) {
        Store store=new Store();
       // Cart cart=new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Director 1", "Category 1", "DVD Title 1", 15.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Director 2", "Category 2", "DVD Title 2", 20.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Director 3", "Category 3", "DVD Title 3", 25.0f);

        CompactDisc cd1 = new CompactDisc("CD Title 1", "Category 1", 12.0f, "Artist 1");
        CompactDisc cd2 = new CompactDisc("CD Title 2", "Category 2", 18.0f, "Artist 2");
        CompactDisc cd3 = new CompactDisc("CD Title 3", "Category 3", 22.0f, "Artist 3");
        Track track1 = new Track("hello", 12);
        Track track3 = new Track("hello1", 13);
        Track track2 = new Track("hello2", 14);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);

        Book book1 = new Book("Book Title 1", "Category 1", 8.0f);
        Book book2 = new Book("Book Title 2", "Category 2", 10.0f);
        Book book3 = new Book("Book Title 3", "Category 3", 14.0f);
        //Book book4 = new Book("Book Title 4", "Category 4", 16.0f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
     //   store.addMedia(book4);

       StoreScreen s= new StoreScreen(store);
       
           for(Media media : s.itemOrdered){
            System.out.println(media.toString());
           }
        
    }
}
