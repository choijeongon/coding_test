
n, m = map(int, input().split())

minValue = 0
min_max_value = 0

for i in range(n):
    data = list(map(int, input().split()))
    minValue = min(data)
    min_max_value = max(min_max_value, minValue)

print(min_max_value)
