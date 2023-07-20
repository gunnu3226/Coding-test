def solution(X, Y):
    if len(Y)<len(X):
        a = Y
        Y = X
        X = a
    sorted_x = sorted(X)
    sorted_y = sorted(Y)
    answer_list = []
    i, j = 0, 0
    while i < len(sorted_x) and j < len(sorted_y):
        if sorted_x[i] == sorted_y[j]:
            answer_list.append(sorted_x[i])
            i += 1
            j += 1
        elif sorted_x[i] < sorted_y[j]:
            i += 1
        else:
            j += 1
                    
    if len(answer_list) == 0:
        return "-1"
    if list(set(answer_list))[0]=='0' and len(set(answer_list))==1:
        return "0"
    answer_list.sort(reverse=True)      
                
    return ''.join(map(str, answer_list))