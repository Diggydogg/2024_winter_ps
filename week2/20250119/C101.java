package week2;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42898
public class C101 {
    
class Solution {
    //dp 가 되는 경우
    // 오른쪽 아래쪽으로만 움직임 
    // 문제 못 읽음
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        //int[] dx = {0,1,0,-1};
        //int[] dy= {-1,0,1,0};
        int [][]dp = new int[m][n];
        boolean  [][]puddle = new boolean[m][n];
        for(int i = 0; i<puddles.length; i++){
            int x = puddles[i][0]-1; 
            int y = puddles[i][1]-1;
            puddle[x][y] = true; //mark puddle
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j]=0;
            }
        }
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(puddle[i][j]) {
                    dp[i][j]=0; 
                    continue;
                }
                if(i>0) dp[i][j]+=dp[i-1][j];
                if(j>0) dp[i][j]+=dp[i][j-1];
                
                dp[i][j]%=1000000007;
            }
        }
        answer = dp[m-1][n-1];
        return answer;
    }
    public boolean range(int x, int y, int m, int n){
        return (x>=0 && x<m && y >=0 && y < n);
    }
}
}
