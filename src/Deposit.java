import java.util.Date;
import java.text.DecimalFormat;

public class Deposit {
    private double amount; //amount deposited
    private Date date; //the date in a date object
    private String account; //the account name
    private final DecimalFormat df = new DecimalFormat("0.00");

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }



    //Modifies: this, deposits
    //Effects: returns string of the amount deposited, the date as a Date object,
    //and the account in which the money was deposited (either the checking (chequing) or the saving account
    //in the order listed
    public String toString(){
        //your code here

        return "Deposit of: $"+df.format(amount)+" Date: "+date+" into account: "+account;
    }
}
