'''
1. 아이디어
    - 가능한 모든 경로를 탐색하는 문제 (DFS/stack||recursion)
    1) 가장 처음 공항ICN을 stack에 추가한다
    2) ICN을 꺼내서, 연결되어 있는 다른 공항을 찾아 stack에 추가한다( 이때 알파벳 역순으로 추가)
    3) 다음 공항을 꺼내서, 연결된 다른 공항을 찾는다
    3) 더이상 연결된 공항이 없다면 끝
        - 한번 연결한 공항을 다시 연결하지 않도록 처리 필요
        - 
'''
from collections import deque

def solution(tickets):

    tickets.sort()  # 알파벳 순서 우선
    visited = [False] * len(tickets)
    path = ["ICN"]

    def dfs(current, route):
        if len(route) == len(tickets) + 1:
            return route

        for i in range(len(tickets)):
            if not visited[i] and tickets[i][0] == current:
                visited[i] = True
                result = dfs(tickets[i][1], route + [tickets[i][1]])
                if result:
                    return result
                visited[i] = False

        return None

    return dfs("ICN", path)
