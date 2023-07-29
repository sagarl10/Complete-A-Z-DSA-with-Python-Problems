a = [1, 2, 3, 4, 5, 6, 6]
b = [7, 7, 8, 8, 8, 10]
c = []
i = 0
j = 0
k = 0

while i < len(a) and j < len(b):
    if a[i] < b[j]:
        if len(c) == 0 or c[k - 1] != a[i]:
            c.append(a[i])
            k += 1
        i += 1
    elif b[j] < a[i]:
        if len(c) == 0 or c[k - 1] != b[j]:
            c.append(b[j])
            k += 1
        j += 1
    else:
        # If both elements are equal, add only one of them to c
        if len(c) == 0 or c[k - 1] != a[i]:
            c.append(a[i])
            k += 1
        i += 1
        j += 1

while i < len(a):
    if len(c) == 0 or c[k - 1] != a[i]:
        c.append(a[i])
        k += 1
    i += 1
    

while j < len(b):
    if len(c) == 0 or c[k - 1] != b[j]:
        c.append(b[j])
        k += 1
    j += 1
    

print(c)
