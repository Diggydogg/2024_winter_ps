package week2.20250119;
//컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
public class DH009 {
    class Solution {
        int answer = 0; //20
        //int size = 0;
        public int solution(int n, int[][] computers) {
            //int answer = 0;
            
            boolean[]visited = new boolean[n];
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    DFS(i, n,computers, visited);
                    answer++;
                }
            }
            return answer;
        }
        public static void DFS(int idx,int n ,int[][]computers, boolean[]visited){
            visited[idx] = true;
            for(int i = 0; i < n; i++ ){
                if(computers[idx][i]==1 && !visited[i]){
                    DFS(i,n,computers,visited);
                }
            }
        }
        
    }
    
}
