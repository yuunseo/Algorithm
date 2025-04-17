'''
1. 아이디어
    - 네트워크 1개 > 비슷한 개수를 가진 네트워크 2개로 분할
    - 모든 경우의 수를 구해보자
    1) for i in wires: i를 차례대로 끊어서 각각의 네트워크 개수 -> [i[0]번 트리, i[1]번 트리]간의 개수 차이를 갱신 minV
    2) 최종적으로 가장 적은 개수 차이를 return
'''
from collections import deque

def find_tree(v1,wireList):
    
    queue = deque([v1])
    visited = set()
    visited.add(v1)
    cnt = 1
    
    while queue:
        
        start = queue.popleft()
        for idx,(n1,n2) in enumerate(wireList):
            if n1 == start and n2 not in visited:
                visited.add(n2)
                queue.append(n2)
                cnt += 1
            if n2 == start and n1 not in visited:
                visited.add(n1)
                queue.append(n1)
                cnt += 1
    return cnt
    
    
def solution(n, wires):
    # 0. 두 네트워크 간의 개수 차이
    minV = float('inf')
    
    # 1. 송전선을 하나씩 끊어보기
    for i in range(len(wires)):
        v1 = wires[i][0]
        v2 = wires[i][1]
        cut_wires = wires[:i] + wires[i+1:]
        count1 = find_tree(v1, cut_wires)
        count2 = n - count1  # 전체 노드에서 남은 게 count2, 굳이 함수 2번 실행할 필요 없음!
        minV = min(minV, abs(count1 - count2))
        
    return minV
        