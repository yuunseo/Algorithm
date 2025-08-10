''' 
- 자카드 유사도 J(A,B) = 두 집합의 교집합 크기 / 합집합 크기, 모두 공집합일 경우, 1로 정의
- 자카드 유사도 다중집합 = 교집합은 min() / 합집합은 max()

- 모두 소문자로 변경 -> 2글자씩 집합으로 나눈 후, 영문자 이외 문자 포함 시 제외
- 다중집합 자카드 유사도 값 * 65536

<아이디어>
1. str을 모두 소문자화
2. 두 글자씩 쌍으로 만든 후, 영문자 제외인 쌍은 삭제
3. 교집합은: 서로 같은 것 모두 구하는 데 대신 min이라서 집합으로 구하기
4. 합집합은: 서로 같은 것 모두 구하기 max라서 중복 허용

<시행착오>
단순하게 set으로 개수를 비교하니까, 동일한 아이템을 가진 경우 모두 제외됨
따라서 counter라는 자료구조를 활용해서 재도전

'''

from collections import Counter
import math

def solution(str1, str2):
    
    # 1. str1, str2 소문자화
    str1 = str1.lower()
    str2 = str2.lower()
    
    #2. 2개씩 쌍 만들기
    str1List = []
    for i in range(0,len(str1)-1):
        first = str1[i]
        second = str1[i+1]
        
        # 모두 알파벳일 경우, 비교 대상으로 추가하기
        if(first.isalpha() and second.isalpha()):
            str1List.append(str1[i:i+2])
        else:
            continue
    
    str2List = []
    for i in range(0,len(str2)-1):
        first = str2[i]
        second = str2[i+1]
        
        if(first.isalpha() and second.isalpha()):
            str2List.append(str2[i:i+2])
        else:
            continue
    
    str1Counter = Counter(str1List)
    str2Counter = Counter(str2List)
    
    # 3. 두 배열의 교집합 구하기 - 중복 미허용
    interCount = 0
    for item in str1Counter:
        if(item in str2Counter):
            interCount += min(str1Counter[item], str2Counter[item])
    
    # 4. 두 배열의 합집합 구하기 - 중복 허용
    unionCount = 0
    all_elements = set(str1Counter.keys()) | set(str2Counter.keys())
    for element in all_elements:
        count1 = str1Counter.get(element, 0)
        count2 = str2Counter.get(element, 0)
        unionCount += max(count1, count2)
        
    
    # 5. 자카드 유사도 계산 및 결과 반환
    if unionCount == 0:  # 둘 다 공집합인 경우만
        return 65536
    else:
        jaccard_similarity = interCount / unionCount
        return int(jaccard_similarity * 65536)  # int()는 버림 처리
        
    