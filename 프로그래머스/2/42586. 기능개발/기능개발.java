    /*
    1. 각 작업별 남은 완료도 -> 완료까지 걸리는 시간으로 배열 바꾸기
    2. 100 - progresses/speeds 값으로 치환 -> 올림한 값
    3. 이전 작업이 끝났는지 확인해야함 비교가 필요함! 그러므로 자료구조는 staxk
    4. [7,3,9] -> stack에 넣고 이전 값보다 작으면, cnt +1 이전 값보다 크면 모두 pop
    5. [5,10,1,1,20,1] -> 1, 3, 2
    => stack 사용 안 하고, 그냥 나보다 더 큰 값이 나올 때까지 cnt++ 나보다 큰 값 나오면 cnt 출력&초기화
    */
    import java.util.*;

    class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        // 남은 작업 기간 배열
        int[] rest = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            rest[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int cnt = 1;
        int cur = rest[0];
        for(int i=1; i<rest.length; i++){
            int next = rest[i];
            
            if(cur >= next){
                cnt++;
            }else{ // cur < next
                answer.add(cnt);
                cnt=1;
                cur = next;
            }
        }
        
        answer.add(cnt);

        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }

        return result;
    }
}