import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
      
        // 자료구조 초기화
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        // 반복
        for(String operation: operations){
            String[] list = operation.split(" ");
            String type = list[0];
            int num = Integer.parseInt(list[1]);
            
            if(type.equals("I")){ // 삽입
                treeMap.put(num, treeMap.getOrDefault(num,0)+1);
            }else{ // 삭제
                if(treeMap.isEmpty()) continue;
                if(num<0){ // 최솟값 삭제
                    int minKey = treeMap.firstKey();
                    int result = treeMap.get(minKey)-1;
                    if(result==0){
                        treeMap.remove(minKey);
                    }else{
                        treeMap.put(minKey, result);
                    }
                }else{ // 최댓값 삭제
                    int maxKey = treeMap.lastKey();
                    int result = treeMap.get(maxKey)-1;
                    if(result==0){
                        treeMap.remove(maxKey);
                    }else{
                        treeMap.put(maxKey, result);
                    }
                }
            }
        }
        
        // 결과 반환
        if(treeMap.isEmpty()) return new int[] {0,0};
        else return new int[] {treeMap.lastKey(), treeMap.firstKey()};
    }
}