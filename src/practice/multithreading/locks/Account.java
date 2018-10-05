package practice.multithreading.locks;

/**
 * Created by asaxena on 8/28/2018.
 */
public class Account {
    public int id;
    private int balance=10000;

    public Account(int id){
        this.id=id;
    }
    public void debit(int amount){
        balance-=amount;
    }
    public void credit(int amount){
        balance+=amount;
    }
    public int showBalance(){
        return balance;
    }
}
