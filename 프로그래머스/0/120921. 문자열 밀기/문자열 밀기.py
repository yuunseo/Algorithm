def solution(A, B):
    
    if A == B:
        return 0

    AList = list(A)
    for count in range(1, len(A)+1):
        AList = AList[-1:] + AList[:-1]  # 오른쪽으로 한 칸 회전
        if ''.join(AList) == B:
            return count

    return -1