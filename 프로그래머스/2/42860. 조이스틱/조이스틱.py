'''
1.아이디어
    - 알파벳을 아스키코드로 비교하면서 동일한 문자 나올 때까지 이동 
    - 동일 문자 나오면, 커서 이동 
    - 고려해야 할 경우의 수
    1) 위로/아래로
        대상과 "A"와의 ord() 숫자 차이 > 그만큼 이동
        이때, A>Z일때의 차이 vs A<Z일때의 차이 중 적은 것으로 선택
    2) 왼쪽으로/오른쪽으로
        각 대상의 odr()가 가장 작은 곳에서 끝나도록  ?? 우선 얘는 없이 해보자  
'''
def solution(name):
    answer = 0
    length = len(name)

    # 1. 위/아래로 바꾸는 횟수
    for ch in name:
        answer += min(ord(ch) - ord('A'), ord('Z') - ord(ch) + 1)

    # 2. 좌우로 이동하는 최소 횟수 계산
    move = length - 1  # 오른쪽으로만 가는 경우

    for i in range(length):
        next_idx = i + 1
        # 연속된 A의 끝 찾기
        while next_idx < length and name[next_idx] == 'A':
            next_idx += 1
        # 오른쪽으로 갔다가 왼쪽으로 꺾기
        move = min(move, 2 * i + length - next_idx)
        # 왼쪽으로 갔다가 오른쪽으로 꺾기
        move = min(move, i + 2 * (length - next_idx))

    answer += move
    return answer
