def solution(survey, choices):
    answer = ''
    R = 0
    T = 0
    C = 0
    F = 0
    J = 0
    M = 0
    A = 0
    N = 0
    grade = {1:3,
            2:2,
            3:1,
            4:0,
            5:1,
            6:2,
            7:3}
    for i in range(len(survey)):
        if survey[i] == 'AN':
            if choices[i] <= 3:
                A += grade[choices[i]]
            elif choices[i] >=5:
                N += grade[choices[i]]
        elif survey[i] == 'NA':
            if choices[i] <= 3:
                N += grade[choices[i]]
            elif choices[i] >=5:
                A += grade[choices[i]]
        elif survey[i] == 'CF':
            if choices[i] <= 3:
                C += grade[choices[i]]
            elif choices[i] >=5:
                F += grade[choices[i]]
        elif survey[i] == 'FC':
            if choices[i] <= 3:
                F += grade[choices[i]]
            elif choices[i] >=5:
                C += grade[choices[i]]
        elif survey[i] == 'JM':
            if choices[i] <= 3:
                J += grade[choices[i]]
            elif choices[i] >=5:
                M += grade[choices[i]]
        elif survey[i] == 'MJ':
            if choices[i] <= 3:
                M += grade[choices[i]]
            elif choices[i] >=5:
                J += grade[choices[i]]
        elif survey[i] == 'RT':
            if choices[i] <= 3:
                R += grade[choices[i]]
            elif choices[i] >=5:
                T += grade[choices[i]]
        elif survey[i] == 'TR':
            if choices[i] <= 3:
                T += grade[choices[i]]
            elif choices[i] >=5:
                R += grade[choices[i]]
    if R >= T:
        answer += 'R'
    else:
        answer += 'T'
    if C >= F:
        answer += 'C'
    else:
        answer += 'F'
    if J >= M:
        answer += 'J'
    else:
        answer += 'M'
    if A >= N:
        answer += 'A'
    else:
        answer += 'N'
        
    return answer