package week2.20250119;
import java.util.*;
import java.io.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/84021
public class DH014 {
    



class Solution {
    int dx[] = new int[4]; // <- better of using : static final int[] dy = { -1, 1, 0, 0 };
    int dy[] = new int[4];
    int n;
    
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        ArrayList<ArrayList<int[]>> board = new ArrayList<>();
        ArrayList<ArrayList<int[]>> puzzle = new ArrayList<>();
        n = game_board.length; // n is size of game_board & table
        //dx, dy setting
        dx[0] = 0; dx[1] = 0; dx[2] = 1; dx[3] = -1;
        dy[0] = -1; dy[1] = 1; dy[2] = 0; dy[3] = 0;
        
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(game_board[i][j]==0){
                    ArrayList<int[]> res = new ArrayList<>();
                    game_board[i][j] = 1; // mark visited,
                    DFS(i, j, game_board, res, 0);
                    board.add(res);
                }
                if(table[i][j]==1){
                    ArrayList<int[]> res1 = new ArrayList<>();
                    table[i][j] = 0; //mark visited
                    DFS(i, j, table, res1, 1);
                    puzzle.add(res1);
                }
            }
        }
        //fitting
        boolean [] used = new boolean[puzzle.size()];
        for(ArrayList<int[]>res:board){
            for(int i = 0; i < puzzle.size(); i++){
                boolean fit = false;
                if(used[i]||puzzle.get(i).size()!=res.size() ) continue; // already used or puzzle size doesnt match with empty space in game board
                for(int j = 0; j < 4; j++){ // rotate 0. ~ 270
                    if(compare_puzzle(res, puzzle.get(i))){
                        used[i] = true;
                        answer+= puzzle.get(i).size();
                        fit = true;
                        break; // break for loop ratation
                    }
                    rotate(puzzle.get(i));
                }
                if(fit)break; // if puzzle fitted in board , break for - puzzle loop
            }
        }
        
        
        return answer;
    }
    public void DFS(int x, int y, int[][]game_board, ArrayList<int[]> res, int mode){
        res.add(new int[]{x,y});
        
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i]; int ny = y+ dy[i];
            if(inRange(nx, ny)&&game_board[nx][ny]==mode){
                game_board[nx][ny] = (~ (mode));// 0 -> 1 , 1 -> 0
                DFS(nx,ny, game_board,res, mode);
            }
        }
    }
    public boolean inRange(int x, int y){
        return 0<=x && x < n && 0<=y && y < n;
    }
    public boolean compare_puzzle(ArrayList<int[]> board,ArrayList<int[]>puzzle){
        board.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        puzzle.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] diff = new int[2];
        diff[0] = board.get(0)[0] - puzzle.get(0)[0];
        diff[1] = board.get(0)[1] - puzzle.get(0)[1];
        for (int i = 0; i < board.size(); i++) {
            if (!(board.get(i)[0] == diff[0] + puzzle.get(i)[0] &&
                  board.get(i)[1] == diff[1] + puzzle.get(i)[1])) {
                return false;
            }
        }

        return true;
    }
    public void rotate(ArrayList<int[]>res){
        for(int [] p : res){
            int x = p[1]; int y = n - p[0]-1;
            p[0] = x; p[1] = y;
        }
    }
    
}
}
