import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] files = new String[N];
        for(int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        // 첫 번째 파일을 기준으로 각 위치 비교
        for(int i = 0; i < files[0].length(); i++) {
            char c = files[0].charAt(i);
            boolean same = true;
            for(int j = 1; j < N; j++) {
                if(files[j].charAt(i) != c) {
                    same = false;
                    break;
                }
            }
            sb.append(same ? c : '?');
        }

        System.out.println(sb.toString());
    }
}
