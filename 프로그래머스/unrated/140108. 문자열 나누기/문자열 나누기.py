def solution(word):
    answer = 0
    word_len = len(word)-1
    while word_len>0:
        first = word[0]
        first_num = 1
        other_num = 0
        for i in range(1,len(word)):
            if word[i] == first and first_num!=other_num:
                first_num += 1
                word_len -= 1
            elif word[i] != first and first_num!=other_num:
                other_num += 1
                word_len -= 1
            if first_num == other_num:
                answer += 1
                word = word[i+1:]
                word_len = len(word)-1
                break
    if len(word)!=0:
        answer +=1
                
                
    return answer