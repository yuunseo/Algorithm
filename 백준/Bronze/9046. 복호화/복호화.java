/*
암호문의 각 문자들 중 최다 빈도수인 문자 출력 - 개수가 동일하다면 "?"출력
알파벳과 알파벳의 개수를 저장해야 하므로 Map
TreeMap이란, key 기준 정렬이므로 우리와 다름
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        Map<Character, Integer> list = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c == ' ') continue;
                list.put(c, list.getOrDefault(c,0)+1);
            }
            
            // 최대 값 추출하기
            // 최대 값과 동점자인 문자가 존재할 경우, dupli = true;
            char max_key = ' ';
            int max_value = 0;
            boolean dupli = false;
                        
            for(Map.Entry<Character, Integer> entry: list.entrySet()){
                if(max_value < entry.getValue()){
                    max_value = entry.getValue();
                    max_key = entry.getKey();
                    dupli = false; // 새로운 최댓값 나올 경우, 초기화
                }else if(max_value == entry.getValue()){
                    dupli = true;
                }
            }
            
            // 최대 값 문자 추출하기
            sb.append(dupli ? "?" : max_key).append("\n");
            
            // list 초기화
            list.clear();
        }
        
        System.out.println(sb.toString());
    }
}