package week1.20250108;
import java.util.*;
import java.io.*;
import java.util.stream.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class A075 {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
           
            List<String>res =Arrays.stream(numbers).mapToObj(String::valueOf).sorted((x,y)->(y+x).compareTo(x+y)).collect(Collectors.toList());
            //for(String k:res)System.out.print(k);
            if(res.get(0).equals("0")) return "0";
            answer = String.join(answer,res);
            return answer;
        }
    }
}
