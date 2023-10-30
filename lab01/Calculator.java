import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: "); // Nhập số thứ nhất từ bàn phím
        String strNum1 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1); // Chuyển đổi chuỗi thành số thực

        System.out.print("Nhập số thứ hai: "); // Nhập số thứ hai từ bàn phím
        String strNum2 = scanner.nextLine();
        double num2 = Double.parseDouble(strNum2); // Chuyển đổi chuỗi thành số thực

        double sum = num1 + num2; // Tính tổng
        double difference = num1 - num2; // Tính hiệu
        double product = num1 * num2; // Tính tích
        double quotient = 0.0; // Khởi tạo biến kết quả phép chia

        if (num2 != 0) { // Kiểm tra số thứ hai có khác 0 không
            quotient = num1 / num2; // Tính thương
        } else {
            System.out.println("Không được chia cho 0."); // In thông báo lỗi khi số thứ hai là 0
        }

        System.out.println("Tổng: " + sum); // In tổng
        System.out.println("Hiệu: " + difference); // In hiệu
        System.out.println("Tích: " + product); // In tích

        if (num2 != 0) { // Kiểm tra số thứ hai có khác 0 không
            System.out.println("Thương: " + quotient); // In thương
        }

        scanner.close(); // Đóng Scanner khi hoàn thành
    }
}
