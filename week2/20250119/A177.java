package week2.20250119;
import java.util.*;
import java.util.stream.*;
import java.io.*;


public class A177 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x_m = 0;
        int y_m = 0;
        for(int i = 0; i < sizes.length; i++){
            int x =  sizes[i][0];
            int y = sizes[i][1];
            if((x<=x_m && y<=y_m )||(y<=x_m && x <=y_m)) continue;
            if(Math.max(x_m,x)*Math.max(y_m,y) < Math.max(y_m,x)*Math.max(x_m,y)){
                x_m = Math.max(x_m,x);
                y_m = Math.max(y_m,y);
            }
            else{
                x_m = Math.max(x_m, y);
                y_m = Math.max(y_m, x);
            }
            answer = x_m * y_m;
        }
        return answer;
    }

    
}
