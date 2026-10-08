/*
idea: 모든 연산 후 큐의 상태를 반환하기
- 연산을 구분해서 하나씩 수행하면 결과는 나옴. 하지만 1,000,000 번 반복해야 한다는게! 
- operationos에서 하나씩 읽어서 명령하기: O(N) = 1,000,000
- operation을 읽은 후, 큐에 삽입하기: O(log N). 삭제하기: O(1)
- 최종은 O(N log N) = 1,000,000 * 약 20 = 20,000,000
*/
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 자료구조 초기화
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        // 반복 처리
        for(String oper: operations){
            String[] temp = oper.split(" ");
            String type = temp[0];
            int num = Integer.parseInt(temp[1]);
            
            if(type.equals("I")){
                treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
            }else if(type.equals("D")){
                // 빈 큐라면 무시
                if (treeMap.isEmpty()) {
                    continue;
                }
                if(num < 0){
                    // 최솟값 삭제
                    int key = treeMap.firstKey();
                    int min = treeMap.get(key);
                    if(min == 1){
                        treeMap.remove(key);
                        continue;
                    }
                    treeMap.put(key, min-1);
                }else{
                    // 최댓값 삭제
                    int key = treeMap.lastKey();
                    int max = treeMap.get(key);
                    if(max == 1){
                        treeMap.remove(key);
                        continue;
                    }
                    treeMap.put(key, max-1);
                }
            }
            
        }
        
        // 결과 처리
        if(treeMap.isEmpty()) return new int[] {0,0};
        return new int[] {treeMap.lastKey(), treeMap.firstKey()};
        
    }
}