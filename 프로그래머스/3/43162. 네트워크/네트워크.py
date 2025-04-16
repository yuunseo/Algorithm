'''
1. 아이디어
    - 연결된 컴퓨터들의 개수를 구하는 문제: DFS(가능한 조합을 탐색하는 문제)
    1) 노드는 computers[i], 간선은 computers[i][j] - computers[i][i]는 자기 자신 = 1
    2) computers[i][j] == 1이라면, computers[j]로 이동 > computers[j][k]==1인 거 찾기.
        있으면 다음 [k][l] ==1 을 찾고 len(computers) 끝날 때까지 재귀
        없으면 해당 노드는 끝. 다음 노드로 이동
'''

def dfs(graph, computer, visited):
    
    visited[computer] = True
    
    for i in range(len(graph)):
        if graph[computer][i] == 1 and not visited[i]:
            dfs(graph, i, visited)
    
    
def solution(n, computers):
    
    visited = [False] * n 
    cnt = 0
    
    for i in range(n): # 종료조건 대신 for loop으로 제한하기
        if not visited[i]: # 방문 여부를 판단하여, 중복 제한
            dfs(computers,i,visited)
            cnt += 1 # 0번 컴퓨터와 1번 컴퓨터가 연결되어 있다면, 다시 dfs를 시행하지 않으니, cnt 건너뛰기
            
    return cnt
    