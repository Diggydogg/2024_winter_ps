package week2.20250119;
//https://school.programmers.co.kr/learn/courses/30/lessons/43164
import java.util.*;
import java.io.*;
public class DH013 {
    


class Solution {
    public String[] solution(String[][] tickets) {
        
        String[] answer = {};
        
        boolean[] visited = new boolean[tickets.length];
        ArrayList<List<String>> arr = new ArrayList<>();
        ArrayList<String> cur = new ArrayList<>();
        cur.add("ICN");
        DFS("ICN",tickets, arr, cur, visited );
        System.out.println(arr.size());
        if(arr.size() >1){
            //arr.sorted((a,b)->String.compare(a,b));
            Collections.sort(arr, (a, b)-> compareLists(a,b));
            // for(List<String> L : arr){
            //     System.out.print("[");
            //     for(String s : L){
            //         System.out.print(s+" ");
            //     }
            //     System.out.println("]");
            // }
        }
        answer = arr.get(0).toArray(new String[0]);
        return answer;
    }
    
    public void DFS(String start, String [][] tickets, ArrayList<List<String>> arr, ArrayList<String>cur, boolean [] visited){
        if(cur.size() == tickets.length+1){
            arr.add(cur);
            return;
        }
        else{
            for(int i =0; i < tickets.length; i++){
                if(!visited[i]&&tickets[i][0].equals(start)){
                    boolean[] newVisited = Arrays.copyOf(visited, visited.length);
                    newVisited[i] = true;
                    ArrayList<String>newCur = new ArrayList<>(cur);
                    newCur.add(tickets[i][1]);
                    DFS(tickets[i][1],tickets, arr, newCur, newVisited);
                }
            }
        }
    }
    
    public static int compareLists(List<String> list1, List<String> list2) {
        for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
            int comparison = list1.get(i).compareTo(list2.get(i));
            if (comparison != 0) {
                return comparison; // 첫 번째로 다른 요소의 결과 반환
            }
        }
        // 길이가 다를 경우, 요소 개수로 비교
        return Integer.compare(list1.size(), list2.size());
    }
    
}
}
