package week2.20250119;
import java.util.*;
import java.io.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/43105
public class D015 {
    

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int [][]dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i =1 ; i <triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                int cur = triangle[i][j];
                if(j==0){//no upper left
                    dp[i][j]= dp[i-1][j]+cur;
                }
                else if(j== triangle[i].length-1){//no upper right
                    dp[i][j] = dp[i-1][j-1]+cur;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+cur;
                }
            }
        }
        for(int i = 0; i < triangle[triangle.length-1].length; i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }
        
        
        
        
        return answer;
    }
}
}
