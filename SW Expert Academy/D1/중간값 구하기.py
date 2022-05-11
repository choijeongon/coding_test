t = input()

data = list(map(int, input().split()))

data = sorted(data)

print(data[len(data)//2])
