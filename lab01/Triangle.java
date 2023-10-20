import java.util.*;
public class Triangle{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        for(int i=1;i<=n;i++){
            for(int k=n-i;k>=0;k=k-1){
                System.out.print(" ");
            }
            for(int j=1;j<=2*(i-1)+1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
