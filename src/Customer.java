import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0.03;
        name = "";
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.accountNumber = accountNumber;
        checkBalance = checkDeposit;
        savingBalance = savingDeposit;
        savingRate = 0.03;
        this.name = name;
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
    }

    //Requires: amt >=0, date object, account to be "Checking" or "Saving"
    //Modifies: this
    //Effects: adds amt to balance of account inputted, records deposit in ArrayList deposits,
    //if account is not String CHECKING or String SAVING shows a message
    public double deposit(double amt, Date date, String account){
        //your code here
        if (account.equals(CHECKING)){
            checkBalance += amt;
            deposits.add(new Deposit(amt, date, account));
        }
        else if (account.equals(SAVING)){
            savingBalance += amt;
            deposits.add(new Deposit(amt, date, account));
        }
        else{
            System.out.println("Please enter: \""+CHECKING+"\" or \""+SAVING+"\"");
        }
        return 0;
    }

    //Requires: amt >=0, date object, account to be "Checking" or "Saving"
    //Modifies: this
    //Effects: if not overdraft it subtracts amt from balance in account inputted, otherwise shows message
    //records withdrawal in ArrayList withdraws,
    //if account is not String CHECKING or String SAVING shows a message
    public double withdraw(double amt, Date date, String account){
        //your code here

        if (account.equals(CHECKING)){
            if (checkOverdraft(amt, account)){
                System.out.println("Sorry, your "+account+" account's balance will be below "+OVERDRAFT+".");
            }
            else{
                checkBalance -= amt;
                withdraws.add(new Withdraw(amt, date, account));
            }

        }
        else if (account.equals(SAVING)){
            if (checkOverdraft(amt, account)){
                System.out.println("Sorry, your "+account+" account's balance will be below "+OVERDRAFT+".");
            }
            else{
                savingBalance -= amt;
                withdraws.add(new Withdraw(amt, date, account));
            }

        }
        else{
            System.out.println("Please enter: \""+CHECKING+"\" or \""+SAVING+"\"");
        }
        return 0;
    }

    //Requires: amt >=0, account to be "Checking" or "Saving"
    //Modifies: this
    //Effects: returns false if balance of account inputted minus amt is greater than or equal to int OVERDRAFT, otherwise return true

    private boolean checkOverdraft(double amt, String account){
        //your code here
        if (account.equals(CHECKING)){
            if (checkBalance-amt<OVERDRAFT){
                return true;
            }
        }
        else { //savings
            if (savingBalance-amt<OVERDRAFT){
                return true;
            }
        }



        return false;
    }

    //Modifies: this
    //Effects: returns string of the account name, the account number,
    //and the balance of the checking (chequing) and saving accounts
    //in the order listed

    public String toString(){

        return "Name: "+name+" Account number: "+accountNumber+" Checking balance: "+checkBalance+" Saving balance: "+savingBalance;
    }

    public int depositsSize(){
        return deposits.size();
    }

    public int withdrawsSize(){
        return withdraws.size();
    }

    public double getCheckBalance() {
        return Math.round(checkBalance * 100.0) / 100.0;
    }

    public double getSavingBalance() {
        return Math.round(savingBalance * 100.0) / 100.0;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
