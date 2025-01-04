//https://school.programmers.co.kr/learn/courses/30/lessons/42587
// 프로세스  프로그래머스
package week1;
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Pair{
    int p;
    int idx;
    public Pair(int p, int idx){
        this.p = p;
        this.idx = idx;
    }
    public int getP(){
        return p;
    }
    public int getIdx(){
        return idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Pair> deque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int answer = 1;
        
        for(int i =0;i < priorities.length; i++){
            deque.addLast(new Pair(priorities[i], i));
            pq.add(priorities[i]);
        }
        while(!deque.isEmpty()){
            Pair top =deque.getFirst();
            deque.removeFirst(); // delete deque automatically
            int p = top.getP(); int idx = top.getIdx();
            if(pq.element()==p){
                //case of idx == getIdx
                if(location== idx) return answer;
                //delete pq 
                pq.remove();
                answer++;
               
            }
            else{//addLast deque -> case of process hasnt detach
                deque.addLast(new Pair(p,idx));
            }
        }
        return answer;
    }
}