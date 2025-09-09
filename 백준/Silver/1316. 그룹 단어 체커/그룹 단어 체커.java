import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/*
1. 투 포인터로 한 개씩 늘려가면서 하나의 군집을 이루는지 파악하기
2. 하나의 군집을 이루고, 두 번째 포인터가 첫 번째 포인터랑 다를 경우 
-> 두번째 포인터 바로 직전까지 모두 잘라내서 StringBuilder에 추가할까? 아니면 list? 
그래서 나중에 이거 있나없나 먼저 찾아보고 있으면 실패.

*/
/*
class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 0. 정답으로 출력할 변수
        int answer = 0;
        
        // 1. 단어의 개수를 입력받는다
        int cnt = scanner.nextInt();
        scanner.nextLine();
        
        // 2. 한 단어 씩 불러온다.
        for(int i=0; i<cnt; i++){
            String word = scanner.nextLine();
            Set<Character> alphaSet = new HashSet<>();
            // 3. two poiner로 판별하기
            int pt1 = 0;
            int pt2 = 1;
            if(word.length() <= 1){
                answer += 1;
                continue;
            }
            
            while(pt1 < word.length() && pt2 < word.length()){
                if(word.charAt(pt1) == word.charAt(pt2)){
                    // 다음 글자와 같으면, 다음 글자로 이동
                    pt2 += 1;
                }else{
                    // 다음 글자와 다르면, 지금까지 알파벳을 담고 다음으로 이동
                    if(alphaSet.contains(word.charAt(pt1))){
                        break; // 이미 존재하면 다음 단어로 넘어가기
                    }else{
                        alphaSet.add(word.charAt(pt1));
                        pt1 = pt2;
                        pt2 += 1;
                    }
                    
                }
                
            }
            
            if(pt1 < word.length() ){
                continue;
            }else{
                answer += 1;
            }
        }
        
        // 4. 결과 출력하기
        System.out.println(answer);
    }
}*/

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 
        int answer = 0;

        for(int i = 0; i < n; i++){
            String word = scanner.nextLine();
            Set<Character> used = new HashSet<>();
            char prev = word.charAt(0);
            used.add(prev);
            boolean isGroup = true;

            for(int j = 1; j < word.length(); j++){ // 단어를 하나씩 꺼내면서 이전이랑 같은지 확인
                char c = word.charAt(j);
                if(c != prev){ // 이전 글자랑 다르면, set에 들어가 있는지 확인하고
                    if(used.contains(c)){
                        isGroup = false; // 이미 들어있으면, Grouping 실패
                        break;
                    }
                    used.add(c); // 안 들어있으면, 새롭게 Group 추가
                    prev = c;
                }
            }

            if(isGroup) answer++;
        }

        System.out.println(answer);
    }
}
