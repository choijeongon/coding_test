import collections
max = 10 ** 3
sieve = collections.defaultdict(lambda: True)
print(sieve)
do = int(max ** (1/2))

for i in range(2, do+1):
    if sieve[i]:
        for j in range(i+i, max+1, i):
            sieve[j] = False

for n in range(2, max+1):
    if sieve[n]:
        print(n, end=' ')