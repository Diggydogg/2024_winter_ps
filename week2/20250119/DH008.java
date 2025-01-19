package week2.20250119;
import java.util.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class DH008 {
    

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        //int answer = 0;
        int n = numbers.length;
        boolean []oper  = new boolean[n];
        DFS(0, 0, target, numbers);
        
        return answer;
    }
    public void DFS( int start,int val ,int target,int[]numbers){
        if(start == numbers.length){
            if(val == target) answer++;
        }
        else{
            DFS(start+1, val+numbers[start], target, numbers);
            DFS(start+1, val-numbers[start], target, numbers);
        }
        
        
    }
    
}

}
