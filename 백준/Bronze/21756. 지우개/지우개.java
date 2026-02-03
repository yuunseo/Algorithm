import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 1;
        while(ans * 2 <= N){
            ans *= 2;
        }

        System.out.println(ans);
    }
}
