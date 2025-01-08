package week1.20250108;
import java.util.*;
import java.util.stream.*;
import java.io.*;
public class A079 {
    
//https://school.programmers.co.kr/learn/courses/30/lessons/42748
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        //int[] answer = {};
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < commands.length; i++){
            int a = commands[i][0]-1; int b = commands[i][1]-1; int c = commands[i][2]-1;
            int val =Arrays.stream(array).skip(a).limit(b-a+1).sorted().skip(c).findFirst().orElse(-1);
            res.add(val);
        }
        int[] answer = res.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
    
}
