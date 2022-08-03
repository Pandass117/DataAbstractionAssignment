

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

        assertEquals(testomer.depositsSize(), 0);
        testomer.deposit(100.08, new Date(), "Checking");
        assertEquals(testomer.depositsSize(), 1);
        assertEquals(testomer.getCheckBalance(), 200.08, 0.0);

        testomer.deposit(12.2, new Date(), "Saving");
        assertEquals(testomer.depositsSize(), 2);
        assertEquals(testomer.getSavingBalance(), 62.2, 0.0);



        assertEquals(defaultTestomer.depositsSize(), 0);
        defaultTestomer.deposit(100.08, new Date(), "Checking");
        assertEquals(defaultTestomer.depositsSize(), 1);
        assertEquals(defaultTestomer.getCheckBalance(), 100.08, 0.0);

        defaultTestomer.deposit(12.2, new Date(), "Saving");
        assertEquals(defaultTestomer.depositsSize(), 2);
        assertEquals(defaultTestomer.getSavingBalance(), 12.2, 0.0);

    }

    @Test
    public void testDepositFailed(){

        //check that there are no deposits in array
        //do a failed deposit
        //check that there are no deposits in array
        //check if balance values are correct
        //repeat for default constructor
        assertEquals(testomer.depositsSize(), 0);
        testomer.deposit(100.08, new Date(), "Something");
        assertEquals(testomer.depositsSize(), 0);
        assertEquals(testomer.getCheckBalance(), 100, 0.0);
        assertEquals(testomer.getSavingBalance(), 50, 0.0);

        assertEquals(defaultTestomer.depositsSize(), 0);
        defaultTestomer.deposit(100.08, new Date(), "Something");
        assertEquals(defaultTestomer.depositsSize(), 0);
        assertEquals(defaultTestomer.getCheckBalance(), 0, 0.0);
        assertEquals(defaultTestomer.getSavingBalance(), 0, 0.0);

    }

    @Test
    public void testWithdrawal(){
        //check that there are no withdrawals in array
        //add a withdrawal that does not overdraft in account Checking
        //check that there is 1 withdrawal in array
        //check if balance value is correct
        //repeat for savings
        //repeat for default constructor

        assertEquals(testomer.withdrawsSize(), 0);
        testomer.withdraw(50.05, new Date(), "Checking");
        assertEquals(testomer.withdrawsSize(), 1);
        assertEquals(testomer.getCheckBalance(), 49.95, 0.0);

        testomer.withdraw(60.06, new Date(), "Saving");
        assertEquals(testomer.withdrawsSize(), 2);
        assertEquals(testomer.getSavingBalance(), -10.06, 0.0);



        assertEquals(defaultTestomer.withdrawsSize(), 0);
        defaultTestomer.withdraw(50.05, new Date(), "Checking");
        assertEquals(defaultTestomer.withdrawsSize(), 1);
        assertEquals(defaultTestomer.getCheckBalance(), -50.05, 0.0);

        defaultTestomer.withdraw(60.06, new Date(), "Saving");
        assertEquals(defaultTestomer.withdrawsSize(), 2);
        assertEquals(defaultTestomer.getSavingBalance(), -60.06, 0.0);

    }

    @Test
    public void testWithdrawalOverdraft(){
        //check that there are no withdrawals in array
        //add a withdrawal that does overdraft in account Checking
        //check that there are no withdrawals in array
        //check if balance value is correct
        //repeat for savings
        //repeat for default constructor

        assertEquals(testomer.withdrawsSize(), 0);
        testomer.withdraw(200.98, new Date(), "Checking");
        assertEquals(testomer.withdrawsSize(), 0);
        assertEquals(testomer.getCheckBalance(), 100, 0.0);

        testomer.withdraw(160.06, new Date(), "Saving");
        assertEquals(testomer.withdrawsSize(), 0);
        assertEquals(testomer.getSavingBalance(), 50, 0.0);



        assertEquals(defaultTestomer.withdrawsSize(), 0);
        defaultTestomer.withdraw(550.05, new Date(), "Checking");
        assertEquals(defaultTestomer.withdrawsSize(), 0);
        assertEquals(defaultTestomer.getCheckBalance(), 0, 0.0);

        defaultTestomer.withdraw(230, new Date(), "Saving");
        assertEquals(defaultTestomer.withdrawsSize(), 0);
        assertEquals(defaultTestomer.getSavingBalance(), 0, 0.0);

    }

    @Test
    public void testWithdrawalFailed(){
        //check that there are no withdrawals in array
        //do a failed withdrawal
        //check that there are no withdrawals in array
        //check if balance values are correct
        //repeat for default constructor
        assertEquals(testomer.withdrawsSize(), 0);
        testomer.withdraw(100.08, new Date(), "Something");
        assertEquals(testomer.withdrawsSize(), 0);
        assertEquals(testomer.getCheckBalance(), 100, 0.0);
        assertEquals(testomer.getSavingBalance(), 50, 0.0);

        assertEquals(defaultTestomer.withdrawsSize(), 0);
        defaultTestomer.withdraw(100.08, new Date(), "Something");
        assertEquals(defaultTestomer.withdrawsSize(), 0);
        assertEquals(defaultTestomer.getCheckBalance(), 0, 0.0);
        assertEquals(defaultTestomer.getSavingBalance(), 0, 0.0);

    }


}