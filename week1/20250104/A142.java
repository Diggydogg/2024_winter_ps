//https://school.programmers.co.kr/learn/courses/30/lessons/12906
// 같은 숫자는 싫어 프로그래머스
import java.util.*;
import java.io.*;
public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer>deque = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            int var = arr[i];
            if(deque.isEmpty()||deque.getLast()!=var){
                deque.addLast(var);
            }
        }
        int[] answer = deque.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}