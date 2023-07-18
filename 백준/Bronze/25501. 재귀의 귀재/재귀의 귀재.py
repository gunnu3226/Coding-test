def recursion(s, l, r, i = 0):
    i += 1
    if l >= r: return 1,i
    elif s[l] != s[r]: return 0,i
    else: return recursion(s, l+1, r-1, i)

def isPalindrome(s):
    return recursion(s, 0, len(s)-1)

n = int(input())
a = 0
for i in range(n):
    a,b = isPalindrome(input())
    print(a,b)
    