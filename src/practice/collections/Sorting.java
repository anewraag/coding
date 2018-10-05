package practice.collections;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by asaxena on 9/19/2018.
 */
class Student implements Comparable<Student>{
    int rollNum;
    String name;
    int age;

    Student(int rollNum,String name, int age){
        this.rollNum = rollNum;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNum +" Name: " + name + " Age: " + age;
    }

    public int compareTo(Student o) {
        return this.rollNum - o.rollNum;
    }
}

class sortByAge implements Comparator<Student> {

    @Override
    public int compare(Student a,Student b) {
        return a.age - b.age;
    }
}

class sortByName implements Comparator<Student> {

    @Override
    public int compare(Student a,Student b) {
        return a.name.compareTo(b.name);
    }
}
class sortByRollNum implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.rollNum - o2.rollNum;
    }
}
class Main{
    static void printList(List<Student> list){
        for(Student student: list){
            System.out.println(student.toString());
        }
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(21,"Anurag Saxena",20));
        students.add(new Student(2,"Manisha Chopra",10));
        students.add(new Student(13,"Abhay Singh",5));

        int[] list = new int[]{3,5,10,2,3,5};
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        System.out.println();


        //sort using comparable interface
        Collections.sort(students);
        printList(students);
        System.out.println();

        //sort using comparator objects
        Collections.sort(students,new sortByAge());
        printList(students);
        System.out.println();

        Collections.sort(students,new sortByRollNum());
        printList(students);
        System.out.println();

        Collections.sort(students,new sortByName());
        printList(students);
    }
}