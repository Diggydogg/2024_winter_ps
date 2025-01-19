package week2.20250119;
//https://school.programmers.co.kr/learn/courses/30/lessons/42895
import java.util.*;
public class DH005 {
    

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1; // bas
        HashSet<Integer> all = new HashSet<>();
        ArrayList<HashSet<Integer>> memo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            memo.add(new HashSet<>());
        }
        
        // N, NN, NNN, ... inint
        for (int t = 0; t < 8; t++) {
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(t + 1)); 
            
            if(!all.contains(repeatedN)){
                memo.get(t).add(repeatedN);
                all.add(repeatedN);
            }
            if (repeatedN == number) return t + 1;
        }
        
        // DP 
        for (int t = 1; t < 8; t++) {
            for (int i = 0; i < t; i++) {
                for (Integer v1 : memo.get(i)) {
                    for (Integer v2 : memo.get(t - i - 1)) {
                        // HashSet in DP[t]
                        HashSet<Integer> tempSet = new HashSet<>();
                        if(!all.contains(v1+v2))tempSet.add(v1 + v2);
                        
                        if(!all.contains(v1-v2))tempSet.add(v1 - v2);
                        if(!all.contains(v1-v2))tempSet.add(v2 - v1);
                        if(!all.contains(v1*v2))tempSet.add(v1 * v2);
                        if (v2 != 0 && !all.contains(v1/v2)) tempSet.add(v1 / v2);
                        if (v1 != 0&& !all.contains(v2/v1)) tempSet.add(v2 / v1);
                        
                        // check curr
                        if (tempSet.contains(number)) return t + 1;
                        
                        
                        //memo add + all
                        memo.get(t).addAll(tempSet);
                        all.addAll(tempSet);
                    }
                }
            }
        }
        
        return -1; // over 8 step
    }
}

}
