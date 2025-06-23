import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice = 'y'; 

        do {
            System.out.println("\n--- Simple Calculator ---");
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Choose operation (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            double result = 0;

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    continue;
                }
            } else {
                System.out.println("Invalid operation.");
                continue;
            }

            System.out.println("Result: " + result);

            System.out.print("Do you want to calculate again? (y/n): ");
            choice = scanner.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Calculator Closed.");
        scanner.close();
    }
}
