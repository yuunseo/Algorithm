'''
1.아이디어
- query를 하나씩 가져와서, s<=i<=e 계산 후, 결과물 반환
2.시간복잡도
- O(N^2): 각 쿼리별로, 범위 구해서 값 처리하기
3.변수


'''

def solution(arr, queries):
    
    for s,e,k in queries:
        for i in range(s,e+1):
            if i%k==0:
                arr[i] += 1
                
    return arr