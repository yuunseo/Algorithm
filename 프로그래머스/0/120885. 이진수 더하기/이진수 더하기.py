def solution(bin1, bin2):
    
    #문자열을 정수로 바꿀 땐, int() -> 2진수이므로 인자 추가
    answer = int(bin1,2) + int(bin2,2)
    
    # 정수를 문자열로 전환 -> 2진수 문자열이므로 bin(), 0b제거를 위해 인덱스 2부터
    return bin(answer)[2:]