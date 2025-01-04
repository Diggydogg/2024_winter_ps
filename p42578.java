import java.util.*;
import java.util.stream.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> h1 = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String type = clothes[i][1];
            if(!h1.containsKey(type)){
                h1.put(type,1);
            }
            else{
                int val = h1.get(type);
                h1.replace(type,val+1);
            }
        }
        int answer = 1;
        for(String key: h1.keySet()){
            answer*=(h1.get(key)+1);// +1 means case of not wear
        }
        answer = answer-1; // -1. case of not wear any of clothes
        
      
        
        return answer;
        
    }
}