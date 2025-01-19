package week2.20250119;
import java.util.*;
import java.util.stream.*;
import java.io.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class A027 {
    
class Solution {
//     public String solution(String number, int k) {
//         String answer = "";
//         Deque<Character> deque = new ArrayDeque<>();
//         int popped = 0;
//         for(int i = 0; i < number.length() ; i++){
//             int num = (int)(number.charAt(i)-'0');
//             if(deque.isEmpty()||popped>=k){
//                 //max = number.charAt(i);
//                 deque.addLast(number.charAt(i)); // need boxed?/ nope auto boxing
//             }
//             else{
//                 int last = (int)(deque.getLast()-'0');
                
//                 if(last < num) { // last val is smaller than upcoming one
//                     deque.removeLast();
//                     popped++;
//                     i--;
//                 }
//                 else{
//                     deque.add(number.charAt(i));
//                 }
//             }
//         }
//         for(int i =popped; i < k; i++)deque.removeLast();
//         for(char a:deque)answer+=a;
//         return answer;
//     }
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
    
}
