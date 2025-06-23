/*
<아이디어>
1. 각 아이템을 2로 나누어서 가능한 최대 횟수로 나눈다
2. 남는 아이템은 신경쓰지 않아도 되므로, result 문자열에만 신경쓰면 됨!
3. 2로 나눈 몫 만큼 아이템을 result 문자열에 추가한다.
4. 다음 아이템으로 이동해서 2로 나눈다. 이때, 2로 나눈 몫이 0일 경우, 아무것도 안 더해주고 다음 아이템으로!
5. 마지막 아이템까지 다 더했으면, 일단 그 문자열을 복사해 둔다.
6. 0을 사이에 두고 각 문자열을 더해줄 건데, 하나는 순서를 뒤집어서 더해준다.
*/

class Solution {
    public String solution(int[] food) {
        String part1 = "";
        
        //food 배열에서 한 개씩 가져오기
        for(int i=1; i<food.length; i++){
            
            for(int j=0; j<(int)(food[i]/2); j++)
                part1 += i+"";
        }
        
        StringBuffer temp = new StringBuffer(part1);
        String part2 = temp.reverse().toString();
        
        
        return part1+"0"+part2;
    }
}