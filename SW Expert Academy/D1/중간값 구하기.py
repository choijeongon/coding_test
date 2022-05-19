# t = input()

# data = list(map(int, input().split()))

# data = sorted(data)

# print(data[len(data)//2])


N = int(input())

data = list(map(int, input().split()))

data.sort()

print(data[len(data)//2])

# sort는 자신을 직접 바꾸고, sorted는 정렬한 배열을 새로 리턴한다.