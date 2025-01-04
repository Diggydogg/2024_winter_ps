package week1;
//https://school.programmers.co.kr/learn/courses/30/lessons/42584
// 주식 가격  프로그래머스
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Pair{
    int price;
    int idx;
    public Pair(int price,int idx){
        this.price = price;
        this.idx = idx;
    }
    public int getPrice(){
        return price;
    }
    public int getIdx(){
        return idx;
    }
}


class Solution {
    public int[] solution(int[] prices) {
        
        
        Deque<Pair> deque = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>(prices.length);
        for(int i = 0; i <prices.length; i++) res.add(0);
        for(int i = 0; i < prices.length; i++){
            int price = prices[i];
            //traverse que
            int size = deque.size();
            while(size>0){ // traverse all queue for checking price fall 
                Pair front = deque.removeFirst();
                int cur_price = front.getPrice();
                int cur_idx = front.getIdx();
                if(cur_price > price){//record to res
                    int t = i - cur_idx;
                    res.set(cur_idx,t);
                }
                else{ // no fall. put back to que
                    deque.addLast(new Pair(cur_price, cur_idx));
                }
                size--;
            }
            // and addLast
            deque.addLast(new Pair(price,i));
            
        }
        
        //for last traverse 
        int i = prices.length-1;
        int size = deque.size();
        while(!deque.isEmpty()){ // traverse all queue for checking price fall 
            Pair front = deque.removeFirst();
            int cur_price = front.getPrice();
            int cur_idx = front.getIdx();
            //record to res
            int t = i - cur_idx;
            res.set(cur_idx,t);
        }
        int[] answer = res.stream().mapToInt(n->n).toArray();
        
        return answer;
    }
}
