package week2.20250119;
//https://school.programmers.co.kr/learn/courses/30/lessons/42885
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class A016 {
    
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //point of this problem is, pair with heaviest ppl with lightest
        ArrayList<Integer> ppl = Arrays.stream(people).sorted().boxed().collect(Collectors.toCollection(ArrayList::new));
        int l = 0; int j = people.length-1;
        while(l<j){
            int base = ppl.get(j);
            int w = base;
            if(l<j&&w+ppl.get(l)<=limit){
                w+=ppl.get(l);
                l++;
            }
            
            answer++;
            j--;
            
        }
        if(l==j){answer++;} // case one ppl left, need one more boat
        
        return answer;
    }
}
}
