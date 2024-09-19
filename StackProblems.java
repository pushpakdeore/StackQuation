package pushpak31stackquation;
import java.util.*;

public class StackProblems {
    public static void main(String[] args) {
        //Balanced Parantheses
        String parentheses = "{[()]}";
        System.out.println("Balanced Parentheses: " + isBalanced(parentheses));
        String paren = "{[(]}";
        System.out.println("Balanced Parentheses: " + isBalanced(paren));

        // Reverse Stack
        Stack<Integer> stackToReverse = new Stack<>();
        stackToReverse.push(1);
        stackToReverse.push(2);
        stackToReverse.push(3);
        stackToReverse.push(4);
        System.out.println("orignal stack "+stackToReverse);
        System.out.println("Reversed Stack: " + reverseStack(stackToReverse));

        // Sort a Stack
        Stack<Integer> stackToSort = new Stack<>();
        stackToSort.push(3);
        stackToSort.push(1);
        stackToSort.push(4);
        stackToSort.push(2);
        System.out.println("Orignal Stack : "+stackToSort);
        System.out.println("Sorted Stack: " + sortStack(stackToSort));
       ///Minstack
        MinStack s = new MinStack();
        s.push(10);
        s.push(12);
        s.push(56);
        s.push(43);

        System.out.println(s.getMin());
        System.out.println(s.top());
        s.pop();
        System.out.println(s);

        //implement Queue using stack
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());



    }
    //1. Balanced Parentheses: Check if a string containing parentheses is balanced using a
    //Stack.
    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c =='[' || c =='{' || c=='('){
                stack.push(c);
            }else if( c ==']'|| c =='}' || c ==')'){
                if(stack.empty() || !isMatchingPair(stack.pop(),c))
                    return false;
            }
        }
        return stack.empty();

    }

    private static boolean isMatchingPair(char char1, char char2) {
        return (char1 == '(' && char2 == ')') ||
                (char1 == '[' && char2 == ']') ||
                (char1 == '{' && char2 == '}');
    }

    // 2. Reverse a Stack
    public static Stack<Integer> reverseStack(Stack<Integer>stackToReverse){
        Stack<Integer> reversed = new Stack<>();
        while (!stackToReverse.empty()){
            reversed.push(stackToReverse.pop());
        }
        return reversed;
    }
    // 3. Sort a Stack
   public static  Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> sorted = new Stack<>();
        while (!stack.isEmpty()){
            int temp = stack.pop();
            while (! sorted.isEmpty() && sorted.peek()<temp){
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }
        return sorted;
   }
   //6. Min Stack: Design a Stack that supports push, pop, top, and retrieving the minimum
    //element in constant time.
    static  class MinStack{
        Stack<Integer> stack  = new Stack<>();
        Stack<Integer> minstack  =new Stack<>();

        public void  push(int x) {
            stack.push(x);
            if (minstack.isEmpty() || x <= minstack.peek()) {
                minstack.push(x);
            }
        }

        public void pop(){
            int x = stack.pop();
            if(x == minstack.peek()){
                minstack.pop();
            }
        }
        public int top(){
            return stack.peek();
        }
        public int getMin(){
            return minstack.peek();
        }
        @Override
       public String toString(){
            return "stack : "+stack.toString() + "Min stack:"+minstack.toString();

        }

    }
    //10. Implement Queue Using Stacks: Implement a queue using two stacks.

     static public class QueueUsingStacks{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer > s2 =new Stack<>();

        public void enqueue(int x){
            s1.push(x);

        }
        public  int dequeue(){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }


}








