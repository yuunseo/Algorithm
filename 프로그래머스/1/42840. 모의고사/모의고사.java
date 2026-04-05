import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length; // 시험 문제 수
        int[] scores = new int[4]; // 학생 점수 초기화
        for(int i=1; i<=3; i++){
            scores[i] = 0;
        }
        
        ArrayList<Integer>[] std = new ArrayList[4];
        for(int i=1; i<=3; i++){
            std[i] = new ArrayList<>();
        }
        std[1].add(1); std[1].add(2); std[1].add(3); std[1].add(4); std[1].add(5);
        std[2].add(2); std[2].add(1);
        std[2].add(2); std[2].add(3);
        std[2].add(2); std[2].add(4);
        std[2].add(2); std[2].add(5);
        std[3].add(3); std[3].add(3);
        std[3].add(1); std[3].add(1);
        std[3].add(2); std[3].add(2);
        std[3].add(4); std[3].add(4);
        std[3].add(5); std[3].add(5);
        
        
        for(int i=1; i<=3; i++){
            for(int j=0; j<n; j++){
                int num = std[i].get(j%(std[i].size()));
                if(num == answers[j]) scores[i] += 1;
            }
        }
        
        
        int maxVal = -1;
        for(int i=1; i<4; i++){
            maxVal = Math.max(maxVal, scores[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<4; i++){
            if(scores[i] == maxVal) result.add(i);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}