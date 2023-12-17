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

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.*;

public class MediaStore extends JPanel{
    private Media media;
    private boolean isAdded;
    
    public MediaStore(Media media){
        this.media=media;
        isAdded=false;
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
            isAdded=true;
       
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
    public boolean getIsAdded() {
        return isAdded;
    }


}
