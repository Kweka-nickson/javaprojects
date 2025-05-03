import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double USD_TO_EUR = 0.85;
        final double USD_TO_GBP = 0.73;
        
        System.out.println("Currency Converter (USD Base)");
        System.out.print("Enter amount in USD: ");
        double usd = scanner.nextDouble();
        
        System.out.println("Choose target currency:");
        System.out.println("1. EUR");
        System.out.println("2. GBP");
        int choice = scanner.nextInt();
        
        double result;
        String currency;
        if (choice == 1) {
            result = usd * USD_TO_EUR;
            currency = "EUR";
        } else if (choice == 2) {
            result = usd * USD_TO_GBP;
            currency = "GBP";
        } else {
            System.out.println("Invalid choice!");
            scanner.close();
            return;
        }
        
        System.out.printf("%.2f USD = %.2f %s%n", usd, result, currency);
        scanner.close();
    }
}