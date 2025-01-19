package week2.20250119;
//https://school.programmers.co.kr/learn/courses/30/lessons/42861
import java.util.*;
import java.io.*;

public class DH003 {
    class Solution {
        public int solution(int n, int[][] costs) {
            int[][] cost_arr = Arrays.stream(costs).sorted((x,y)->Integer.compare(x[2],y[2])).toArray(int[][]::new);
            // parent[dst] = dst;
            int[] parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
            int answer = 0;
            for(int i = 0; i < cost_arr.length; i++){ // get parennntttttttt unioooooooonnnnn fiiiiiinnnddd
                int dst = cost_arr[i][0];
                int arv = cost_arr[i][1];
                int cost = cost_arr[i][2];
                int p_dst = getParent(parent,dst);
                int p_arv = getParent(parent,arv);
                if(p_dst == p_arv)continue; // already joined
                int p = Math.min(p_dst, p_arv);
                parent[p_dst] = p;
                parent[p_arv] = p;
                answer+=cost;
            }
            return answer;
        }
        public static int getParent(int[] parent,int x){
            if(parent[x]==x) return parent[x];
            int p = parent[x];
            parent[x] = getParent(parent,p);
            return parent[x];
        }
    }
    
}
