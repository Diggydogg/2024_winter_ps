//https://school.programmers.co.kr/learn/courses/30/lessons/42579
// 베스트 엘범 프로그래머스
package week1;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Pair{
    int idx;
    int plays;
    
    public Pair(int idx, int plays){
        this.idx = idx;
        this.plays = plays;
    }
    
    public int getIdx(){
        return this.idx;
    }
    public int getPlays(){
        return this.plays;
    }
    
    public static final Comparator<Pair> pairCompare = (p1,p2) ->p1.getPlays()==p2.getPlays() ? Integer.compare(p1.getIdx(), p2.getIdx()): Integer.compare(p2.getPlays(), p1.getPlays()); // this method should not be named compare, already used, 
}


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genrePlay = new HashMap<>();
        HashMap<String, List<Pair>> playInfo = new HashMap<>();
        
        // put data in genrePlay and playInfo
        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            int play = plays[i];
            
            genrePlay.put(key, genrePlay.getOrDefault(key,0)+plays[i]);
            playInfo.putIfAbsent(key, new ArrayList<Pair>());
            playInfo.get(key).add(new Pair(i,play));
        }
        // sort genrePlay in descending order by play cnt
        List<String> genreList = genrePlay.entrySet().
            stream()
            .sorted((p1,p2)->Integer.compare(p2.getValue(), p1.getValue())) // sort first
            .map(Map.Entry::getKey) // get Key only
            .collect(Collectors.toList()); // to List 
        
        // sort playInfo 
        ArrayList<Integer>res = new ArrayList<>();
        
        for(String genre: genreList){
            playInfo.get(genre).sort(Pair.pairCompare); // **
            //System.out.print("Genre: " + genre);
            //for(Pair pair: playInfo.get(genre))System.out.println(" idx:"+ pair.getIdx()+" play "+pair.getPlays());
            if(playInfo.get(genre).size()<2) res.add(playInfo.get(genre).get(0).getIdx());
            else{
                res.add(playInfo.get(genre).get(0).getIdx());
                res.add(playInfo.get(genre).get(1).getIdx());
            }
        }
        // must remember ;;
        int[] answer = res.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}
