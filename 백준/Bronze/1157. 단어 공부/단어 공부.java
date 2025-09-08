import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


/*
1. 영단어에서 가장 많이 사용된 알파벳 찾기(대소문자 구분no)
2. 모두 소문자로 치환 -> 하나씩 돌면서 hashmap에 넣기
3. hashmap에서 value가 젤 큰 거 뽑아내기
*/

class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. 소문자로 모두 변환하기
        String word = scanner.next().toLowerCase();
        
        // 2. Hashmap 자료형 생성하기
        Map<Character, Integer> alphaMap = new HashMap<>();
        
        // 3. word에서 한 글자씩 가져와서 넣기
        for(char c : word.toCharArray()){
            alphaMap.put(c, alphaMap.getOrDefault(c,0)+1);
        }
        
        // 4. hashmap에서 value 가장 큰 애 꺼내기
        int maxValue = 0;
        for(int value: alphaMap.values()){
            if(maxValue < value){
                maxValue = value;
            }
        }
        
        // 5. 최대 값인 알파벳 개수 세기
        List<Character> answers = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry: alphaMap.entrySet()){
            if(entry.getValue() == maxValue){
                answers.add(entry.getKey());
            }
        }
        
        // 5. 결과 출력
        if(answers.size()>=2){
            System.out.println("?");
        }else{
            System.out.println(Character.toUpperCase(answers.get(0)));
        }
        
    }
}