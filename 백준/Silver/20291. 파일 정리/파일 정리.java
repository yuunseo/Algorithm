/*
확장자별 파일의 개수
확장자의 사전순 정렬

확장자의 이름과 개수를 출력하기 (이름은 오름차순)
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> ext = new TreeMap<>(); // TreeMap은 자동 정렬
        
        for(int i=0; i<N; i++){
            String file = br.readLine();
            String extension = file.split("\\.")[1];
            
            ext.put(extension, ext.getOrDefault(extension,0)+1);
        }
               
        // 정답 출력
        for(String key : ext.keySet()){
            System.out.println(key + " " + ext.get(key));
        }
    }
}