import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 전체 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
        int count = 0; // 출력값

        int[] current = new int[4]; // 현재 문자열이 가진 알파벳 현황
        int[] required = new int[4]; // 최소 포함해야 하는 알파벳 개수

        String str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            required[i] = Integer.parseInt(st.nextToken());
        }

        // 알파벳 - 인덱스 맞춰두기
        Map<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('C',1);
        map.put('G',2);
        map.put('T',3);

        // 1. 0~P-1번까지의 인덱스에서 알파벳 현황 체크하기
        int start = 0;
        int end = P-1;
        for(int i=start; i<=end; i++){
            char c = str.charAt(i);
            current[map.get(c)]++;
        }

        // 2. 최소 조건에 충족하는지 검사
        while(end <= S-1){
            boolean result = true;
            for(int i=0; i<4; i++){
                if(current[i] < required[i]){
                    result = false;
                    break;
                }
            }

            if(result) count++;

            // 3. start ++, end ++ 함으로써 맨 앞 알파벳 지우고, 맨 뒤 알파벳 추가하기
            current[map.get(str.charAt(start++))] --;
            end++;
            if(end < S){
                current[map.get(str.charAt(end))]++;
            }

            // 4. 다시 검토 반복
        }


        System.out.println(count);
    }
}