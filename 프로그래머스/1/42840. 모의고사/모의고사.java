/*
- 가장 높은 점수인 사람을 배열로 반환하기 & 동점이면 오름차순 정렬
- 총 10,000문제이므로, 모든 문제를 각각 비교해 보아도 O(N) 가능
*/
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        // 1. 각 학생들의 답안지 문자열 생성 (길이는 10,000)
        String std_1 = "12345".repeat(10000/5);
        String std_2 = "21232425".repeat(10000/8);
        String std_3 = "3311224455".repeat(10000/10);
        
        // 2. answer에 든 배열을 가지고 반복하면서 맞는 답안의 개수 카운드
        int cnt_1 = 0;
        int cnt_2 = 0;
        int cnt_3 = 0;
        int max = 0;
        for(int i=0; i<answers.length; i++){
            if(std_1.charAt(i) == (char)(answers[i]+'0')){
                cnt_1++;
                if(max<cnt_1){
                    max = cnt_1;
                }
            }
            if(std_2.charAt(i) == (char)(answers[i]+'0')){
                cnt_2++;
                if(max<cnt_2){
                    max = cnt_2;
                }
            }
            if (std_3.charAt(i) == (char)(answers[i]+'0')){
                cnt_3++;
                if(max<cnt_3){
                    max = cnt_3;
                }
            }
            
            
        }
        System.out.println(max);
        // 3. 최댓값인 학생들을 모아서 반환
        List<Integer> list = new ArrayList<Integer>();
        if(cnt_1 == max){
            list.add(1);
        }
        if(cnt_2 == max){
            list.add(2);
        }
        if(cnt_3 == max){
            list.add(3);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}