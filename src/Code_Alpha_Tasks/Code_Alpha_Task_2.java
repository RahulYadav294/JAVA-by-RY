package Code_Alpha_Tasks;
import java.util.Scanner;
public class Code_Alpha_Task_2 {

    static double balance = 0.0;
    static void checkBalance(String userName) {
            System.out.println(userName + "your current balance is : $" +balance);
    }
    static void depositAmount(double amounts,String name) {
        if (amounts > 0) {
            balance += amounts;
            System.out.println("Successfully deposited $" + amounts + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    static void withdrawalAmount(double amount,String name) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
            System.out.println("Successfully withdrew $" + amount + ". New balance: $" + balance);
            } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }

        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount,amounts;
            System.out.print("Welcome to the Simple Banking Application! Please enter your name: ");
        String userName = sc.nextLine();

            System.out.println("Hello, " + userName + "! Let's get started with your banking transactions.");
        boolean operation = true;
        do {
            System.out.println("1.Check Balance:");
            System.out.println("2.Deposit Amount:");
            System.out.println("3.Withdrawal Amount:");
            System.out.println("0.press 0 for exit:");
            System.out.println("----------------------------------");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkBalance(userName);
                    break;
                case 2:
                    System.out.println("Enter an amount for Deposit:");
                     amounts = sc.nextDouble();
                    depositAmount(amounts,userName);
                    break;
                case 3:
                    System.out.println("Enter an amount for Withdrawal:");
                     amount = sc.nextDouble();
                    withdrawalAmount(amount,userName);

                    break;
                case 0:
                    System.out.println("Thank you " + userName + " for using banking application.visit again!");
                    operation = false;
                    break;
                default:
                    System.out.println("Sorry! Invalid choice.");
                    break;
            }
                    System.out.println("----------------------------------");

        } while (operation);
    }
    }
