package week1.20250108;
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class D014 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {0,0};
            // I input 
            // D - : Delete Min
            // D : delete Max
            int size = 0;
            
            int old_q = 0;
            int new_q = 1; // can be switch
            ArrayList<PriorityQueue<Integer>>pq = new ArrayList<>(); //**
            pq.add( new PriorityQueue<Integer>() );// pq.get(0) min pq
            pq.add(new PriorityQueue<Integer>(Comparator.reverseOrder())); //pq.get(1) max pq
            
            for(String command: operations){
                Character opt = command.charAt(0);
                if(opt.equals('I')){//case input
                    int val = Integer.valueOf(command.substring(2)); //auto un boxed
                    // Add to old queue
                    pq.get(old_q).add(val);
                    
                }else{ // case Delete
                    if(pq.get(old_q).isEmpty())continue;// If queue size is Empty, skip
                    if(command.charAt(2)=='-'){ // Delete min
                        // if old queue is min queue. use min queue -> delete
                        if(old_q == 0){
                            int val = pq.get(old_q).poll();
                            //System.out.println("D -1: "+val);
                        }
                        // if old queue is max queue. add All to new queue, ptr old. to new_q = old_q, old_q ,new_q swap(old_q,new_q)
                        else{
                            if(!pq.get(new_q).isEmpty())pq.get(new_q).clear();
                            
                            pq.get(new_q).addAll(pq.get(old_q));
                            
                            //swap
                            int tmp = old_q;
                            old_q = new_q;
                            new_q = tmp;
                            //deletion
                            int val = pq.get(old_q).poll();
                            //System.out.println("swap occured D -1: "+val);
                            
                        }
                        
                    }else{ // Delete max
                        // if old quueue is max queue. use max queue -> delete max
                        if(old_q ==1){
                            int val = pq.get(old_q).poll();
                            //System.out.println("D 1: "+val);
                        }
                        // if old queue os min queue. add All to new Queue , 
                        else{
                             if(!pq.get(new_q).isEmpty())pq.get(new_q).clear();
                            pq.get(new_q).addAll(pq.get(old_q));
                        
                            
                            //swap
                            int tmp = old_q;
                            old_q = new_q;
                            new_q = tmp;
                            //delete
                            int val = pq.get(old_q).poll();
                            //System.out.println("swap occured D 1: "+val);
                        }
                    }
                    
                }
            }
            if(pq.get(old_q).isEmpty()) return answer;
            else{
                
                int min = pq.get(old_q).peek();
                int max = 0;
                while(!pq.get(old_q).isEmpty()){
                    max = pq.get(old_q).poll();
                }
                if(old_q == 0){// old queue is min que
                    answer[0]= max;
                    answer[1] = min;
                }
                else{
                    answer[0] = min;
                    answer[1] = max;
                }
            }
            
            return answer;
        }
    }
}
