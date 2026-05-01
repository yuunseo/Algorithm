import java.util.*;

class Solution {
    boolean[] visited;
    List<String> routes = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        // 알파벳 순으로 정렬
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        dfs("ICN", "ICN", tickets, 0);

        return routes.get(0).split(" ");
    }

    private void dfs(String current, String path, String[][] tickets, int count){
        if(count == tickets.length){ // 티켓 모두 사용하면 종료
            routes.add(path);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                dfs(
                    tickets[i][1],
                    path + " " + tickets[i][1],
                    tickets,
                    count + 1
                );
                visited[i] = false;
            }
        }
    }
}