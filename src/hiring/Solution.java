package hiring;

import java.io.*;
import java.util.*;


public class Solution {

    static Map<Character,Character> pairValue;
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<expression.length();i++){
            // pushing opening parentheses in stack, always
            if(pairValue.containsKey(expression.charAt(i)))
                stack.push(expression.charAt(i));

            if(!stack.empty() && pairValue.get(stack.peek())==expression.charAt(i))
                stack.pop();
            else if(stack.empty() && !pairValue.containsKey(expression.charAt(i)))
                return false;
        }
        return stack.empty()?true:false;
    }

    public static void main(String[] args) throws IOException {
        pairValue = new HashMap();
        pairValue.put('{','}');
        pairValue.put('[',']');
        pairValue.put('(',')');
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader(new File("ExpectedOutput.txt")));
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            String actual = (isBalanced(expression)) ? "YES" : "NO";
            String expected =br.readLine();
            if(!actual.equals(expected))
                System.out.println("TestCase "+(a0+1));
        }
    }
}
