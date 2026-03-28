import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();
        
        // 초기화
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }
        
        // 판매 처리
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int profit = amount[i] * 100;
            
            distribute(name, profit, parent, profitMap);
        }
        
        // 결과
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }
        
        return answer;
    }
    
    private void distribute(String name, int profit, Map<String, String> parent, Map<String, Integer> profitMap) {
        
        // 종료 조건
        if (name.equals("-") || profit == 0) return;
        
        int share = profit / 10;
        int mine = profit - share;
        
        profitMap.put(name, profitMap.get(name) + mine);
        
        // 부모에게 전달
        distribute(parent.get(name), share, parent, profitMap);
    }
}