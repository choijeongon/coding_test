
import collections

data_list = list(map(int, input().split()))

counter_list = collections.Counter(data_list).most_common()