'''
1.아이디어
- arr[s:e+1]이라는 값을 하나씩 꺼내서 비교한다
    > k보다 크면서 가장 작아야 하므로, 정렬한 후, k 다음 원소를 반환하자
        > k가 없을 수 있으므로, k 인덱스를 알 수 없음
    > k보다 큰 값들만 리스트에 넣고, 정렬로 1번째 원소 가져오기
        > 만약 원소가 없다면 -1 반환
2. 시간복잡도
- O(Q*N): queries 원소(Q)만큼 반복하다가, s~e만큼(N) 반복
- O(N): 최소값
'''

def solution(arr, queries):
    result = []
    
    for s,e,k in queries:
        new_arr = [arr[i] for i in range(s,e+1) if arr[i]>k]
        if len(new_arr) != 0:
            result.append(min(new_arr))
        else:
            result.append(-1)
            
    return result