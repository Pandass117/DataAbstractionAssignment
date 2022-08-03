import java.util.Date;

import java.text.DecimalFormat;

public class Withdraw {
    private double amount; //amount withdrawn
    private Date date; //the date in a date object
    private String account; //the account name
    private final DecimalFormat df = new DecimalFormat("0.00");

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }


    //Modifies: this ,withdraws
    //Effects: returns string of the amount withdrawn in money format, the date as a Date object,
    //and the account in which the money was withdrawn (either the checking (chequing) or the saving account
    //in the order listed

    public String toString(){
        //your code here

        return "Withdrawal of: $"+df.format(amount)+" Date: "+date+" out of account: "+account;
    }
}
