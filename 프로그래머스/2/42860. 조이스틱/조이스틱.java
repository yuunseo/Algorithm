/*
구해야 하는 조작횟수의 총합은
1. 구해야하는 알파벳-현재알파벳 -> 위아래로 이동해야 하는 횟수
2. A가 띄엄띄엄 있을 때는 어차피 지나가야 해서 상관 없지만,
    A가 연속으로 있을 때는 해당 구간을 지나가지 않는 것이 최소!
    이때 연속된 구간들 별로 최소인 값이 있을 수 있으므로, 연속된 구간 만날 때마다 거리 갱신
3. A가 연속인 인덱스를 구하고, 현재 위치랑 더 가까운 쪽으로 좌우로 이동하는 횟수 

*/
import java.util.*;

class Solution {
    public int solution(String name) {
        
        // 위아래 조작 필요한 알파벳 횟수 구하기
        int answer = 0;
        for(char c : name.toCharArray()){
            answer += Math.min(c-'A', 'Z'-c+1);
        }
                
        // 연속된(뛰어넘을 수 있는) A 구간 구하기
        int move = name.length() - 1;

        for(int i=0; i<name.length(); i++){

            int next = i + 1;

            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }

            move = Math.min(move,
                    i*2 + name.length() - next); // 앞에 먼저

            move = Math.min(move,
                    i + 2*(name.length() - next)); // 뒤에 먼저
        }

        return answer+move;
    }
}