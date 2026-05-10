import java.util.ArrayList;

public class Account {

    private int pin = 1234;
    private double balance = 1000;

    private String mobileNumber = "9958683630";

    private ArrayList<String> transactions = new ArrayList<>();


    // VERIFY PIN
    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }


    // VERIFY MOBILE NUMBER
    public boolean verifyMobile(String mobile) {
        return mobile.equals(mobileNumber);
    }


    // CHANGE PIN
    public void changePin(int newPin) {

        if(newPin >= 1000 && newPin <= 9999) {

            pin = newPin;
            System.out.println("PIN changed successfully.");

        } else {

            System.out.println("PIN must be 4 digits.");
        }
    }


    // CHECK BALANCE
    public double getBalance() {

        transactions.add("Checked Balance: Rs" + balance);
        return balance;
    }


    // DEPOSIT
    public void deposit(double amount) {

        if(amount > 0) {

            balance += amount;
            transactions.add("Deposited: Rs" + amount);

            System.out.println("Rs" + amount + " deposited successfully.");

        } else {

            System.out.println("Invalid amount.");
        }
    }


    // WITHDRAW
    public void withdraw(double amount) {

        if(amount <= balance && amount > 0) {

            balance -= amount;
            transactions.add("Withdrawn: Rs" + amount);

            System.out.println("Please collect your cash.");

        } else {

            System.out.println("Insufficient balance.");
        }
    }


    // MINI STATEMENT
    public void miniStatement() {

        System.out.println("\n----- MINI STATEMENT -----");

        if(transactions.isEmpty()) {

            System.out.println("No transactions available.");

        } else {

            for(String t : transactions) {
                System.out.println(t);
            }
        }

        System.out.println("--------------------------");
    }
}