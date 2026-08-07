/*
Q. ICN에서 출발하고, 주어진 항공권을 모두 사용하여 여행 경로를 만드세요.
A. 가능 경로가 2개 이상이라면 알파벳 순서대로. 모든 도시는 꼭 방문 가능함.
    - DFS를 통해서 완전 탐색/그래프 탐색
    - 가능한 경로를 담을 수 있는 map 혹은 queue가 있으면 좋겠는데?

*/
import java.util.*;

class Solution {

    static String[][] tickets;
    static boolean[] visited;
    static List<String> answer;

    public String[] solution(String[][] input) {

        tickets = input;
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();

        // 알파벳 순서가 빠른 경로부터 탐색하도록 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }

            return a[0].compareTo(b[0]);
        });

        List<String> route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN", 0, route);

        return answer.toArray(new String[0]);
    }

    private boolean dfs(String start, int count, List<String> route) {

        // 모든 티켓을 사용한 경우
        if (count == tickets.length) {
            answer = new ArrayList<>(route);
            return true;
        }

        // 현재 도시에서 출발할 수 있는 티켓 찾기
        for (int i = 0; i < tickets.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (!tickets[i][0].equals(start)) {
                continue;
            }

            // 티켓 사용
            visited[i] = true;

            // 다음 도시 탐색
            route.add(tickets[i][1]);
            if (dfs(tickets[i][1], count + 1, route)) {
                return true;
            }

            // 해당 경로가 실패했으면 원상복구
            visited[i] = false;
            route.remove(route.size() - 1);
        }

        return false;
    }
}