def canto(dash):
    if dash == 1:
        return '-'
    thislen = dash // 3
    return canto(thislen) + " " * thislen + canto(thislen)

while True:
    try:
        n = int(input())
        a = 3 ** n
        print(canto(a))
    except EOFError:
        break

    