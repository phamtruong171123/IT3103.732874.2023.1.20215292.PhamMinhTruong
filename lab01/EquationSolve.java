import java.util.Scanner;

public class EquationSolve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Giải Phương Trình:");
        System.out.println("1. Giải phương trình bậc nhất (ax + b = 0)");
        System.out.println("2. Giải hệ phương trình bậc nhất (ax1 + bx2 = c và dx1 + ex2 = f)");
        System.out.println("3. Giải phương trình bậc hai (ax^2 + bx + c = 0)");
        System.out.print("Nhập lựa chọn của bạn (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveFirstDegreeEquation(); // Gọi hàm giải phương trình bậc nhất
                break;
            case 2:
                solveSystemOfFirstDegreeEquations(); // Gọi hàm giải hệ phương trình bậc nhất
                break;
            case 3:
                solveSecondDegreeEquation(); // Gọi hàm giải phương trình bậc hai
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1, 2 hoặc 3.");
        }

        scanner.close();
    }

    // Hàm giải phương trình bậc nhất
    public static void solveFirstDegreeEquation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị của a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập giá trị của b: ");
        double b = scanner.nextDouble();

        if (a != 0) {
            double x = -b / a;
            System.out.println("Nghiệm của phương trình là x = " + x);
        } else if (b == 0) {
            System.out.println("Phương trình có vô số nghiệm.");
        } else {
            System.out.println("Phương trình không có nghiệm.");
        }
    }

    // Hàm giải hệ phương trình bậc nhất
    public static void solveSystemOfFirstDegreeEquations() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị của a11, a12, b1, a21, a22, và b2 (cách nhau bởi dấu cách): ");
        double a11 = scanner.nextDouble();
        double a12 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double a21 = scanner.nextDouble();
        double a22 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Nghiệm của hệ phương trình là x1 = " + x1 + " và x2 = " + x2);
        } else if (D1 == 0 && D2 == 0) {
            System.out.println("Hệ phương trình có vô số nghiệm.");
        } else {
            System.out.println("Hệ phương trình không có nghiệm.");
        }
    }

    // Hàm giải phương trình bậc hai
    public static void solveSecondDegreeEquation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị của a, b, và c (cách nhau bởi dấu cách): ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("Đây không phải là phương trình bậc hai.");
        } else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Nghiệm của phương trình là x1 = " + x1 + " và x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Nghiệm kép là x = " + x);
        } else {
            System.out.println("Phương trình không có nghiệm thực.");
        }
    }
}
