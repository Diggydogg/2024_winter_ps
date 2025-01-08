//https://school.programmers.co.kr/learn/courses/30/lessons/42576
//완주하지 못한 선수 프로그래머스
import java.util.*;
import java.util.stream.*;
import java.io.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> h1 = new HashMap<>();
        for(int i =0; i <participant.length; i++){
            if(!h1.containsKey(participant[i]))h1.put(participant[i],1);
            else{
                int val = h1.get(participant[i]);
                h1.replace(participant[i],val, val+1);
            }
        }
       
        for(int i = 0; i < completion.length; i++){
            
            int val = h1.get(completion[i]);
            if(val==1) h1.remove(completion[i]);
            else h1.replace(completion[i],val,val-1);
            
        }
        for(String key: h1.keySet()) return key;
        
        
        return answer;
    }
}