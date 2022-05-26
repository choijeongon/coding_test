#1
# n = int(input())

# result = ''

# for i in range(n):
#     if n % (i+1) == 0:
#         result += str(i+1)
#         result += ' '

# print(result)



#2
N = int(input())

for index in range(1, N+1):
    if N % index == 0:
        print(index, end= ' ')
