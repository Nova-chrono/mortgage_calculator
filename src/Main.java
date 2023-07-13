import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // My First Java Project (Mortgage Calculator)
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        int principal = 0;
        float monthlyInterestRate = 0;
        short numberOfMonths = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate > 0 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equals to 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfMonths = (short) (years * MONTHS_IN_YEAR);
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);

        String mortgageResult = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageResult);
    }
}