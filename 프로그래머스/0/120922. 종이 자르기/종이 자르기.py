'''
1. 아이디어
    - 1*1이 될 때까지 가위질이 필요함
    1) 길이가 짧은 변을 선택하여, 길이 1짜리 변을 가지도록 여러 개를 만든다.
        이때, m의 길이를 가졌을 때 1짜리 변을 만들기 위해서는 (m-1)번의 가위질이 필요하며, m개의 덩어리로 나뉜다.
    2) 다음으로, 남은 변의 길이 n도 마찬가지로 길이 1짜리 변을 가지도록 자른다.
        위와 마찬가지로 (n-1)번의 가위질이 필요하며, (n-1)번 가위질을 m번 해 주어야 한다.
    3) 결과적으로는
        (m-1)번 + (n-1)*m번 가위질이 필요하다
'''

def solution(M, N):
    return (M-1)+(N-1)*M