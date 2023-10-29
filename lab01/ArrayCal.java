import java.util.Arrays;

public class ArrayCal {
    public static void main(String[] args) {
        double[] numbers = {1234, 1000, 5000, 2000, 10000}; // Mảng các số

        // Sắp xếp mảng theo thứ tự tăng dần
        Arrays.sort(numbers);

        System.out.println("Mảng đã sắp xếp: " + Arrays.toString(numbers));

        // Tính tổng của các phần tử trong mảng
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        System.out.println("Tổng của các phần tử trong mảng: " + sum);

        // Tính giá trị trung bình của các phần tử trong mảng
        double average = sum / numbers.length;
        System.out.println("Giá trị trung bình của các phần tử trong mảng: " + average);
    }
}
