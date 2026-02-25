/*
두 배열을 합치고 정렬하기
ArrayList로 합치고 sort?

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        ArrayList<Integer> a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        
        ArrayList<Integer> b = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        
        list.addAll(a);
        list.addAll(b); 
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}