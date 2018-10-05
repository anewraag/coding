package practice.collections;

/**
 * Created by asaxena on 9/18/2018.
 */

// Making the parent class final or making the parent constructor private, both give compile time error.

class Parent{
    final Integer value=1;

    Parent(){
        System.out.println("Inside Parent Constructor!!");
    }
    void printHello(){
        System.out.println("Parent says Hello");
    }
}

public class ExtendingFinalClass extends Parent{

    void printHello(){
        System.out.println(value+" Child says Hello");
    }

    public static void main(String[] args) {
        ExtendingFinalClass childClass = new ExtendingFinalClass();
        childClass.printHello();
    }
}
