package week1;
//https://school.programmers.co.kr/learn/courses/30/lessons/42577
// 전화번호 목록 프로그래머스
import java.util.*;
import java.util.stream.*;
import java.io.*;

class A141 {
    public boolean solution(String[] phone_book) {
        phone_book = Arrays.stream(phone_book).sorted((s1, s2)->Integer.compare(s1.length(), s2.length())).toArray(String[]::new); // actually doesnt matter at all
        HashSet <String> h1 = new HashSet<>();
        for(String phone_number:phone_book){
            if(h1.isEmpty()) h1.add(phone_number);
            else {
                for(int i = 0; i < phone_number.length(); i++){
                    String pre = phone_number.substring(0,i);
                    if(h1.contains(pre)) return false;
                }
                h1.add(phone_number);
            }
        }
        
        boolean answer = true;
        return answer;
    }
}