'''
1. 아이디어
    - 한 문자씩 바꿔서 begin을 target으로 바꾸는 최소 횟수구하기(BFS/Queue)
    1) begin을 시작점으로 두고, words에 한 번씩 접근하여 begin과 2개가 같은 word를 찾아낸다 < 큐에 삽입
    2) target과 같아질 때까지 반복 & 다음 word로 이동할 때 cnt += 1
    3) for문으로 모든 word를 꺼내면 복잡도 증가 -> visited를 사용해서 안 간 곳만 간다
2. 변수
- 반복처리를 도와줄 큐 deque
- target까지 바꾸는 데 걸리는 횟수 int
- 
'''
from collections import deque


def solution(begin, target, words):
    
    queue = deque([(begin,0)]) # begin, count
    visited = [False for i in range(len(words))]
    
    while queue:
        
        item, cnt = queue.popleft()
        
        if item == target: # 종료 조건
            return cnt
        
        for idx,word in enumerate(words):
            if sum(x != y for x, y in zip(word, item)) == 1 and not visited[idx]:
                visited[idx] = True
                queue.append((word,cnt+1))
            
    return 0