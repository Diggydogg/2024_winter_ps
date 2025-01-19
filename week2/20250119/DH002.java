//https://school.programmers.co.kr/learn/courses/30/lessons/42860
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class DH002{
    class Solution {
        public int solution(String name) {
            
            int answer = 0;
            int n = name.length();
            int move_cur = n-1;
            for(int i = 0; i < n; i++){ // find the 'A' to set last of index
                
                if(name.charAt(i)=='A'){ // i will be start idx of concurrent 'A'
                    int last = i;
                    while(last<n&&name.charAt(last)=='A'){
                        last++;
                    }
                    int left = i == 0 ? 0 :  i-1; // means, movement of left size of A's
                    int right = n - last; // movement of right side of A;s
                    move_cur = Math.min(move_cur, left+right+Math.min(left,right) );
                }
                
            }
            answer+=move_cur;
            for(char a: name.toCharArray()){
                answer+=Math.min((int)(a-'A'),(int)(1+'Z'-a));
            }
            return answer;
        }
        // read the Q carefully
        
        // public static int dfs(int cur_char, int cur_idx, boolean[]visited, List<Integer>alp){
        //     int target_char = alp.get(cur_idx);
        //     int moved = Math.min(26+cur_char - target_char ,Math.abs( target_char - cur_char));
        //     visited[cur_idx] = true;
        //     int left = 99999;
        //     int go_left = (cur_idx-1+alp.size())%alp.size(); 
        //     int right = 99999;
        //     int go_right = (cur_idx+1)%alp.size();
        //     if(!visited[go_left]) left= dfs(target_char, go_left, visited, alp)+1;
        //     if(!visited[go_right]) right = dfs(target_char, go_right, visited, alp)+1;
        //     visited[cur_idx]= false;
        //     if(visited[go_left]&&visited[go_right]) return moved;
        //     return Math.min(left,right)+moved;
        // }
        
        
        

    }
}