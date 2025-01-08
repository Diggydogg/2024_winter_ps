package week1.20250108;
import java.util.*;
import java.util.stream.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class A144 {
    
class Solution {
    public static int answer= 0;
    public int solution(String word) {
        //int answer = 0;
        String arr = "AEIOU";
        int[] cnt = {0};
        permutation(arr, "",word,cnt);
        return answer;
    }
    
    
    public void permutation(String arr, String cur,String word,int[] cnt){
        if(cur.length()<6){//dic.add(cur);
            if(cur.equals(word)){
                answer = cnt[0];
                return;
            }

            for(int i = 0; i < arr.length(); i++){
                Character c = arr.charAt(i);
                String newCur = cur;
                if(cur.length()<5){
                    newCur+=c;
                    cnt[0]++;
                    permutation(arr,newCur,word,cnt);
                }
                //cur.substring(cur.length()-1);
            }

        }
    }
}

}
