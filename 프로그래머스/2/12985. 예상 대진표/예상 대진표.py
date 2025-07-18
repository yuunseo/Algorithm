'''
1.아이디어
    인접한 두 명끼리 게임 > 다시 순서 배정 (1 ~ n/2) & 라운드 횟수 증가 > 다시 게임 > 1명이 남을 때까지 반복
    a,b가 몇 번째 라운드에서 만나는 지 반환 
    A,b는 서로 만나기 전까지 계속 이김!
    A,b 아닌 애들은 번호 더 작은 애가 이김! 
    
    해결방법 : 선수들의 출전 순서를 아이디어로 잡자
    한 라운드가 끝날 때마다, 이긴 선수들은 선수 번호가 n/2로 변경됨 > 두 선수의 번호가 같아지면 서로 만난 것!
'''
def solution(n, a, b):
    answer = 0
    while a != b:
        a = (a + 1) // 2
        b = (b + 1) // 2
        answer += 1
    return answer

    
        