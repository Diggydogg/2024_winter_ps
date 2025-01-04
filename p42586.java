//https://school.programmers.co.kr/learn/courses/30/lessons/42586
// 기능 개발
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Pair{
    int p;
    int s;
    public Pair(int p, int s){
        this.p =p;
        this.s =s;
    }
    public int getP(){
        return p;
    }
    public int getS(){
        return s;
    }
}
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Pair>deque = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < speeds.length; i++){
            deque.addLast(new Pair(progresses[i], speeds[i]));//put progess, speeds in deque <pair>
        }
        
        while(!deque.isEmpty()){//one day cycle
            
            int size = deque.size();
            
            //daily progrss update
            for(int i = 0; i < size; i++){
                Pair top = deque.getFirst();
                deque.removeFirst();
                int cur_p = top.getP();
                int cur_s = top.getS();
                if(cur_p < 100){
                    cur_p+=cur_s;
                }
                deque.addLast(new Pair(cur_p, cur_s));
                
            }
            //check 
            int done = 0;
            while(!deque.isEmpty()){
                Pair top = deque.getFirst();
                
                int cur_p  = top.getP();
                int cur_s = top.getS();
                if(cur_p>=100){ // done ++, remove top and go on next 
                    done++;
                    deque.removeFirst();
                }
                else{ //nope, go to nxt day
                    break;
                }
            }
            if(done!=0){//update res
                res.add(done);
            }
        }
        
        
        int[] answer =res.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
