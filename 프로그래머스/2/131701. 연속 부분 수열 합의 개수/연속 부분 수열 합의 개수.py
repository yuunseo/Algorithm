'''
1.아이디어
    연속된 수들의 합으로 만들 수 있는 숫자의 모든 경우의 수 구하기
    연속된 수의 개수에 따라 경우의 수가 달라지겠지
    1개씩 > 2개씩 > 3개씩 > ... > n개씩 연속된 수의 합 
    이 와중에 중복되는 값은 제외해야 하니까 set에 넣어버리자
'''
def solution(elements):
    sum_set = set()
    
    n = len(elements)
    extended = elements * 2 # 원형으로 만들기 위해서

    for i in range(1, n + 1):  # 부분합 길이
        for j in range(n):  # 시작 위치
            part_sum = sum(extended[j:j + i])
            sum_set.add(part_sum)

    return len(sum_set)
