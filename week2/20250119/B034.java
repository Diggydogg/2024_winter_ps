package week2.20250119;
//https://school.programmers.co.kr/learn/courses/30/lessons/42862
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class B034 {
   

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashSet<Integer> resvSet = new HashSet<>(Arrays.stream(reserve).boxed().collect(Collectors.toSet()));
        HashSet<Integer> lostSet = new HashSet<>(Arrays.stream(lost).boxed().collect(Collectors.toSet()));
        PriorityQueue<Integer> lostQue = new PriorityQueue<>();
        PriorityQueue<Integer> resQue = new PriorityQueue<>();
        
        for(int i = 0; i < lost.length; i++){
            if(!resvSet.contains(lost[i]))lostQue.add(lost[i]);
        }
        for(int i = 0; i < reserve.length; i++){
            if(!lostSet.contains(reserve[i]))resQue.add(reserve[i]);
        }
        //System.out.println(lostQue.size()+" "+resQue.size());
        while(!resQue.isEmpty()){
            if(lostQue.isEmpty())break;
            int res_size = resQue.peek();
            int lost_size = lostQue.peek();
            if((res_size -1 <= lost_size) && (lost_size <= res_size+1)){
                lostQue.poll();
                resQue.poll();
            }
            else if(lost_size < res_size-1){ // lost size is small for res size
                answer--;
                lostQue.poll();
            }
            //lost size is too big for reserve size
            else resQue.poll();
        }
        answer -= lostQue.size();
        
        
        return answer;
    }
}
    
}
