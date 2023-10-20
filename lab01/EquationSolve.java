import java.util.Scanner;

public class EquationSolve{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Equation Solver Menu:");
        System.out.println("1. Solve a first-degree equation (ax + b = 0)");
        System.out.println("2. Solve a system of first-degree equations (ax1 + bx2 = c and dx1 + ex2 = f)");
        System.out.println("3. Solve a second-degree equation (ax^2 + bx + c = 0)");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveFirstDegreeEquation();
                break;
            case 2:
                solveSystemOfFirstDegreeEquations();
                break;
            case 3:
                solveSecondDegreeEquation();
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }

        scanner.close();
    }

    public static void solveFirstDegreeEquation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = scanner.nextDouble();

        if (a != 0) {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        } else if (b == 0) {
            System.out.println("The equation has infinitely many solutions.");
        } else {
            System.out.println("The equation has no solution.");
        }
    }

    public static void solveSystemOfFirstDegreeEquations() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the values of a11, a12, b1, a21, a22, and b2 (space-separated): ");
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
            System.out.println("The solutions are x1 = " + x1 + " and x2 = " + x2);
        } else if (D1 == 0 && D2 == 0) {
            System.out.println("The system has infinitely many solutions.");
        } else {
            System.out.println("The system has no solution.");
        }
    }

    public static void solveSecondDegreeEquation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the values of a, b, and c (space-separated): ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("This is not a second-degree equation.");
        } else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The solutions are x1 = " + x1 + " and x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("The double root is x = " + x);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}
