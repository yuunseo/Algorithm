import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            long remainder = N % B;

            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char) (remainder - 10 + 'A'));
            }

            N /= B;
        }

        System.out.println(sb.reverse());
    }
}