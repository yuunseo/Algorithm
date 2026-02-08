import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 정렬해야됨
        List<Integer> ropes = new ArrayList<>();
        for(int i=0; i<N; i++){
            ropes.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(ropes);
        
        // 여러개의 로프들 중 최솟값을 구하고 각 로프들의 개수*최솟값이 젤 큰 값을 출력하면 됨
        int max = 0;
        
        for(int i=0; i<ropes.size(); i++){
            int min = ropes.get(i);
            int count = ropes.size()-i;
            max = Math.max(min*count, max);
        }
        
        // 결과 출력
        System.out.println(max);

    }
}
