'''
1. 아이디어
    - n과 가까운 수를 정렬 할 예정
        - 해당 숫자 & n과의 차이값을 동시에 저장해서, 해당 숫자에 대해 내림차순 정렬 + insert n을 해보자
'''
def solution(numlist, n):
    
    difflist = [(abs(i-n),i) for i in numlist]
    
    return [i[1] for i in sorted(difflist, key=lambda x:(x[0],-x[1]))]