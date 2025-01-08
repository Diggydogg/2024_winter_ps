package week1.20250108;
import  java.util.*;
import java.util.stream.*;
import java.io.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42627
public class 4267 {
    

public class Process{
    int time_taken;
    int request_time;
    int index;
    
    public Process(int time_taken, int request_time, int index){
        this.time_taken = time_taken;
        this.request_time = request_time;
        this.index = index;
    }
    public int getT(){
        return time_taken;
    }
    public int getR(){
        return request_time;
    }
    public int getI(){
        return index;
    }
    //public static final Comparator<Process> ProcessCompare =(x,y)->  x.getT()==y.getT() ?  x.getR()==y.getR() ? Integer.compare(x.getI(),y.getI()) : Integer.compare(x.getR(),y.getR()) : Integer.compare(x.getT(),y.getT())   ;
    public static final Comparator<Process> ProcessCompare = Comparator.comparingInt(Process::getT).thenComparingInt(Process::getR).thenComparingInt(Process::getI);
    public static final Comparator<Process> JobCompare = Comparator.comparingInt(Process::getR);
    // if Descending order then
    //public static final Comparator<Process> ProcessCompare = 
    // Comparator.comparingInt(Process::getT).reversed()   // time_taken 내림차순
    //           .thenComparingInt(Process::getR).reversed() // request_time 내림차순
    //           .thenComparingInt(Process::getI).reversed(); // index 내림차순
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Process> pq1 = new PriorityQueue<Process>(Process.ProcessCompare);
        PriorityQueue<Process> pq0 = new PriorityQueue<Process> (Process.JobCompare);
        for(int i = 0; i < jobs.length; i++){
            int request_time = jobs[i][0];
            int time_taken = jobs[i][1];
            pq0.add(new Process(time_taken, request_time, i));
        }
        
        
        int answer = 0;
        int time = 0;
        int job_done = 0;
        while((!pq1.isEmpty())||(!pq0.isEmpty())){
            
            while( !pq0.isEmpty()  && (pq0.peek().getR()<=time)){ // hasnt arrive jobs comes to waiting que
                Process P = pq0.poll();
                pq1.add(P);
            }
            if(!pq1.isEmpty() && pq1.peek().getR()<=time){
                Process p = pq1.poll();
                time+=p.getT(); // hard detached and time goooess
                // turnaround time record : time diff between actual finished on hard  and request time
                int time_diff = time - p.getR();
                //System.out.println("time diff ["+p.getI()+"] : turnaround time: "+time_diff);
                answer += time_diff;
                job_done++;
            }
            else{ // case of 1. waiting queu is empty but process hasnt requested yet or 2.pq1 isnt empty but time hasnt come <-- impossible
                time++;
            }
        }
        answer = answer/job_done;
        //System.out.println("pq0.size:"+pq0.size()+"pq1.size"+pq1.size());
        //System.out.println("Job done: "+job_done +"total time: "+time+" answer: "+answer);
        return answer;
    }
}
}
