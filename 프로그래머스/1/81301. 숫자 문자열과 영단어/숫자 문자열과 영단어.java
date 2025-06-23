/*
<아이디어>
1. 영단어와 숫자를 매칭시키는 딕셔너리 기능이 필요함
2. s에서 숫자가 나오기 전까지 문자로 묶어서 반환
3. 반환된 단어를 단어와 숫자로 매치해서, 숫자로 다 바꾸기
*/
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        // 영단어와 숫자를 매칭시킬 해쉬맵 생성하기
        HashMap<String,Integer> map = new HashMap<String,Integer> ();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        // 결과물 자료구조
        String answer = "";
        
        // 문자열 s에서 한 단어씩 불러오기
        String part = "";
        for(int i=0; i<s.length(); i++){
            
            if(Character.isDigit(s.charAt(i))){
                answer += s.charAt(i);    
            }else{
                part += s.charAt(i);
                // 만들어진 part가 map에 존재한다면, answer에 추가하고 part 초기화
                if(map.containsKey(part)){
                    answer += map.get(part);
                    part="";
                }else continue;
            }
            
        }

        // 마지막에 처리되지 않은 영단어가 있는지 확인
        if(!part.isEmpty() && map.containsKey(part)){
            answer += map.get(part);
        }
        
        return Integer.parseInt(answer);
    }
}