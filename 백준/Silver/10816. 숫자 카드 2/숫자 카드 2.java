/*
<아이디어>
1. 상근이가 가진 N개의 숫자 카드 중에서 정수 M개를 주었을 때 N개 중에서 몇 개를 가지고 있나?
2. 상근이의 지갑 vs 나의 지갑 -> 나의 지갑 중에서 상근이가 가진 개수를 배열에 넣어서 반환하기
3. for 나의 지갑에서 1개씩 가져오기 > 상근이가 가진 것 중에서 몇 개 있는지 개수 뽑기
4. 상근이가 가진 카드는 검색해야 하니까 arraylist말고 hashmap?
5. 내가 가진 카드는 하나씩 조회만 하면 되니까 그냥 list도 가능

*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        Map<Integer, Integer> sangeun = new HashMap<>((int)(N / 0.75f) + 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            sangeun.put(x, sangeun.getOrDefault(x, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int y = Integer.parseInt(st.nextToken());
            sb.append(sangeun.getOrDefault(y, 0)).append(' ');
        }

        System.out.print(sb.toString());
    }
}
