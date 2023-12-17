package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
public class StoreScreen extends JFrame {
    
    private Store store;
    private Cart cart;

    public StoreScreen(Store store,Cart cart) {
        this.cart=cart;
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

    public class MediaStore extends JPanel{
    private Media media;
   
    
    public MediaStore(Media media){
        this.media=media;
     
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container=new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton add=new JButton("Add to cart");
        container.add(add);
        add.addActionListener(new AddToCartButtonListener());
        
        if(media instanceof Playable){
            JButton play=new JButton("Play");
            container.add(play);
            play.addActionListener(new PlayButtonListener());
            
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createHorizontalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class AddToCartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           JDialog  notify=createNotify(media);
           notify.setVisible(true);
           cart.addMedia(media);
        }
    }
    private JDialog createNotify(Media media){
        JDialog notify=new JDialog((Dialog)null,"Thông báo",true);
        JLabel label=new JLabel("Đã thêm thành công media: "+media.getTitle());
        label.setAlignmentX(CENTER_ALIGNMENT);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label,BorderLayout.CENTER);
        
        

        notify.add(panel);
        notify.setSize(300, 150); 
        notify.setLocationRelativeTo(null); 
        notify.setVisible(true);

        return notify;
    }

    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           JDialog play=createPlayDialog(media);
           play.setVisible(true);
          
        }
    }

    private JDialog createPlayDialog(Media media) {
        JDialog playDialog = new JDialog((Dialog)null, "Play Media", true);
        
        playDialog.add(new JPanel().add(createPlayMessage(media)));
        playDialog.setSize(300, 200);
        playDialog.setLocationRelativeTo(MediaStore.this);
        return playDialog;
    }
    private JPanel createPlayMessage(Media media) {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea=new JTextArea(((Playable)media).play());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        return panel;
    }

    public static void main(String[] args) {
        
    }
  


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
        JMenuItem viewcart=new JMenuItem("View cart");
        viewcart.addActionListener(new ViewCartListener());
        menu.add(viewcart);
        

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
                     AddDigitalVideoDiscToStoreScreen dvd = new AddDigitalVideoDiscToStoreScreen();
        dvd.showGUI(); 
        dispose(); 
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
        cart.addActionListener(new ViewCartListener());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    private class ViewCartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            navigateToCartScreen();
            
        }
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemInStore();
        for (int i = 0; i < 9 ; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            
            center.add(cell);
            
        }
        return center;
    }

    public void navigateToCartScreen() {
        CartScreen cartScreen = new CartScreen(cart);
        cartScreen.showGUI(); 
        dispose();  
    }
   

    public static void main(String[] args) {
        Store store=new Store();
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


        store.addMedia(dvd1);
      //  store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        //store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        //store.addMedia(book2);
        store.addMedia(book3);
    
        Cart cart=new Cart();
       StoreScreen s= new StoreScreen(store,cart);
       
       for (Media media : s.cart.getItemOrdered()) {
        System.out.println(media.toString());
    }
        
    }
}
