'''
1. 아이디어
- 행수 > 열수: 각 list에 append(0)
    - 행 길이만큼 0으로 구성되도록 리스트에 추가
- 행수 < 열수: 전체 list에 append([0, ..., 0])
    - 열 길이만큼 0으로 구성된 리스트 추가
    >> extend가 조금 더 빠르게 실행 가능
2. 시간복잡도
- 각 열 혹은 행에다가 각각 추가해야 하므로, O(N^2)
- 필요한 개수 세기
- 길이 세기: O(N^2)
'''

def solution(arr):
    row, col = len(arr), len(arr[0])
    
    if row > col:
        diff = row-col
        for a in arr:
            a.extend([0]*diff)
    else:
        diff = col-row
        arr.extend([[0]*col for i in range(diff)])

    return arr