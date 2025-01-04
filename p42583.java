package week1;
//https://school.programmers.co.kr/learn/courses/30/lessons/42583
// 다리를 지나는 트럭 프로그래머스
import java.util.*;
import java.util.stream.*;
import java.io.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer>bridge = new ArrayDeque<>();
        Deque<Integer>wait = new ArrayDeque<>();
        for(int i = 0; i < truck_weights.length; i++){
            wait.addLast(truck_weights[i]);
        }
        for(int i =0; i < bridge_length; i++){
            bridge.addLast(0); // space null
        }
        int bw  = 0; // cur bridge weight
        int done = 0; // no truck crossed bridge
        while(true){
            answer++;
            if(!bridge.isEmpty()){
                int a = bridge.removeFirst();
                if(a!=0)done++;
                if(done == truck_weights.length) return answer;
                bw-=a; // update weight of bridge
            }
            if((bridge.size()<bridge_length)&&(!wait.isEmpty()) &&(bw+wait.getFirst()<=weight)){// if weight & length of bridge can capacitiate new truck 
                int a = wait.removeFirst();
                bw+=a;
                bridge.addLast(a);
            }
            else{ // space added
                bridge.addLast(0);
            }
        }
    }
}
