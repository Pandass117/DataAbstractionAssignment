import java.util.Date;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class WithdrawTests {
    Withdraw testCheck;
    Withdraw testSave;
    Date date;

    @Before
    public void setup(){
        date = new Date();

        testCheck = new Withdraw(50,  date, "Checking");

        testSave = new Withdraw(50.86,  date, "Saving");


    }
    @Test
    public void stringTests(){

        assertTrue((testSave.toString()).equals("Withdrawal of: $50.86 Date: "+date+" out of account: Saving"));
        assertTrue((testCheck.toString()).equals("Withdrawal of: $50.00 Date: "+date+" out of account: Checking"));
    }

    /*
    test
    public static void main(String[] args) {
        Customer mrbean = new Customer("bean", 1, 100, 5);
        mrbean.deposit(100, new Date(), "Checking");
        mrbean.withdraw(105.01, new Date(), "Saving");
        mrbean.displayDeposits();
        mrbean.displayWithdraws();
        System.out.println(mrbean);
        double one = 1.11;
        double two = 2.22;
        System.out.println(Math.round((one+two) * 100.0) / 100.0);
    }
    */

}
