/*
자음: 왼손
모음: 오른손
자판 이동 시간: |x1-x2|+|y1-y2|
자판 클릭 시간: 1
동시에 이동 불가능
문자열 출력에 걸리는 시간의 최솟값
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 총 횟수
        int cnt = 0;
        
        // 왼/오 처음 위치
        char sl = st.nextToken().charAt(0);
        char sr = st.nextToken().charAt(0);
        
        // 한글 자음인 알파벳
        Set<Character> cons = Set.of(
            'q','w','e','r','t',                        
            'a','s','d','f','g',                        
            'z','x','c','v');
        // 자음 아니면 다 오른 손
        
        
        // 알파벳 좌표
        Map<Character, int[]> pos = new HashMap<>();
        pos.put('q', new int[] {0,0});
        pos.put('w',new int[] {0,1});
        pos.put('e',new int[] {0,2});
        pos.put('r', new int[] {0,3});
        pos.put('t', new int[] {0,4});
        pos.put('y', new int[] {0,5});
        pos.put('u', new int[] {0,6});
        pos.put('i', new int[] {0,7});
        pos.put('o', new int[] {0,8});
        pos.put('p', new int[] {0,9});
        pos.put('a', new int[] {1,0});
        pos.put('s',new int[] {1,1});
        pos.put('d',new int[] {1,2});
        pos.put('f',new int[] {1,3});
        pos.put('g',new int[] {1,4});
        pos.put('h',new int[] {1,5});
        pos.put('j',new int[] {1,6});
        pos.put('k',new int[] {1,7});
        pos.put('l',new int[] {1,8});
        pos.put('z',new int[] {2,0});
        pos.put('x',new int[] {2,1});
        pos.put('c',new int[] {2,2});
        pos.put('v',new int[] {2,3});
        pos.put('b',new int[] {2,4});
        pos.put('n',new int[] {2,5});
        pos.put('m',new int[] {2,6});

        
        // 문자 하나씩 꺼내보기
        // (x1,y1): 기존
        // (x2,y2): 새로이동
        int x1= -1;
        int y1= -1;
        int x2= -1;
        int y2= -1;
        char[] chars = br.readLine().toCharArray();
        for(int i=0; i<chars.length; i++){
            
            // 이미 클릭 중인 자판이라면 pass
            if(chars[i] == sl || chars[i] == sr){
                cnt++;
                continue;
            }else{
                // 자음이라면 sl과 떨어진 거리 구하기
                if(cons.contains(chars[i])){
                    y2 = pos.get(chars[i])[0];
                    x2 = pos.get(chars[i])[1];
                    y1 = pos.get(sl)[0];
                    x1 = pos.get(sl)[1];
                    sl = chars[i];
                }else{
                    // 모음이라면 sr과 떨어진 거리 구하기
                    y2 = pos.get(chars[i])[0];
                    x2 = pos.get(chars[i])[1];
                    y1 = pos.get(sr)[0];
                    x1 = pos.get(sr)[1];
                    sr = chars[i];
                }
                cnt += Math.abs(x1-x2) + Math.abs(y1-y2); // 이동 시간
                cnt ++; // 클릭 시간
            }
        }
        System.out.println(cnt);              
    }                        
}