package hiring.interview.halodoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asaxena on 10/10/2018.
 */
class Coin{
    int val;

    public void setValue(int val){
        this.val= val;
    }

}

class Note{
    int val;

    public void setValue(int val){
        this.val= val;
    }
}

class Bag<T>{
    List<T> bag;

    public void add(T currency){
        bag.add(currency);
    }
    public Bag(){
        bag = new ArrayList<T>();
    }
    public void display(){
        for(int i=0;i<bag.size();i++){
            T currency = bag.get(i);
            if(currency instanceof  Note){
                System.out.println(((Note) currency).val);;
            }
            if(currency instanceof  Coin){
                System.out.println(((Coin) currency).val);;
            }

        }
    }
}
class TestClass {
    public static void main(String args[] ) throws Exception {

        Bag<Coin> coinBag = new Bag<>();
        Bag<Note> noteBag = new Bag<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] currency;
        Integer  currencyCount = Integer.parseInt(br.readLine());

        for(int i=0;i<currencyCount;i++){
            currency = br.readLine().split(" ");
            if(currency[0].equals("Note")){
                Note note = new Note();
                note.setValue(Integer.parseInt(currency[1]));
                noteBag.add(note);
            }
            if(currency[0].equals("Coin")){
                Coin coin = new Coin();
                coin.setValue(Integer.parseInt(currency[1]));
                coinBag.add(coin);
            }
        }

        System.out.println("Coin");
        coinBag.display();
        System.out.println("Note");
        noteBag.display();

    }
}
