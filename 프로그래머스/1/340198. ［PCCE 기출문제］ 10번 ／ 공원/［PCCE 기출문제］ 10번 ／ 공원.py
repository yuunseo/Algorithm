'''def solution(mats, park):

    # 1. mats를 큰 변의 길이 순서대로 정렬한다
    mats.sort(reverse=True)
    
    # 2. mats에서 한 개씩 꺼내서, park에 자리가 있는지 확인
    total = []
    for mat in mats:
        for i in range(0,len(park)):
            temp = []
            for j in range(0,len(park)):
                if park[i][j:j+mat].count('-1') == mat:
                    print('i,j,mat = ',i,j,mat)
                    temp.append([i,j])
                    
            total.append(temp)
        print(mat)
        print(total)'''

def solution(mats, park):
    rows, cols = len(park), len(park[0])
    mats.sort(reverse=True)  # 큰 돗자리부터 시도

    for mat in mats:
        for i in range(rows - mat + 1):          # 세로 범위
            for j in range(cols - mat + 1):      # 가로 범위
                can_place = True
                for x in range(mat):             # 정사각형 내부 확인
                    for y in range(mat):
                        if park[i + x][j + y] != '-1':
                            can_place = False
                            break
                    if not can_place:
                        break
                if can_place:
                    return mat
    return -1
