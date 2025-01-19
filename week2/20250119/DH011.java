package week2.20250119;
//https://school.programmers.co.kr/learn/courses/30/lessons/43163
import java.util.*;
import java.io.*;
//35
public class DH011 {
    

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        ArrayDeque <int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{-1,0});
        boolean[] visited = new boolean[words.length];
    
        //visited[0] = true;
        while(!q.isEmpty()){
            int[] cur = q.removeFirst();
            int idx = cur[0];
            int cost = cur[1];
            String cur_word = idx == -1 ? begin : words[idx];
            //System.out.println("cur word: "+cur_word +" cost: "+cost);
            for(int i = 0; i < words.length; i++){
                if(!visited[i]&&stringCompare(cur_word,words[i])){
                    //System.out.println(cur_word+"---->"+words[i]+" : "+(cost+1));
                    if(words[i].equals(target)) return cost+1;
                    q.addLast(new int[]{i,cost+1});
                    visited[i] = true;
                }
                    
            }
        }
        return answer;
    }
    public boolean stringCompare(String a, String b){
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            char c_a = a.charAt(i);
            char c_b = b.charAt(i);
            if(c_a != c_b)cnt++;
            if(cnt>1) {
                System.out.println("Str cmp : "+a +" "+b);
                return false;
            }
        }
        return true;
    }
                      
                      
}
}
