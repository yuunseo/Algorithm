import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(reader.readLine());
        
        // 1. 중복 제거
        Set<String> set = new HashSet<String>();
        for(int i=0; i<N; i++){
            set.add(reader.readLine());
        }
        
        // 2. 정렬
        List<String> wordList = new ArrayList<>(set);
        Collections.sort(wordList, (a,b)->{
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append("\n");
        }
        
        System.out.print(sb);
    }
}