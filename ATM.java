import java.util.Random;
import java.util.Scanner;

public class ATM {

    private Account account = new Account();
    private Scanner sc = new Scanner(System.in);


    public void start() {

        int option;

        do {

            System.out.println("\n===== ATM SYSTEM =====");
            System.out.println("1. Login");
            System.out.println("2. Forgot PIN");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            option = sc.nextInt();


            switch(option) {

                case 1:
                    login();
                    break;

                case 2:
                    forgotPin();
                    break;

                case 3:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while(option != 3);
    }


    // LOGIN METHOD
    private void login() {

        int attempts = 0;
        boolean loggedIn = false;

        while(attempts < 3) {

            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if(account.verifyPin(enteredPin)) {

                loggedIn = true;
                break;

            } else {

                attempts++;
                System.out.println("Incorrect PIN.");
            }
        }


        if(!loggedIn) {

            System.out.println("Too many incorrect attempts.");
            System.out.println("Account blocked.");
            return;
        }


        System.out.println("Login Successful!\n");

        atmMenu();
    }


    // ATM MENU
    private void atmMenu() {

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Change PIN");
            System.out.println("6. Logout");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();


            switch(choice) {

                case 1:

                    System.out.println("Current Balance: Rs" + account.getBalance());
                    break;


                case 2:

                    System.out.print("Enter amount to deposit: Rs");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;


                case 3:

                    System.out.print("Enter amount to withdraw: Rs");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;


                case 4:

                    account.miniStatement();
                    break;


                case 5:

                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();

                    account.changePin(newPin);
                    break;


                case 6:

                    System.out.println("Logged out successfully.");
                    break;


                default:
                    System.out.println("Invalid choice.");
            }

        } while(choice != 6);
    }


    // FORGOT PIN + OTP
    private void forgotPin() {

        sc.nextLine();

        System.out.print("Enter registered mobile number: ");
        String mobile = sc.nextLine();


        if(account.verifyMobile(mobile)) {

            // GENERATE OTP
            Random random = new Random();
            int otp = 1000 + random.nextInt(9000);

            System.out.println("OTP sent successfully.");


            // SIMULATED OTP DISPLAY
            System.out.println("Generated OTP: " + otp);


            System.out.print("Enter OTP: ");
            int enteredOtp = sc.nextInt();


            if(enteredOtp == otp) {

                System.out.print("Enter new PIN: ");
                int newPin = sc.nextInt();

                account.changePin(newPin);

            } else {

                System.out.println("Incorrect OTP.");
            }

        } else {

            System.out.println("Mobile number not found.");
        }
    }
}