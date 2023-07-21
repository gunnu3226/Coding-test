# -를 기준으로 나누어서 리스트로 입력 받기
cal = list(input().split('-'))
ans = []

for div in cal:
    sum_cal = list(map(int,div.split('+')))
    ans.append(sum(sum_cal))
answer = ans[0]

for i in range(1,len(ans)):
    answer -= ans[i]
    
print(answer)
