n = int(input())

s = '1 '
v = 1

for i in range(n):
    v *= 2
    s += str(v)
    s += ' '

print(s)