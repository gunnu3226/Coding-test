def solution(lottos, win_nums):
    rank = [6,6,5,4,3,2,1]
    
    zero_num = lottos.count(0)
    lot_num = 0
    
    for i in lottos:
        for j in win_nums:
            if i==j:
                lot_num += 1
    return rank[zero_num+lot_num],rank[lot_num]
        