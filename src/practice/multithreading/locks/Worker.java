package practice.multithreading.locks;

/**
 * Created by asaxena on 8/28/2018.
 */
public class Worker{
    public void transfer(Account fromAcc,Account toAccount,int amount){

        fromAcc.debit(amount);
        toAccount.credit(amount);

        System.out.println(" Amount: " + amount +
            " Acc:" + fromAcc.id + " " + fromAcc.showBalance() +
            " Acc:" + toAccount.id + " " + toAccount.showBalance() +
            " Total: " + (fromAcc.showBalance()+toAccount.showBalance()));

    }
}
