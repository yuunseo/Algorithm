/*
1. 큐에서 최대/최소를 알아야함, 따라서 우선순위 큐!

*/
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        Queue<Integer> minHeap = new PriorityQueue<>(); // 오름차순 우선순위 큐
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++){
            String[] cur = operations[i].split(" ");
            String c = cur[0];
            int num = Integer.parseInt(cur[1]);
            
            if(c.equals("I")){
                minHeap.add(num);
                maxHeap.add(num);
            }else if(c.equals("D") && num<0){
                if(minHeap.isEmpty()) continue;
                
                int min = minHeap.poll();
                maxHeap.remove(min);
            }else{
                if(maxHeap.isEmpty()) continue;
                
                int max = maxHeap.poll();
                minHeap.remove(max);
            }
        }
        
        if(minHeap.isEmpty()) return new int[]{0,0};
        
        return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}