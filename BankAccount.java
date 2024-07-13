

public class BankAccount {
    /*Attributes of a bank account */
    private String userName;
    protected double balance;

    public BankAccount(String name, int pin){ 
        this.userName = name;
        this.balance = 0;
    }

    public BankAccount(){}

    public double getBalance(){
        return balance;
    }

    public void setBalance(double remainingBalance){
        this.balance = remainingBalance;
    }

    public String getName(){
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
}
