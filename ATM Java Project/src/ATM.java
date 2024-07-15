
import java.util.Scanner;

public class ATM {
    /*ATM Attributes */
    private BankAccount userAccount;

    public ATM(){
        BankAccount newTransaction = new BankAccount();
        this.userAccount = newTransaction;
    }

    public double checkBalance(){
        return userAccount.getBalance();
    }

    public void withdrawAmount(double amount){
        try{
            if(amount<0){
                System.err.println("Invalid amount");
            }
            if (amount>userAccount.getBalance()) {
                System.err.println("You cannot withdraw more than You have");
            } else {
                double remainingBalance = userAccount.getBalance() - amount;
                userAccount.setBalance(remainingBalance);
            }
        } catch (Exception err){
            System.err.println("An error occoured: "+err);
        }
    }

    public void deposit(double amount){
        try{
            if(amount<0){
                System.err.println("Invalid amount");
            }
            else{
                double remainingBalance = userAccount.getBalance() + amount;
                userAccount.setBalance(remainingBalance);
            }
        } catch (Exception err){
            System.err.println("An Error occured: "+err);
        }
    }

    public BankAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void main(int num) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your Username: ");
            String username = scan.nextLine();
            ATM user = new ATM();
            user.userAccount.setUserName(username);
            int exitNumber = 0;
            do { 
                System.out.println("====================================");
                System.out.println("Choose an option:");
                System.out.println("1. Check your Balance");
                System.out.println("2. Make a deposit");
                System.out.println("3. Make a withdrawl");
                System.out.println("4. Close application");
                switch (scan.nextInt()) {
                    case 1 -> System.out.println("Remaining Balance: R"+user.checkBalance());
                    case 2 -> {
                        System.out.println("How much would you like to deposit? (Type the number only)");
                        double deposit = scan.nextDouble();
                        user.deposit(deposit);
                        System.out.println("Deopsit Amount: R"+deposit);
                        System.out.println("Remaining Balance: R"+user.checkBalance());
                    }
                    case 3 -> {
                        System.out.println("How much would you like to withdraw? (Type the number only)");
                        double withdrawal = scan.nextDouble();
                        user.withdrawAmount(withdrawal);
                        System.out.println("Withdrawal Amount: R"+withdrawal);
                        System.out.println("Remaining Balance: R"+user.checkBalance());
                    }
                    case 4 -> {
                        exitNumber = 4;
                        System.out.println("Thank you for using our Seervices");
                    }
                    default -> throw new AssertionError();
                }
                System.out.println("====================================");
            } while (exitNumber!=4);
        } catch(Exception e){
            System.err.println("An error occured: "+e);
        }
    }
}
