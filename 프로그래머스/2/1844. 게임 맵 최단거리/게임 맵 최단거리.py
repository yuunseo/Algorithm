'''
1.아이디어
    - 상대진영인 maps[len(maps)][len(mpas[0])]에 도달하는 최단경로 문제(BFS/Queue)
    1) maps의 상하좌우를 확인하여, 1인 곳으로 이동 + 지나온 곳은 0으로 변경
    2) 더이상 갈 곳이 없다면 -1 반환
    3) queue에다가 다음 길을 넣고, 꺼내서 그 다음 경로로 쭉 계산
    4) 상대 진영에 도착했을 때의 cnt 값 저장
'''
from collections import deque


def solution(maps):
    n, m = len(maps), len(maps[0])
    visited = [[False]*m for _ in range(n)]
    queue = deque([(0, 0, 1)])  # (x, y, distance)
    visited[0][0] = True

    dx = [-1, 1, 0, 0]  # 상하좌우
    dy = [0, 0, -1, 1]

    while queue:
        x, y, dist = queue.popleft()

        if x == n-1 and y == m-1:
            return dist  # 도착

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if maps[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny, dist + 1))

    return -1  # 도달 불가

        
        
    
    