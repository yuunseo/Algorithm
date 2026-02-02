/*
민균이의 비밀번호의 길이와 가운데 글자 출력하는 프로그램
- 여러가지 단어들 중 하나는 민균이의 비번
- 모든 단어는 홀수
- 비번, 거꾸로쓴 비번이 포함됨

1. 각 단어, 뒤집은 단어 모두 저장
2. set 넣고 해당 값을 꺼내려 했을 때 이미 있으면 해당 단어로 결정
3. 해당 비번의 길이와 가운데 글자 출력 (length/2)

*/
import java.util.*; 
import java.io.*; 
class Main{ 
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 중복 체크를 위한 Set (Map보다 효율적)
        Set<String> set = new HashSet<>();
        
        // 한 단어씩 추가
        for(int i=0; i<N; i++){
            String original = br.readLine();
            // StringBuilder를 이용해 뒤집은 문자열 생성
            String reversed = new StringBuilder(original).reverse().toString();
            
            if(set.contains(reversed) || original.equals(reversed)){
                int len = original.length();
                char center = original.charAt(len/2);
                System.out.println(len+" "+center);
                return;
            }
            
            set.add(original);
        }
    }
}