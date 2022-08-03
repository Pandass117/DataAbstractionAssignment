import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;


public class DepositTests {
    Deposit testCheck;
    Deposit testSave;
    Date date;

    @Before
    public void setup(){
        date = new Date();

        testCheck = new Deposit(50,  date, "Checking");

        testSave = new Deposit(50.86,  date, "Saving");


    }
    @Test
    public void stringTests(){

        assertTrue((testSave.toString()).equals("Deposit of: $50.86 Date: "+date+" into account: Saving"));
        assertTrue((testCheck.toString()).equals("Deposit of: $50.00 Date: "+date+" into account: Checking"));
    }
}
