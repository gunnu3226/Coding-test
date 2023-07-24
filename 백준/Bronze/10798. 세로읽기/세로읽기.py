words = []
length = []
ans = ''
for _ in range(5):
    word = input()
    words.append(word)
    length.append(len(word))
for i in range(max(length)):
    for j in range(5):
        if i < length[j]:
            ans += words[j][i]
print(ans)