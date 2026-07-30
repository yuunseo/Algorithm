/*
Q. 가장 많이 함께 주문된 단품메뉴 조합에 따라, 코스요리의 후보를 반환하세요
A. 순서와는 상관없이, 요리들의 조합의 개수를 세서 가장 많은 조합을 선택해야 한다.
    -> 모든 조합을 하나씩 만들어서 개수를 저장하기
*/
import java.util.*;

class Solution {
    
    static Map<String, Integer> menuCombinations;
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answer = new ArrayList<>();
        
        // 메뉴 정렬시키기
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }
        
        // course에서 원하는 개수 꺼내오기
        for(int i = 0; i<course.length; i++){
            int cnt = course[i];
            
            menuCombinations = new HashMap<>();
            
            // cnt 개수 만큼 조합을 꺼내오기
            for(String order: orders){
                
                if(order.length() < cnt) continue; // 만들어야 하는 메뉴 개수보다 적으면, pass
                
                make_combination(order, 0, cnt, new StringBuilder());
            }
            
            // 현재 가장 많이 주문된 횟수 찾기
            int maxCount = 0;
            for (int count : menuCombinations.values()) {
                maxCount = Math.max(maxCount, count);
            }

            // 최소 2명 이상의 손님이 주문한 조합만 가능
            if (maxCount < 2) {
                continue;
            }

            // 최다 주문 조합을 정답에 추가
            for (Map.Entry<String, Integer> entry : menuCombinations.entrySet()) {
                if (entry.getValue() == maxCount) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
        }
    
    
    private void make_combination(String order, int start, int cnt, StringBuilder cur){
        
        // 원하는 길이의 조합이 완성된 경우
        if (cur.length() == cnt) {
            String combination = cur.toString();

            menuCombinations.put(
                    combination,
                    menuCombinations.getOrDefault(combination, 0) + 1
            );

            return;
        }
        
        // order에서 메뉴를 하나씩 꺼내서 cnt개의 조합을 만들기
        for (int i = start; i < order.length(); i++) {
            cur.append(order.charAt(i));

            make_combination(order, i + 1, cnt, cur); // 다음 메뉴 선택하기
            cur.deleteCharAt(cur.length() - 1); // 방금 선택한 메뉴 제거
        }
    }
}