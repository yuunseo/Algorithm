import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {

            int diff = 0;

            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }

            min = Math.min(min, diff);
        }

        System.out.println(min);
    }
}