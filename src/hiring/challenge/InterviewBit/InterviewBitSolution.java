package hiring.challenge.InterviewBit;

/**
 * Created by asaxena on 8/4/2018.
 */
public class InterviewBitSolution {
    public static String[] fizzBuzz(int A) {
        String[] result = new String[A];
        for(int i=1; i<=A;i++){
            result[i-1]=i%15==0?"FizzBuzz":(i%3==0?"Fizz":(i%5==0?"Buzz":new Integer(i).toString()));
            System.out.println(result[i-1]);
        }
        return result;
    }
    public static void main(String args[]){
        String[] result = InterviewBitSolution.fizzBuzz(31);
        System.out.println(result);
    }
}
