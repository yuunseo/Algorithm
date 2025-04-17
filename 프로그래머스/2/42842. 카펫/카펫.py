def solution(brown, yellow):
    
    total = brown + yellow

    for height in range(3, total):  # 세로는 최소 3부터
        if total % height == 0: # height를 임의로 잡고, 가능한 width를 구해서 계산해 본다.
            width = total // height
            if (width - 2) * (height - 2) == yellow: # 가능한 height와 width일 때, 노란색의 개수가 맞을 경우 return
                return [width, height]