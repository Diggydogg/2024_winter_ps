package week2.20250119;
import java.util.*;
import java.io.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/1843
public class DH006 {
    


class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int n = arr.length;
        int[][][]dp = new int [n][n][2]; // [start] [end] [0 : max , 1 : min]
        boolean [][][]visited = new boolean[n][n][2]; // same
        for(int i = 0; i <n; i+=2){
            int val = Integer.parseInt(arr[i]);
            dp[i][i][0] =val;
            dp[i][i][1] = val;
            visited[i][i][0] = true;
            visited[i][i][1] = true;
        }
        answer = DP(arr,0,n-1,0,dp, visited);
        
        
        return answer;
    }
    public int DP(String arr[],int start, int end, int mode, int[][][]dp, boolean[][][] visited){ // end include
        int max = 0; 
        int min = 1;
        int res = mode == max ? -9999999: 9999999;
        for(int i = start+1; i <end; i +=2){
            char oper = arr[i].charAt(0);
            int val; int v1 ; int v2;
            
            if(mode == max){ //find MAX 
                if(oper == '-'){ //  Max - Min 
                    v1 = !visited[start][i-1][0]? DP(arr, start, i-1, max,dp,visited): dp[start][i-1][max];
                    v2 = !visited[i+1][end][1] ? DP(arr, i+1, end, min, dp, visited) : dp[i+1][end][min];
                    val = v1 -v2;
                }
                else{ // +  , Max + Max
                    v1 = !visited[start][i-1][0]? DP(arr, start, i-1, max,dp,visited): dp[start][i-1][max];
                    v2 = !visited[i+1][end][0] ? DP(arr, i+1, end, max, dp, visited) : dp[i+1][end][max];
                    val = v1 + v2;
                }
            }else{ // mode == min, find min
                if(oper=='-'){ // min - max
                    v1 = !visited[start][i-1][1]? DP(arr, start, i-1, min,dp,visited): dp[start][i-1][min];
                    v2 = !visited[i+1][end][0] ? DP(arr, i+1, end, max, dp, visited) : dp[i+1][end][max];
                    val = v1 - v2;
                }else{ // +, min + min
                    v1 = !visited[start][i-1][1]? DP(arr, start, i-1, min,dp,visited): dp[start][i-1][min];
                    v2 = !visited[i+1][end][1] ? DP(arr, i+1, end, min, dp, visited) : dp[i+1][end][min];
                    val = v1 + v2; 
                }
                
            }
            res=mode==max ? Math.max(res, val) : Math.min(res, val);
        }
        visited[start][end][mode] = true;
        dp[start][end][mode] = res;
        return res;
    }
    
    
}
}
