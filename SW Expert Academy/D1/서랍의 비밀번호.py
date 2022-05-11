p, k = list(map(int, input().split()))

count = 1

for i in range(p):
    if k == p:
        break
    count += 1
    k += 1

print(count)