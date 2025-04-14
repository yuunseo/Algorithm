'''
1.아이디어
- 두 가지 경우로 구분하여 생각한다.
    1) sides 내에 있는 최대값이 가장 긴 변이다 
    - 최대값-나머지값 < x <= 최대값
    2) x가 가장 긴 변이다
    - 나머지 값들의 합 > x >나머지 값 중 최대값
- 개수를 구하기 위해서는 최대를 넘지 않을 때까지 +1씩 count를 올린다
2. 시간복잡도
- 더한 값 ~ 최대값 개수 n: O(N)
3. 변수
- int: 정수의 개수
'''
def count_valid_len(minitem,maxitem):
    start = maxitem- minitem+ 1
    end = maxitem
    if start > end:
        return 0
    return end - start + 1

def count_valid_len_out(minitem,maxitem):
    start = maxitem+1
    end = minitem+maxitem-1
    if start > end:
        return 0
    return end - start + 1

def solution(sides):

    maxitem = max(sides)
    minitem = min(sides)
    
    # 1) 가장 긴 변이 sides 안에 있는 경우
    #print(count_valid_len(minitem,maxitem))
    
    # 2) 가장 긴 변이 sides 밖에 있는 경우
    #print(count_valid_len_out(minitem,maxitem))
    
    return count_valid_len(minitem,maxitem) + count_valid_len_out(minitem,maxitem)
    