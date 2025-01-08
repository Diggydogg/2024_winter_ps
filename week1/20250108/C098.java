package week1.20250108;
import  java.util.*;
import java.util.stream.*;
import java.io.*;

public class C098 {
    


class Solution {
    public int solution(String numbers) {
        int answer = 0;
        //ArrayList<String>res = new ArrayList<>();
        HashSet<Integer>res = new HashSet<>();
        HashSet<Integer>h1 = new HashSet<>();
        int[] max_val = {0};
        permutation(numbers,"",res,max_val);
        System.out.println(max_val[0]);
        int max_val_v = max_val[0]+1;
        int [] prime = new int[max_val_v+1];
        Arrays.fill(prime,0);
        evalPrime(max_val_v, prime);
            
        for(Integer number:res){
            //int num = Integer.parseInt(number);
            //if(isPrime(num))h1.add(num);
            if(prime[number]==0)h1.add(number);
        }
        Iterator iter = h1.iterator();	// Iterator 사용
        // while(iter.hasNext()) {//값이 있으면 true 없으면 false
        //     System.out.println(iter.next());
        // }
        
        return h1.size();
    }
    
    public static void permutation(String arr, String cur,HashSet<Integer>res , int[] max_val){//List<String>res
        //if(arr.length() == 0)res.add(cur); // put cur into res
        if(cur.length()>0){
            int val = Integer.parseInt(cur);
            max_val[0] = Math.max(val, max_val[0]);
            res.add(val);
        }
        //else{
            for(int i = 0; i < arr.length(); i++){
                // choose i idx 
                // new Arr will be Arr[i] removed and newCur will add Arr[i] at the back
                String newArr = arr.substring(0,i)+arr.substring(i+1);
                String newCur = cur+arr.charAt(i);
                permutation(newArr, newCur, res,max_val);
            }
       // }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;  // 1 이하는 소수가 아님
        if (n == 2) return true;   // 2는 소수
        if (n % 2 == 0) return false;  // 2의 배수는 소수가 아님

        // 3부터 √n까지만 확인 (최적화)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void evalPrime(int max, int[] num){
        if(max>1) {
            num[0] =  1; //0 is not prime
            num[1] = 1; //1 is not prime
        }
        for(int i  = 2; i < max; i++){
            if(num[i]==0){ // is Prime
                for(int x =2; x*i<=max; x++){
                    
                    num[x*i] = 1;
                }
            }
            
        }
        
        
    }
}
}
