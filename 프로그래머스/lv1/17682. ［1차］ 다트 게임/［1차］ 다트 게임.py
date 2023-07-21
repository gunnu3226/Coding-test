def solution(dartResult):
    ans = []
    n = 0
    dartResult = dartResult.replace('10','t')
    for i in dartResult:
        if i.isnumeric():
            n = int(i)
            continue
        elif i == 't':
            n = 10
            continue
        elif i == 'S':
            ans.append(n)
        elif i == 'D':
            ans.append(n**2)
        elif i == 'T':
            ans.append(n**3)
        elif i == '*':
            if len(ans) == 1:
                ans[-1] = ans[-1]*2
            else:
                ans[-2] = ans[-2]*2
                ans[-1] = ans[-1]*2
        elif i =='#':
            ans[-1] = ans[-1]*(-1)
    
    return sum(ans)
            
                
        
        
    
    
    
                       
            
    return answer