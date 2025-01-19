package week2;
import java.util.*;
import java.util.stream.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class C099 {
    
    class Solution {
        public int[] solution(int brown, int yellow) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(int i = 1; i <= (int)Math.sqrt(yellow); i++){
                if(yellow%i==0){
                    int x = Math.max(i,yellow/i);
                    int y = Math.min(i, yellow/i);
                    if(brown ==((x+2)*2+y*2)){
                        res.add(x+2); res.add(y+2);
                    }
                }
            
            }
            int[] answer = res.stream().mapToInt(x->x).toArray();
            return answer;
        }
    }
}
