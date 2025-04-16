'''
1. 아이디어
    - 주어진 지형에서 이동 가능한 둘레를 구하고, 둘레를 따라 이동하며 아이템을 얻는 최단 거리 구하기(BFS/QUEUE)
    1) 이동 가능한 둘레 구하기
        - 테두리만 모두 1로 넣어서 maps 생성 ( 내부 테두리로 이동하는 경우는 결국에는 최단 거리가 될 수 없으므로 처리X)
        - 가장 작은 (lx,ly)와 가장 큰 (rx,ry)를 구해서 해당 크기 만큼의 list 생성
        - 각각 직사각형을 돌면서 1로 변경
    2) maps 돌면서 상하좌우 확인 > 큐 삽입
> 아래는 내 아이디어대로 짠 코드, 실패: 테두리를 인식하기 어려워 while loop를 제대로 처리하지 못함
'''

'''
from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    #최대 직사각형
    # 가로: 최대x-최소x
    # 세로: 최대y-최소y

    minx = 51
    maxx = 0
    
    miny = 51
    maxy = 0
    
    for i in rectangle:
        minx = min(i[0],i[2],minx)
        maxx = max(i[0],i[2],maxx)
        miny = min(i[1],i[3],miny)
        maxy = max(i[1],i[3],maxy)
        
    width = maxx +1
    length = maxy +1
    
    maps = [[0 for j in range(width)]for i in range(length)]
    #print(maps)
    
    for lx,ly,rx,ry in rectangle:
        w = rx-lx
        l = ry-ly
        for i in range(w+1):
            maps[ly][lx+i] = 1
            maps[ry][rx-i] = 1
        for i in range(l+1):
            maps[ry-i][rx] = 1
            maps[ly+i][lx] = 1
    
    #print(maps)
    
    start = (characterX,characterY,0)
    queue = deque([start])
    visited = [[False if j==1 else True for j in i ] for i in maps]
    
    while queue:
        
        x,y,cnt = queue.popleft()
        
        if x == itemX and y == itemY:
            return cnt
        
        dx = [0,0,-1,1]
        dy = [1,-1,0,0]
        
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
        
        if 0<=nx<width and 0<=ny<length:
            if maps[ny][nx] != 0 and not visited[ny][nx]:
                visited[ny][nx] = True
                queue.append((nx,ny,cnt+1))
                
    return 0
    
'''
from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    # 좌표 2배 확장 (테두리를 표현하기 위해서), 102란 1~50*2 > 1~100 > 여유롭게 102만큼 생성
    maps = [[0]*102 for _ in range(102)]
    
    # 사각형 그리기
    for lx, ly, rx, ry in rectangle:
        for i in range(lx*2, rx*2 + 1):
            for j in range(ly*2, ry*2 + 1):
                maps[j][i] = 1

    # 사각형 내부를 0으로 만들기
    for lx, ly, rx, ry in rectangle:
        for i in range(lx*2 + 1, rx*2):
            for j in range(ly*2 + 1, ry*2):
                maps[j][i] = 0

    # BFS
    visited = [[0]*102 for _ in range(102)]
    q = deque()
    q.append((characterX*2, characterY*2, 0))
    visited[characterY*2][characterX*2] = 1

    # 좌우상하
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    while q:
        x, y, dist = q.popleft()

        if x == itemX*2 and y == itemY*2:
            return dist // 2  # 거리 2배 확장했으므로 나눠줌

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if maps[ny][nx] == 1 and not visited[ny][nx]:
                visited[ny][nx] = 1
                q.append((nx, ny, dist + 1))

    return 0
