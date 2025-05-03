public class SimpleCalculator {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Simple Calculator");
        System.out.println("Enter two numbers:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        System.out.println("Choose operation (+, -, *, /):");
        char operation = scanner.next().charAt(0);
        
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid operation!");
                return;
        }
        System.out.printf("Result: %.2f%n", result);
        scanner.close();
    }
}