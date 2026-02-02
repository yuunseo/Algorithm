/*
선발 가능한 선수 출력하기
- 성의 첫 글자가 같은 선수 5명 선발
- 5명 미만: 기권
- 5명 이상 모두 구하기
- 각 단어를 입력받으면서, 각 알파벳을 저장하고 끝나면 순서대로 5명 이상인 것들 출력
- map 각 첫 글자를 저장하면서 get하자
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> result = new TreeMap<>(); // 알파벳 순서대로 정렬
        StringBuilder sb = new StringBuilder();
        
        // 선수들의 이름 분석 O(N) * O(map 삽입 조회)
        for(int i=0; i<N; i++){
            char c = br.readLine().charAt(0);
            result.put(c, result.getOrDefault(c,0)+1);
        }
        
        // 5명 이상 알파벳 출력
        for(Map.Entry<Character, Integer> ent: result.entrySet()){
            if(ent.getValue() >= 5) sb.append(ent.getKey());
            else continue;
        }
        
        // 결과 출력
        if(sb.length() == 0) sb.append("PREDAJA");
        System.out.println(sb.toString());
       
    }
}