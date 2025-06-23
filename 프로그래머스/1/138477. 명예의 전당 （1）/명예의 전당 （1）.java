

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> list = new PriorityQueue<Integer>();
        
        for(int i=0; i<score.length; i++){
            if(list.size()<k){
                list.add(score[i]);
            }
            else{
                if(list.peek() < score[i]){
                    list.poll();
                    list.add(score[i]);
                }       
            }
            answer[i] = list.peek();
        }
        
        return answer;
    }
}