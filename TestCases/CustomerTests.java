

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;



public class CustomerTests {
    Customer testomer;
    Customer defaultTestomer;

    @Before
    public void setup(){

        testomer = new Customer("Test", 1, 100, 50);

        defaultTestomer = new Customer();


    }


    @Test
    public void testDeposit(){


        //check that there are no deposits in array
        //add a deposit in account Checking
        //check that there is 1 deposit in array
        //check if balance value is correct
        //repeat for savings
        //repeat for default constructor

        assertEquals(0, testomer.depositsSize());
        testomer.deposit(100.08, new Date(), "Checking");
        assertEquals(1, testomer.depositsSize());
        assertEquals(200.08, testomer.getCheckBalance(),0.0);

        testomer.deposit(12.2, new Date(), "Saving");
        assertEquals(2, testomer.depositsSize());
        assertEquals(62.2, testomer.getSavingBalance(), 0.0);



        assertEquals(0, defaultTestomer.depositsSize());
        defaultTestomer.deposit(100.08, new Date(), "Checking");
        assertEquals(1, defaultTestomer.depositsSize());
        assertEquals(100.08, defaultTestomer.getCheckBalance(), 0.0);

        defaultTestomer.deposit(12.2, new Date(), "Saving");
        assertEquals(2, defaultTestomer.depositsSize());
        assertEquals(12.2, defaultTestomer.getSavingBalance(),0.0);

    }

    @Test
    public void testDepositFailed(){

        //check that there are no deposits in array
        //do a failed deposit
        //check that there are no deposits in array
        //check if balance values are correct
        //repeat for default constructor
        assertEquals(0, testomer.depositsSize());
        testomer.deposit(100.08, new Date(), "Something");
        assertEquals(0, testomer.depositsSize());
        assertEquals(100, testomer.getCheckBalance(),0.0);
        assertEquals(50, testomer.getSavingBalance(), 0.0);

        assertEquals(0, defaultTestomer.depositsSize());
        defaultTestomer.deposit(100.08, new Date(), "Something");
        assertEquals(0, defaultTestomer.depositsSize());
        assertEquals(0, defaultTestomer.getCheckBalance(), 0.0);
        assertEquals(0, defaultTestomer.getSavingBalance(), 0.0);

    }

    @Test
    public void testWithdrawal(){
        //check that there are no withdrawals in array
        //add a withdrawal that does not overdraft in account Checking
        //check that there is 1 withdrawal in array
        //check if balance value is correct
        //repeat for savings
        //repeat for default constructor

        assertEquals(0, testomer.withdrawsSize());
        testomer.withdraw(50.05, new Date(), "Checking");
        assertEquals(1, testomer.withdrawsSize());
        assertEquals(49.95, testomer.getCheckBalance(), 0.0);

        testomer.withdraw(60.06, new Date(), "Saving");
        assertEquals(2, testomer.withdrawsSize());
        assertEquals(-10.06, testomer.getSavingBalance(), 0.0);



        assertEquals(0, defaultTestomer.withdrawsSize());
        defaultTestomer.withdraw(50.05, new Date(), "Checking");
        assertEquals(1, defaultTestomer.withdrawsSize());
        assertEquals(-50.05, defaultTestomer.getCheckBalance(), 0.0);

        defaultTestomer.withdraw(60.06, new Date(), "Saving");
        assertEquals(2, defaultTestomer.withdrawsSize());
        assertEquals(-60.06, defaultTestomer.getSavingBalance(), 0.0);

    }

    @Test
    public void testWithdrawalOverdraft(){
        //check that there are no withdrawals in array
        //add a withdrawal that does overdraft in account Checking
        //check that there are no withdrawals in array
        //check if balance value is correct
        //repeat for savings
        //repeat for default constructor

        assertEquals(0, testomer.withdrawsSize());
        testomer.withdraw(200.98, new Date(), "Checking");
        assertEquals(0, testomer.withdrawsSize());
        assertEquals(100, testomer.getCheckBalance(), 0.0);

        testomer.withdraw(160.06, new Date(), "Saving");
        assertEquals(0, testomer.withdrawsSize());
        assertEquals(50, testomer.getSavingBalance(), 0.0);



        assertEquals(0, defaultTestomer.withdrawsSize());
        defaultTestomer.withdraw(550.05, new Date(), "Checking");
        assertEquals(0, defaultTestomer.withdrawsSize());
        assertEquals(0, defaultTestomer.getCheckBalance(), 0.0);

        defaultTestomer.withdraw(230, new Date(), "Saving");
        assertEquals(0, defaultTestomer.withdrawsSize());
        assertEquals(0, defaultTestomer.getSavingBalance(), 0.0);

    }

    @Test
    public void testWithdrawalFailed(){
        //check that there are no withdrawals in array
        //do a failed withdrawal
        //check that there are no withdrawals in array
        //check if balance values are correct
        //repeat for default constructor
        assertEquals(0, testomer.withdrawsSize());
        testomer.withdraw(100.08, new Date(), "Something");
        assertEquals(0, testomer.withdrawsSize());
        assertEquals(100, testomer.getCheckBalance(), 0.0);
        assertEquals(50, testomer.getSavingBalance(), 0.0);

        assertEquals(0, defaultTestomer.withdrawsSize());
        defaultTestomer.withdraw(100.08, new Date(), "Something");
        assertEquals(0, defaultTestomer.withdrawsSize());
        assertEquals(0, defaultTestomer.getCheckBalance(), 0.0);
        assertEquals(0, defaultTestomer.getSavingBalance(), 0.0);

    }


}