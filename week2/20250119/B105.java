package week2.20250119;
//https://school.programmers.co.kr/learn/courses/30/lessons/42840
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class B105 {
    public int[] solution(int[] answers) {
        
       
        
        ArrayList<ArrayList<Integer>>cand = new ArrayList<>();
        cand.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        cand.add(new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5)));
        cand.add(new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)));
        int c1 = 0; int c2 = 0; int c3 = 0;
        int size1 = 5;
        int size2 = cand.get(1).size();
        int size3 = cand.get(2).size();
        for(int i =0; i <answers.length; i++){
            int ans = answers[i];
            //cand1
            int cand1 = cand.get(0).get(i%size1);
            if(cand1 == ans) c1 ++;
            //cand2
            int cand2 = cand.get(1).get(i%size2);
            if(cand2 == ans)c2 ++;
            
            //cand3
            int cand3 = cand.get(2).get(i%size3);
            if(cand3==ans)c3++;
            
        }
        ArrayList<Integer>res = new ArrayList<>();
        int max_val = Math.max(c1, Math.max(c2, c3));
        if(max_val==c1)res.add(1);
        if(max_val==c2)res.add(2);
        if(max_val==c3) res.add(3);
        int [] answer = res.stream().mapToInt(x->x).toArray();
        return answer;
    }
    
}
