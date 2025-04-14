'''
1.아이디어
- arr를 set으로 만들어서 중복을 없앤다
    > 순서가 저장이 안 되므로 불가능
- dict를 이용하여 key로 변경하여 저장해서 사용한다
2. 시간복잡도
- set만들기 O(N)
- sortd list 만들기 O(N)
- k개 만큼 잘라내기 O(N)
- k개까지 채우기 O(k-len(arr))
3. 변수
- 중복 없앤 리스트: int[]
'''

def solution(arr, k):
    new_arr = list(dict.fromkeys(arr))
    
    if len(new_arr) < k:
        for i in range(k-len(new_arr)):
            new_arr.append(-1)
        return new_arr
    else:
        return new_arr[:k]
    
            
        