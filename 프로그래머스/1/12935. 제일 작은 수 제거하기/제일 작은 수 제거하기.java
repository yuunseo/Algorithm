import java.util.Arrays;
import java.util.ArrayList;


class Solution {
    public int[] solution(int[] arr) {
        
        // 최솟값 구하기
        int minValue = Arrays.stream(arr).min().getAsInt();
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int n: arr){
            if(n!=minValue)
                list.add(n);
        }
        
        if(list.isEmpty())
            return new int[] {-1};
        
        // list에서 int[]로 변환
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}