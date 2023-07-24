def solution(lottos, win_nums):
    answer = []
    rank = {6:1,
           5:2,
           4:3,
           3:4,
           2:5,
           1:6,
           0:6}
    lot = 0
    zero_num = 0
    for win in win_nums:
        for lotto in lottos:
            if win == lotto:
                lot += 1
    for zero in lottos:
        if zero == 0:
            zero_num += 1
    answer.append(rank[lot+zero_num])
    answer.append(rank[lot])
    return answer