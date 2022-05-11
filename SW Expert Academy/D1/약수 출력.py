n = int(input())

result = ''

for i in range(n):
    if n % (i+1) == 0:
        result += str(i+1)
        result += ' '

print(result)