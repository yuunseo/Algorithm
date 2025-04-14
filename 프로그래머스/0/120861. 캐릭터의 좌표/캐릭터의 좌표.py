'''
1. 아이디어
    1) board의 정 중앙 좌표 값 찾기
    2) 좌표값에서부터 key를 이용해 이동하기
        - 크기를 넘어갈 순 없으므로, 제한해두기

'''
def solution(keyinput, board):
    width = [- (board[0]-1)//2,(board[0]-1)//2]
    length = [- (board[1]-1)//2,(board[1]-1)//2]
    
    base = [0,0]
    
    for k in keyinput:
        if k == "left" and width[0] < base[0] <= width[1]:
            base[0] -= 1
        elif k == "right" and width[0] <= base[0] < width[1]:
            base[0] += 1
        elif k == "up" and length[0] <= base[1] < length[1]:
            base[1] += 1
        elif k == "down" and length[0] < base[1] <= length[1]:
            base[1] -= 1
            
    return base