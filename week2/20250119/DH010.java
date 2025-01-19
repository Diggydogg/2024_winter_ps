package week2.20250119;
import java.util.*;
import java.io.*;
//20
//https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class DH010 {
    

class Solution {
    int m = 0; int n = 0;
    public int solution(int[][] maps) {
        int answer = -1;
        m = maps.length;
        n = maps[0].length;        
        int dx[] = new int[4];
        int dy[] = new int[4];
        dx[0] = 0; dx[1] = 0; dx[2] = 1; dx[3] = -1;
        dy[0] = -1; dy[1] = 1; dy[2] = 0; dy[3] = 0;
            
        boolean [][] visited = new boolean[m][n];
        
        ArrayDeque<int[]>q =new  ArrayDeque<>();
        q.addLast(new int[]{0,0,1});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int []first =q.removeFirst();
            int x = first[0];
            int y = first[1];
            int cost = first[2];
            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                int nx =dx[i]+x;
                int ny = dy[i]+y;
                if(inRange(nx,ny)&&!visited[nx][ny]&&maps[nx][ny]==1){
                    if(nx==m-1 && ny==n-1) return cost+1;
                    q.addLast(new int[]{nx,ny,cost+1});
                    visited[nx][ny] = true; // <==== thuis is importanto
                    //System.out.println(nx+" : "+ny);
                }
                
            }
            
            
        }
        return answer;
    }
    public boolean inRange(int x, int y){
        return 0<=x && x < m && 0 <= y && y <n ;
    }
}
    
}
