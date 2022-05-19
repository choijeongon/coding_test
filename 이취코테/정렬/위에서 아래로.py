N = int(input())

li = []

for i in range(N):
    val = int(input())
    li.append(val)

li.sort(reverse=True)

for val in li:
    print(val, end=' ')