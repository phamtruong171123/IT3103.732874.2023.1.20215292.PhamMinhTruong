import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // Nhập chiều cao của tam giác từ người dùng

        // Vòng lặp chạy từ i = 1 đến n để tạo từng dòng của tam giác
        for (int i = 1; i <= n; i++) {
            // Vòng lặp để tạo khoảng trắng trước mỗi dòng
            for (int k = n - i; k >= 0; k--) {
                System.out.print(" ");
            }

            // Vòng lặp để tạo dấu '*' trên mỗi dòng
            for (int j = 1; j <= 2 * (i - 1) + 1; j++) {
                System.out.print("*");
            }

            System.out.println(""); // Xuống dòng để tạo dòng tiếp theo
        }
    }
}
