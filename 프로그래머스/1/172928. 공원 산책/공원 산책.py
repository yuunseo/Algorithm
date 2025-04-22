def solution(park, routes):
    w, h = len(park), len(park[0])

    # 시작점 찾기
    for i in range(w):
        for j in range(h):
            if park[i][j] == 'S':
                si, sj = i, j

    # 방향 정의
    direction = {
        'N': (-1, 0),
        'S': (1, 0),
        'W': (0, -1),
        'E': (0, 1)
    }

    for route in routes:
        d, cnt = route.split()
        dx, dy = direction[d]
        ni, nj = si, sj
        chk = True

        # 이동 가능 여부 체크
        for _ in range(int(cnt)):
            ni += dx
            nj += dy
            if not (0 <= ni < w and 0 <= nj < h) or park[ni][nj] == 'X':
                chk = False
                break

        if chk:
            si, sj = ni, nj

    return [si, sj]
