def solution(wallpaper):
    # wallpaper [i,j] empty . file #
    # S, E distance: abs(rdx-lux) + abs(rdy-luy)
    # S, E extant: abs(rdx-lux) *  abs(rdy-luy)
    answer = []
    maxX = 0
    maxY = 0
    minX = float('inf')
    minY = float('inf')
    
    wallarray = [list(i) for i in wallpaper]
    #print(wallarray)
    
    # 1. 꼭지점이 될 x,y좌표 구하기
    for i in range(len(wallarray)):
        for j in range(len(wallarray[i])):
            if wallarray[i][j] == '#': # 파일이면서, 그 때의 위치를 최소 값으로 갱신
                minX = min(minX,j)
                minY = min(minY,i)
                maxX = max(maxX,j)
                maxY = max(maxY,i)
                
    answer = [minY,minX,maxY+1,maxX+1] # 칸을 드래그하는 것이 아닌, 좌상단/우하단 꼭짓점을 선택하는 것이므로, +1
    
    
    return answer