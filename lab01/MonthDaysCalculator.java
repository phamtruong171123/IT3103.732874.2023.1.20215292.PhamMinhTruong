import java.util.Scanner;

public class MonthDaysCalculator {
   
    private static String[] months = {
        "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6",
        "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"
    };

    private static String[] monthAbbreviations = {
        "Thg 1", "Thg 2", "Thg 3", "Thg 4", "Thg 5", "Thg 6",
        "Thg 7", "Thg 8", "Thg 9", "Thg 10", "Thg 11", "Thg 12"
    };

    private static String[] monthShortNames = {
        "Th1", "Th2", "Th3", "Th4", "Th5", "Th6",
        "Th7", "Th8", "Th9", "Th10", "Th11", "Th12"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tháng và năm (Ví dụ, Tháng 1 2023 hoặc Th1 2023):");
        String input = scanner.nextLine().trim();

        int month = -1;
        int year = -1;

        while (true) {
            if (isValidInput(input)) {
                break;
            } else {
                System.out.println("Nhập không hợp lệ. Vui lòng nhập tháng và năm (Ví dụ, Tháng 1 2023 hoặc Th1 2023):");
                input = scanner.nextLine().trim();
            }
        }

        String[] inputParts = input.split(" ");
        for (int i = 0; i < months.length; i++) {
            if (inputParts[0].equalsIgnoreCase(months[i]) || inputParts[0].equalsIgnoreCase(monthAbbreviations[i]) || inputParts[0].equalsIgnoreCase(monthShortNames[i]) || inputParts[0].equals(String.valueOf(i + 1))) {
                month = i + 1;
                break;
            }
        }

        year = Integer.parseInt(inputParts[1]);

        int daysInMonth = getDaysInMonth(month, year);
        System.out.println("Tháng " + months[month - 1] + " năm " + year + " có " + daysInMonth + " ngày.");
    }

    // Hàm kiểm tra tính hợp lệ của đầu vào
    public static boolean isValidInput(String input) {
      
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            return false;
        }

        // Kiểm tra phần tháng
        for (int i = 0; i < 12; i++) {
            if (inputParts[0].equalsIgnoreCase(months[i]) || inputParts[0].equalsIgnoreCase(monthAbbreviations[i]) || inputParts[0].equalsIgnoreCase(monthShortNames[i]) || inputParts[0].equals(String.valueOf(i + 1))) {
                return true;
            }
        }

        // Kiểm tra phần năm
        String yearPart = inputParts[1];
        if (yearPart.matches("\\d+") && Integer.parseInt(yearPart) >= 0) {
            return true;
        }

        return false;
    }

    // Hàm tính số ngày trong tháng
    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonthCommonYear = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        int[] daysInMonthLeapYear = {
            31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        if (isLeapYear(year)) {
            return daysInMonthLeapYear[month - 1];
        } else {
            return daysInMonthCommonYear[month - 1];
        }
    }

    // Hàm kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
