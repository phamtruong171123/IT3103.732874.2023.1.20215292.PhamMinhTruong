import  javax.swing.JOptionPane;
public class ChosingOption{
    public static  void main(String[] args){
        int option=JOptionPane.showConfirmDialog(null,"Do you want to change the first class ticket");
        JOptionPane.showConfirmDialog(null,"You've chosen: "+(option==JOptionPane.YES_OPTION? "Yes":"No"));
        System.exit(0);
    }
}
