import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42897
import java.io.*;
public class DH007{
    class Solution {
        public int solution(int[] money) {
            int n = money.length;
            //int [][] dp = new int [n][2]; reason why it should not used,, cause spatial memory access, OS, CS 
            int [][]dp = new int [2][n];
            int answer = 0;
            dp[0][0] = money[0];
            dp[0][1] = money[0];
            
            dp[1][0] = 0;
            dp[1][1] =money[1];
            int  v1,v2 =0;
            for(int i = 2; i < n; i++){
                dp[0][i] =  Math.max(money[i]+dp[0][i-2], dp[0][i-1]);
                dp[1][i] = Math.max(money[i]+dp[1][i-2], dp[1][i-1]);
                
            }
            answer = Math.max(dp[0][n-2], dp[1][n-1]);
            
            
            return answer;
        }
    }
}