import java.util.Scanner;
import java.util.ArrayList;
class ATM{
    static Scanner sc=new Scanner(System.in);
    static double balance = 10000;
    static ArrayList<String>history = new ArrayList<>();
    public static void main(String[] args)
    {
        int choice;
        System.out.println("Welcome to ATM Interface");
        do
        {
            System.out.println("\n1.Transaction History");
            System.out.println("2.Withdraw");
            System.out.println("3.Deposit");
            System.out.println("4.Transfer");
            System.out.println("5.Quit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    showHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    static void showHistory() {
        if (history.isEmpty())
        {
            System.out.println("No transactions yet.");
        } 
        else 
        {
            System.out.println("Transaction History:");
            for (String h : history) 
            {
                System.out.println(h);
            }
        }
    }

    static void withdraw()
    {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance)
        {
            balance -= amount;
            history.add("Withdrawn: Rs." + amount);
            System.out.println("Withdraw successful. Balance: Rs." + balance);
        } 
        else 
        {
            System.out.println("Insufficient balance.");
        }
    }

    static void deposit()
    {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        history.add("Deposited: Rs." + amount);
        System.out.println("Deposit successful. Balance: Rs." + balance);
    }

    static void transfer() 
    {
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount <= balance) 
        {
            balance -= amount;
            history.add("Transferred: Rs." + amount);
            System.out.println("Transfer successful. Balance: Rs." + balance);
        } else 
        {
            System.out.println("Insufficient balance.");
        }
    }
}
