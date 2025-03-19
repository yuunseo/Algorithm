#코딩에 앞서 먼저 꼭 해야 할 것 3가지
''' 
1. 아이디어
-> 2중 for문 > 값 == 1 && !방문 > BFS
-> BFS 돌면서 그림 개수 += 1, 최대너비 갱신

2. 시간복잡도
-> BFS = O(V+E)
-> V = n * m
-> E = V * 4 (모서리는 2개씩, 내부는 4개씩 생길 수 있으니, 넉넉잡아서 4배)
-> V + E = V + 4V = 5V = 5*(n*m) = 5*(500*500) = 1,250,000
=> 약 100만인데, 1초에 연산을 2억번 할 수 있다고 했으니까 충분히 "가능"

3. 자료구조
-> graph 표현을 위해서: int[][]
-> 방문 여부를 위해서: bool[][]
-> BFS를 위해서: Queue()
'''

from collections import deque

#습관화해야 될 아래 코드. 기억!!
import sys
input = sys.stdin.readline

n,m = map(int, input().split())
grp = [list(map(int,input().split())) for i in range(n)]
chk = [[False] * m for i in range(n)]

# 다음 건 그냥 외우세요, 4방향으로 좌표 이동/확인 시 사용
# 오른쪽, 아래, 왼쪽, 위쪽
dy = [0,1,0,-1]
dx = [1,0,-1,0]

def bfs(y,x):
  rs = 1
  q = deque()
  q.append((y,x))# 입력한 좌표에 대한 값을 q로 두고, 
  while q: # q가 1일 때까지 반복
    ey, ex = q.popleft() # q에서 하나를 꺼내서 확인해보자
    for k in range(4): # 4방향에 대해 볼 거니까 4번/ k값에 따라 방향이 달라질 것
      ny = ey + dy[k]
      nx = ex + dx[k]
      if 0<=ny<n and 0<=nx<m: # 확인한 좌표가 범위 초과하면 안됨
        if grp[ny][nx] == 1 and chk[ny][nx] == False:
          chk[ny][nx] = True
          rs += 1
          q.append((ny,nx)) # 다음 연결된 V로 이동해야 되니까 큐에 추가

  return rs

cnt = 0
maxv = 0
for j in range(n):
  for i in range(m):
      if grp[j][i] == 1 and chk[j][i] == False:
        chk[j][i] = True
        # 전체 그림 개수 += 1
        cnt += 1
        # BFS 실행 > 그림의 넓이 구하기
        # 구해진 그림의 넓이 > 최대값 갱신하기
        maxv = max(maxv,bfs(j,i))


print(cnt)
print(maxv)