import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainSceneController extends JFrame{
    /*Creating Listeners */
    public ATM atmFunctions;
    public JTextField amount;
    public JLabel interactionField1;
    public JLabel interactionField2;
    public JLabel nameLabel;

    public MainSceneController(){
        super("ATM Home Page");
        atmFunctions = new ATM();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*TopView View panel */
        JPanel viewerPanel = new JPanel();
        viewerPanel.setLayout(new GridLayout(4,1,5,10));
        viewerPanel.setBackground(Color.LIGHT_GRAY);
        amount = new JTextField();
        nameLabel = new JLabel("Only fill in information here before making a withdrawal or a deposit. \nYou do not need to fill in anything below to check you balance.");
        viewerPanel.add(nameLabel);
        viewerPanel.add(amount);

        /*Screen interactionPanel */
        JPanel interactionPanel = new JPanel();
        interactionPanel.setBackground(Color.WHITE);
        interactionPanel.setLayout(new GridLayout(4,1,5,5));
        interactionField1 = new JLabel("Your information wil show up here.");
        interactionField2 = new JLabel();
        interactionPanel.add(interactionField1);
        interactionPanel.add(interactionField2);

        /*Button section */
        JButton checkBalance = new JButton("Check Balance");
        checkBalance.addActionListener((ActionEvent e)->{
            double balance = atmFunctions.checkBalance();
            interactionField1.setText("Your remaining balance is: R"+balance);
        });
        add(checkBalance);

        JButton makeDeposit = new JButton("Make Deposit");
        makeDeposit.addActionListener((ActionEvent e)->{
            String deposit = amount.getText();
            double newDeposit = Double.parseDouble(deposit);
            if(newDeposit<atmFunctions.checkBalance()||newDeposit<0||deposit.equals("")){
                interactionField1.setText("Error: Invalid input.");
            }
            else{
                atmFunctions.deposit(newDeposit);
                double balance = Math.round(atmFunctions.checkBalance());
                interactionField1.setText("The Amount you have deposited is: R"+newDeposit);
                interactionField2.setText("Your remaining balance is: R"+Math.round(balance));
            }
            
        });
        add(makeDeposit);
        
        JButton makeWithdrawal = new JButton("Make Withdrawal");
        makeWithdrawal.addActionListener((ActionEvent e)->{
            String withdrawal = amount.getText();
            double newWithdrawal = Double.parseDouble(withdrawal);
            if(newWithdrawal>atmFunctions.checkBalance() ||newWithdrawal<0||withdrawal.equals("")){
                interactionField1.setText("Error: invalid input.");
            }
            else{
                atmFunctions.withdrawAmount(newWithdrawal);
                double balance = atmFunctions.checkBalance();
                interactionField1.setText("The amount you withdrew is: R"+newWithdrawal);
                interactionField2.setText("Your remaining balance is: R"+balance);
            }
        });
        add(makeWithdrawal);
        
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e)->{
            System.exit(0);
        });
        add(quitButton);

        /*Button Panel */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        buttonPanel.add(checkBalance);
        buttonPanel.add(makeDeposit);
        buttonPanel.add(makeWithdrawal);
        buttonPanel.add(quitButton);

         /*Set layout */
        setLayout(new BorderLayout());
        add(viewerPanel, BorderLayout.NORTH);
        add(interactionPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

