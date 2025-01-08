//https://school.programmers.co.kr/learn/courses/30/lessons/42626
package week1.20250108;
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class A096 {
    

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq =new  PriorityQueue<Integer>();
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(!pq.isEmpty()){
            int top = pq.peek();
            if(top>= K) return answer; // lowest scovil >= K return answer
            if(top<K){//case of lowest scovil < K
                if(pq.size()<2) return -1; // impossible
                top = pq.poll();
                int nxt = 2*pq.poll()+top;
                
                pq.add(nxt);
                answer++;
            }
        }
        return answer;
    }
}
}
