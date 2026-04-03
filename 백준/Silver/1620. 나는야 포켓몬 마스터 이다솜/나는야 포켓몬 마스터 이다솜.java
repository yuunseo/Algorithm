import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 질문 개수
        
        Map<Integer, String> numberDict = new HashMap<>();
        Map<String, Integer> alphaDict = new HashMap<>();
        
        // 해시 완성시키기
        for(int i=1; i<=N; i++){
            int num = i;
            String name = br.readLine();
            numberDict.put(num, name);
            alphaDict.put(name,num);
        }
        
        // 질문에 대답하기
        for(int i=0; i<M; i++){
            String str = br.readLine();
            
            if(str.matches("^[0-9]*$")){
                System.out.println(numberDict.get(Integer.parseInt(str)));
            }else{
                System.out.println(alphaDict.get(str));
            }
        }
        
    }
}