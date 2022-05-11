val = int(input())

li = ''

for i in range(val, -1, -1):
    li += str(i)
    li += ' '

print(li)