"""
@author - Anirudh Sharma
"""


def maximum_sum(a):
    if a is None or len(a) == 0:
        return 0
    global_maximum = a[0]
    local_maximum = a[0]
    for i in range(1, len(a)):
        local_maximum = max(a[i], local_maximum + a[i])
        if global_maximum < local_maximum:
            global_maximum = local_maximum
    return global_maximum


a = [-2, -3, 4, -1, -2, 1, 5, -3]
print(maximum_sum(a))

a = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
print(maximum_sum(a))

a = [0, 1, 2, -2, 3, 2]
print(maximum_sum(a))

a = [-2, 2, 5, -11, 6]
print(maximum_sum(a))
