/*
<아이디어>
1. 이름별 점수로 대체해서 모두 sum 하면 되겠지?
- photo에서 하나씩 불러온다 > 대응하는 숫자들을 sum에더한다 -> answer 배열에 넣는다
- 없는애는 0점 > map으로 저장하기
*/
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String,Integer> name_year = new HashMap<String,Integer> ();
        for(int i=0; i<name.length; i++){
            name_year.put(name[i],yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                sum += name_year.getOrDefault(photo[i][j],0);
            }
            answer[i] = sum;
        }
        
    
        
        return answer;
    }
}