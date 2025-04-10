'''
1. 아이디어
- 가장 가까운 수: 두 수의 차이(절댓값)가 가장 작은 수
- 그럼 하나씩 다 접근해서 차이 구해야 함
- 그 중, 더 작은 원소를 리턴해야 하므로 > 리스트에 담아서 저장할까?
2. 시간복잡도
- O(N): 100 가능
3. 변수
- int 차이값 , 최소일 때 값을 저장해야 함
- int[] 

'''

def solution(array, n):
    
    array.sort()
    result = [abs(array[i]-n) for i in range(len(array))]
    
    return array[result.index(min(result))]