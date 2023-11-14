package hust.soict.globalict.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Dell\\OneDrive - Hanoi University of Science and Technology\\Documents\\Toán 12\\IT3103.732874.2023.1.20215292.PhamMinhTruong\\AimsProject\\src\\hust\\soict\\dsai\\aims\\cart\\Cart\\Cart.class";
        byte[] inputBytes;
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));

            // Sử dụng StringBuilder để giảm thiểu tạo "rác"
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            String outputString = outputStringBuilder.toString();
            endTime = System.currentTimeMillis();

            System.out.println("Time to read and concatenate bytes to String: " + (endTime - startTime) + " milliseconds");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
