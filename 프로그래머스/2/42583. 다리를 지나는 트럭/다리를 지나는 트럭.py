def solution(bridge_length, weight, truck_weights):

    result = []
    bridge_weight = 0 # 다리 위 총 무게

        
    for i in truck_weights:
        
        while bridge_weight + i > weight:
            result.append(0) 
            if len(result) >= bridge_length: # 다리 위에 올라갈 수 있는 최대가 되면, 맨 처음 넣은 트럭은 제거
                bridge_weight -= result[-bridge_length]

        result.append(i)
        if len(result) >= bridge_length:
            bridge_weight -= result[-bridge_length]
        bridge_weight += i

    result += [0]*bridge_length
    
    return len(result)