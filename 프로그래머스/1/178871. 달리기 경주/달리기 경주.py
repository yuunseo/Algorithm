def solution(players, callings):
    '''
    1) 시간 복잡도 50000*1000000 => 약 1000억.. 실패
    callings에서 이름이 불린 사람 -> players에서의 인덱스 찾기 -> 바로 앞 사람과 변경
    callings에서 모두 불리고 나면 종료 -> 최종 결과 return
    하지만, callings에서 순서대로 가져와야 함!
    2) 딕셔너리로 변경..
    '''
    rank = {v:i for i,v in enumerate(players)} # name : 등수
    
    for name in callings:
        player_idx = rank[name]
        first_player_name = players[player_idx-1]
        
        players[player_idx], players[player_idx-1] = players[player_idx-1], players[player_idx]
        
        rank[name] = player_idx-1
        rank[first_player_name] = player_idx
        
        
    return players