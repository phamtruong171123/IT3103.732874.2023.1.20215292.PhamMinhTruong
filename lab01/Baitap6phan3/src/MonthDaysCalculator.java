import java.util.Scanner;

public class MonthDaysCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        String[] monthAbbreviations = {
                "Jan.", "Feb.", "Mar.", "Apr.", "May", "June",
                "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."
        };

        String[] monthShortNames = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        System.out.println("Enter the month and year (e.g., January 2023 or Jan 2023):");
        String input = scanner.nextLine().trim();

        int month = -1;
        int year = -1;

        while (true) {
            if (isValidInput(input)) {
                break;
            } else {
                System.out.println("Invalid input. Please enter the month and year (e.g., January 2023 or Jan 2023):");
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
        System.out.println("There are " + daysInMonth + " days in " + months[month - 1] + " " + year + ".");
    }

    public static boolean isValidInput(String input) {
        // Validate input format (e.g., "Month Year")
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            return false;
        }

        // Validate month part
        String monthPart = inputParts[0];
        for (int i = 0; i < 12; i++) {
            if (monthPart.equalsIgnoreCase(months[i]) || monthPart.equalsIgnoreCase(monthAbbreviations[i]) || monthPart.equalsIgnoreCase(monthShortNames[i]) || monthPart.equals(String.valueOf(i + 1))) {
                return true;
            }
        }

        // Validate year part (non-negative number with all digits)
        String yearPart = inputParts[1];
        if (yearPart.matches("\\d+") && Integer.parseInt(yearPart) >= 0) {
            return true;
        }

        return false;
    }

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
