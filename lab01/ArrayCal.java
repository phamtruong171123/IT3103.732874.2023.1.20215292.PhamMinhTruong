import java.util.Arrays;

public class ArrayCal{
    public static void main(String[] args) {
        double[] numbers = {1234, 1000, 5000, 2000, 10000}; 

      
        Arrays.sort(numbers);

        System.out.println("Sorted array: " + Arrays.toString(numbers));

     
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        System.out.println("Sum of array elements: " + sum);

        
        double average = sum / numbers.length;
        System.out.println("Average value of array elements: " + average);
    }
}
