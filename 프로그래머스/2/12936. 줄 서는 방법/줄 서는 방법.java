import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        // 1. 사용할 숫자들을 리스트에 담기 (예: [1, 2, 3])
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // 2. 0부터 시작되는 인덱스 보정
        k--; 
        
        // 3. n-1 팩토리얼 초기값 구하기
        long factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }
        
        // 4. 각 자리수 차례대로 구하기
        int idx = 0;
        while (n > 0) {
            // 몫을 통해 리스트에서 몇 번째 숫자를 뽑을지 결정
            int currentIdx = (int) (k / factorial); 
            answer[idx++] = numbers.remove(currentIdx); // 숫자 뽑고 리스트에서 제거
            
            // 다음 단계를 위해 k와 팩토리얼 갱신
            k %= factorial;
            n--;
            if (n > 0) {
                factorial /= n; // 다음 자리의 팩토리얼은 n으로 나눈 값/ n이 하나 줄었으므로
            }
        }
        
        return answer;
    }
}
