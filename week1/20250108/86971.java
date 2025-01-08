package week1.20250108;
//https://school.programmers.co.kr/learn/courses/30/lessons/86971
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class 86971 {
    

class Solution {
    public int solution(int n, int[][] wires) {
        int answer =101;
        for(int i = 0; i <wires.length; i++){
            
            ArrayList<List<Integer>>wire = new ArrayList<>();
            for(int v =0; v <=n; v++){
                wire.add(new ArrayList<>());
            }
            
            boolean[] visited = new boolean[n];
            for(int j = 0; j< wires.length; j++){
                if(i==j) continue;
                int v1 = wires[j][0];
                int v2 = wires[j][1];
                wire.get(v1).add(v2);
                wire.get(v2).add(v1);
                
            }
            dfs(wire, visited,1);
            int cnt = 0;
            for(int j = 0; j < visited.length; j++){
                if(visited[j])cnt++;
            }
            System.out.println(i+": "+cnt);
            answer = Math.min(answer,Math.abs( n -2* cnt));
        }
        return answer;
    }
    public static void dfs(List<List<Integer>>wire, boolean[] visited, int start){
        if(!visited[start-1]){
            visited[start-1] = true;
            for(int nxt : wire.get(start)){
                if(!visited[nxt-1]){
                    //System.out.println("DFS:"+start+"=>"+nxt);
                    dfs(wire, visited, nxt);
                    
                }
            }
        }
         
    }
}
    
}
