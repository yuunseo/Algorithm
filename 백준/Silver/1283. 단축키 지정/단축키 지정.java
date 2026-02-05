/*
N개의 옵션 살펴보기
1. 왼쪽 단어의 첫 글자부터 단축키로 지정됐는지 확인 안돼있으면 그걸로 선정
2. 모두 지정된 단어라면, 왼쪽 글자로 다시 판단
3. 암것도 안되면 그냥 두기, 있으면 대괄호로 추가, 대소문자 구분 X

1. 단어를 아예 배열에 담아둘까?
2. 담아서 하나씩 꺼내서 맨 첫 글자 확인하고 그래도 안되면 다시 첨으로 돌아와서 인덱스로 찾기?
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input 초기화
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Character> keys = new HashSet<>();

        // 반복
        for(int i=0; i<N; i++){
            boolean find = false;
            String str = br.readLine();
            String[] words = str.split(" ");
            int idx = 0;

            // 각 단어별 첫 글자로 판단하기
            for(String word: words){
                char c = Character.toLowerCase(word.charAt(0));
                if (!keys.contains(c)) {
                    keys.add(c);
                    sb.append(str, 0, idx)
                        .append("[")
                        .append(word.charAt(0))
                        .append("]")
                        .append(word.substring(1));
                    sb.append(str.substring(idx + word.length()));
                    find = true;
                    break;
                }
                idx += word.length() + 1;
            }

            // 각 단어의 첫 글자로 불가능하면, 다시 첫 글자부터 판단
            if (!find) {
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if (ch == ' ') continue;

                    char lower = Character.toLowerCase(ch);
                    if (!keys.contains(lower)) {
                        keys.add(lower);
                        sb.append(str, 0, j)
                            .append("[")
                            .append(ch)
                            .append("]")
                            .append(str.substring(j + 1));
                        find = true;
                        break;
                    }
                }
            }

            // 아무것도 못 찾은 경우
            if (!find) {
                sb.append(str);
            }
            sb.append("\n");
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}