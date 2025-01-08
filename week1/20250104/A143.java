//https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 올바른 괄호 프로그래머스
package week1;

import java.util.*;
import java.util.stream.*;
import java.io.*;


class A143 {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < s.length();i++){
            Character cur_item = s.charAt(i);
            if(!deque.isEmpty() && deque.getLast().equals('(') &&cur_item.equals(')')){ //case of elimination 
                deque.removeLast();
            }else{ //else add
                deque.addLast(cur_item);
            }
            
        }
        if(deque.isEmpty()) return true; 
        else return false;
        
        
        
    }
}
