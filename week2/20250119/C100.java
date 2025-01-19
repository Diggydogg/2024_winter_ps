package week2.20250119;
import java.util.*;
import java.util.stream.*;
import java.io.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class C100 {
    

// I will use dp knapsack and compare with BruteForce

// dp knapsack -> cost == availability(only requirment is , can handle cost)
// but this problem is, cost !== availability, 
// utilize of cost not always promise the best output due to above restriction
// so it only can be used bruteForce algo?

// or try 3 dimensional DP array, whcih memo layer(dungeon total),cost, available(require) cost, 
// nope doesnt work
// knapsack only can be applied where order doesnt matter to output,
//
public class Pair{
    int req;
    int cost;
    public Pair(int req, int cost){
        this.req = req; 
        this.cost = cost;
    }
    public int getR(){
        return req;
    }
    public int getC(){
        return cost;
    }
}

class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        //int answer = -1;
        int[] max ={0};
        // ArrayList<Pair>arr = new ArrayList<>();
        // for(int i = 0; i < dungeons.length; i++){
        //     int req = dungeons[i][0];
        //     int cost = dungeons[i][1];
        //     arr.add(new Pair(req,cost));
        // }
        // permutation(arr, new ArrayList<Pair>(),k, max);
        // System.out.println(max[0]);
        dfs(k, dungeons, new boolean[dungeons.length], 0);
        return answer;
    }
    public static void dfs(int k, int[][]dungeons, boolean[]visited,int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i< dungeons.length; i++){
            int req = dungeons[i][0];
            int cost = dungeons[i][1];
            if(!visited[i]&&k>=req){
                visited[i] = true;
                dfs(k-cost, dungeons, visited, cnt+1);
                visited[i]= false;
            }
        }
    }
    
    
    public static void permutation(List<Pair>arr,List<Pair>cur,int k, int[]max){
        if(!cur.isEmpty()){
            max[0] = Math.max(max[0], cur.size());
        }
        
        for(int i = 0; i < arr.size(); i++){
            Pair p = arr.get(i);
            int req = p.getR();
            int cost = p.getC();
            if(k>=req){
                ArrayList<Pair> newArr = new ArrayList<Pair>(arr);
                newArr.remove(i);
                cur.add(new Pair(req,cost));
                permutation(newArr, cur,k-cost,max);
                cur.remove(cur.size()-1);
            }


        }
        
        
    }
    
    
        
        
        
        
    
}
}
