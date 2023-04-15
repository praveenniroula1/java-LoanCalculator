import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double loanAmount = 0;
        do {
            try {
                System.out.println("Input the loan amount");

                loanAmount = scanner.nextDouble();

                if (loanAmount == 0) {
                    System.out.println("Loan amount should be greater than 0.");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid format. Please try again.");
                scanner.nextLine();
            }
        } while (loanAmount <= 0);

        int loanPeriod = 0;
        do {
            try {
                System.out.println("Input loan period");

                loanPeriod = scanner.nextInt();

                if (loanPeriod == 0) {
                    System.out.println("Loan period should be greater than 0.");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid format. Please try again.");
                scanner.nextLine();
            }
        } while (loanPeriod <= 0);

        scanner.close();

        for (double interestRate = 5.0; interestRate <= 8.0; interestRate += 0.125) {
            double monthlyInterestRate = interestRate / 1200.0;
            int numPayments = loanPeriod * 12;
            double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - (1 / Math.pow(1 + monthlyInterestRate, numPayments)));
            double totalPayment = monthlyPayment * numPayments;
            System.out.printf("%-20.3f$%-20.2f$%-20.2f\n", interestRate, monthlyPayment, totalPayment);
            System.out.println("-------------------------------------------------------");
        }
    }
}