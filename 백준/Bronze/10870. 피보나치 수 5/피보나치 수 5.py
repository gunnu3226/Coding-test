def pibo(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    if n>=2:
        return pibo(n-1)+pibo(n-2)
a = int(input())
print(pibo(a))