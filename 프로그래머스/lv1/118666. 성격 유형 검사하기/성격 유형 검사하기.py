def solution(survey, choices):
    answer = ''
    dic = {'RT':0,'CF':0,'JM':0,'AN':0}
    for A,B in zip(survey,choices):
        if A not in dic.keys():
            A = A[::-1]
            dic[A] -= B-4
        else: 
            dic[A] += B-4
            
    for name in dic.keys():
        if dic[name]>0:
            answer += name[1]
        elif dic[name]<0:
            answer += name[0]
        else:
            answer += sorted(name)[0]
            
    return answer