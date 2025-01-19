//고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지
//https://school.programmers.co.kr/learn/courses/30/lessons/42884
import java.util.*;
import java.io.*;

public class DH004{
    class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes,(x,y)->Integer.compare(x[0],y[0]));
            int answer = 0;
            int tail = -99999;
            for(int i = 0; i < routes.length;i++){
                int tail_now = routes[i][1];
                int head_now = routes[i][0];
                if(tail<head_now){
                    answer++;
                    tail = tail_now;
                }
                else{
                    if(tail > tail_now) tail = tail_now;
                    
                }
            }
            return answer;
        }
    }
}