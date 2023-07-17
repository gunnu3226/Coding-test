#풀이 1
def solution(babbling):
    answer = 0
    words = ["aya", "ye", "woo", "ma"]
    repeats = ["ayaaya", "yeye", "woowoo", "mama"]
    
    for x in babbling:
        for word in repeats:
            x = x.replace(word, "X")
        for word in words:
            x = x.replace(word, "O")
        
        isValid = True
        for char in x:
            if char != "O":
                isValid = False
                break
        if isValid == True:
            answer += 1
    
    return answer

#풀이 2
def solution(babbling):
    answer = 0
    for i in babbling:
        for j in ['aya','ye','woo','ma']:
            if j*2 not in i:
                i=i.replace(j,' ')
                print("i =", i)
        if len(i.strip())==0:
            answer +=1
    return answer
