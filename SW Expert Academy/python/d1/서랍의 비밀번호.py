
#1
# p, k = list(map(int, input().split()))

# count = 1

# for i in range(p):
#     if k == p:
#         break
#     count += 1
#     k += 1

# print(count)


#2
P, K = map(int, input().split())

count = 0

while P >= K:
    K += 1
    count += 1

print(count)
