package week1.20250108;
import java.util.*;

public class A078 {
   
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] cit = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(cit, Collections.reverseOrder());
        int n = citations.length;
        Arrays.sort(cit,Collections.reverseOrder());
        
        for(int i = 0; i < n; i++){
            int h = i+1;
            if(cit[i]>=h){
                if(answer<h) answer = h;
            }
        }
        return answer;
    }
}
}
