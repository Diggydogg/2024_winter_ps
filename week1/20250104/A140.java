import java.util.*;
import java.io.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet <Integer> h1 = new HashSet <Integer>(); //init hashset int type
    
        for(int i  = 0 ; i < nums.length; i++){
            h1.add(nums[i]); //add hashset
        }
        if(h1.isEmpty()) return answer; // h1 is empty then no option than 0
        int hash_size = h1.size();
        int size = nums.length/2; 
        if(hash_size > size) return size; // if hashset size larger than size of choosing, then choosing size will be max val of answer
        else return hash_size; // else, size of hash which is total num of types of ponketmon will be answer
    }
}