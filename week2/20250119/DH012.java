package week2.20250119;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/87694
import java.io.*;
public class DH012 {
    

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int [][]maps = new int[102][102];
        boolean [][]visited = new boolean[102][102];
        
        //draw line
        for(int i =0; i < rectangle.length; i++){
            int x = 2*rectangle[i][0]; int y = 2*rectangle[i][1];
            int x1 = 2*rectangle[i][2]; int y1 = 2*rectangle[i][3];
            draw(maps, x,y,x1,y1);
        }
        //empty inner
        for(int i =0; i < rectangle.length; i++){
            int x = 2*rectangle[i][0]; int y = 2*rectangle[i][1];
            int x1 = 2*rectangle[i][2]; int y1 = 2*rectangle[i][3];
            //erase(maps, x,y,x1,y1);
            for(int a = x+1; a < x1; a++){
                for(int b = y+1; b < y1; b++){
                    maps[a][b] = 0;
                }
            }
        }
        //BFS
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast( new int[]{2*characterX, 2*characterY, 0});
        visited[2*characterX][2*characterY] = true;
        
        int []dx = new int[4]; dx[0] = 0; dx[1] = 0; dx[2] = 1; dx[3] = -1;
        int []dy = new int[4]; dy[0] = -1; dy[1] = 1; dy[2] = 0; dy[3] = 0;
        
        while(!q.isEmpty()){
            int [] first = q.removeFirst();
            int x = first[0]; int y = first[1]; int cost = first[2];
            for(int i = 0; i < 4; i++){
                int nx = dx[i]+x;
                int ny = dy[i]+y;
                if(inRange(nx,ny)&&!visited[nx][ny]&&maps[nx][ny]==1){
                    if(nx==2*itemX && ny==2*itemY) return (cost+1)/2;
                    visited[nx][ny] = true;
                    q.addLast(new int[]{nx,ny,cost+1});
                }
            } 
            
            
            
            
            
            
        }
        
        
        return answer;
    }
    public void draw(int[][]maps,int x, int y, int x1, int y1){
        //x
        for(int i = x; i<=x1; i++){
            maps[i][y1] =1;
            maps[i][y] =1 ;
        }
        //y
        for(int i = y; i<=y1; i++){
            maps[x][i] =1 ;
            maps[x1][i] =1 ;
        } 
    }
    public boolean inRange(int x, int y){
        return 0<=x && x < 102 &&  0 <=y && y < 102;
    }
}
}
