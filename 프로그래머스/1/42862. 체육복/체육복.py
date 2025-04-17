'''
1. 아이디어
    - 2개를 가지고 있는 친구가 앞뒤에 친구에게 나누어 준다
    - 그 전에, 본인이 스스로 안가져왔을 경우를 먼저 처리 후, 나누어준다
'''
def solution(n, lost, reserve):
    
    # 1. 여벌을 가진 본인이 잃어버린 경우 처리
    # lost 와 reserve의 교집합이 존재할 경우, 처리
    intersec = set(lost)&set(reserve)
    if len(intersec) >= 1:
        reserve = set(reserve) - intersec
        lost = set(lost) - intersec
    
    # 2. 나눠줄 수 있는 사람이 있다면, 나눠주기
    # 학생들 기본 값 초기화
    students = [0 if i+1 in lost else 1 for i in range(n)]
    
    for i in reserve:
        students[i-1] += 1   
    
    for i in range(n):
        if students[i] == 2:
            if i>0 and students[i-1] == 0:
                students[i] -= 1
                students[i-1] += 1
            elif i<n-1 and students[i+1] == 0:
                students[i] -= 1
                students[i+1] += 1
    
    return len([i for i in students if i>0])