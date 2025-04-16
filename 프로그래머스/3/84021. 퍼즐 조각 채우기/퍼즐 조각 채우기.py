'''
1. 아이디어
    - 빈 칸에 조각을 회전시켜 채울 수 있는 조합을 탐색하는 문제(DFS/stack, recursion)
        - 최종 결과: 게임판에 채워진 조각들의 넓이의 합
            > 게임판에 채워질 때, 해당 조각의 넓이를 count해야 함
        - 반복해서 비교할 대상: 조각의 크기와 게임판의 빈 공간이 fit 하는지
            1) 조각과 빈 공간이 fit한지 보기 위하여 (x,y)형태로 저장한다
            2) 정규화 과정을 통해 fit하게 맞는 것이 있는지 확인
            3) 회전하는 경우를 위해, 4가지 회전을 했을 때로 구분하여 확인
'''

from collections import deque

# 퍼즐 블록을 시계 방향으로 90도 회전
def rotate(block):
    rotated = [(y, -x) for x, y in block]
    return normalize(rotated)

# 블록 좌표를 (0, 0) 기준으로 정규화
def normalize(block):
    min_x = min([x for x, y in block])
    min_y = min([y for x, y in block])
    normalized = sorted([(x - min_x, y - min_y) for x, y in block])
    return normalized

def solution(game_board, table):
    
    # DFS로 연결된 블록(빈공간 or 퍼즐조각) 찾기
    def dfs(graph, position, visited, target_value):
        queue = deque([position])
        result = []
        visited[position[0]][position[1]] = True
        
        while queue:
            x, y = queue.pop()
            result.append((x, y))
            
            for dx, dy in [(1,0), (-1,0), (0,-1), (0,1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]):
                    if graph[nx][ny] == target_value and not visited[nx][ny]:
                        visited[nx][ny] = True
                        queue.append((nx, ny))
        return result

    N = len(game_board)
    
    # 1. game_board에서 빈칸(0)의 모양 추출
    board = []
    visited_board = [[False]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if game_board[i][j] == 0 and not visited_board[i][j]:
                block = dfs(game_board, (i, j), visited_board, 0)
                board.append(normalize(block))

    # 2. table에서 퍼즐 조각(1)의 모양 추출
    pieces = []
    visited_table = [[False]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if table[i][j] == 1 and not visited_table[i][j]:
                piece = dfs(table, (i, j), visited_table, 1)
                pieces.append(piece)

    # 3. 빈칸과 퍼즐 조각을 비교하여 맞는 퍼즐 조각을 채움
    answer = 0
    used = [False] * len(pieces)

    for blank in board:
        matched = False
        norm_blank = normalize(blank)
        
        for i in range(len(pieces)):
            if used[i]:
                continue
            
            piece = pieces[i]
            for _ in range(4):  # 회전 4번까지 시도
                norm_piece = normalize(piece)
                if norm_piece == norm_blank:
                    answer += len(piece)
                    used[i] = True
                    matched = True
                    break
                piece = rotate(piece)
            
            if matched:
                break
    
    return answer
