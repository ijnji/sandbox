## Notes (Python 3.x)

```python
x = x & x - 1 # drops the lowest set bit of x
i = x ^ (x & (x - 1)) # index of the lowest set bit
```

### Primitives
```python
4, 4.0, 5j, 0b10, 0xff
True, False, None
('hello', 1)
'\\asdf' # '\asdf'
r'\\asdf' # raw string, '\\asdf'
'\x42' # 'B'
'\u0394' # unicode, 'Δ'
```
```python
abs(-34.5) == 34.5
math.ceil(2.17) == 3.0
math.floor(3.14) == 3.0
min(1, 2) == 1
max(3.14, 4.0) == 4.0
pow(2, 10) == 1024
2 ** 10 == 1024
math.sqrt(225) == 15.0
```
```python
float('inf') # psuedo min/max, floats don't have infinite precision
sys.maxint
math.isclose() # preferred float comparison
```

### Bitwise Operations
```python
6 & 4 == 4
1 | 2 == 3
8 >> 1 == 4
~0 == -1
0b1010 ^ 0b0101 == 0b1111
```

### String Operations
```python
s = 'hello'
s[3] = 'l'
s = 'abc' + 'def;'
s[2:4] == 'cd'
'abc' in s
```
```python
s.tolower()
s.strip()
s.startswith(prefix)
s.endswith(suffix)
'apple,peach,pear'.split(',')
','.join('Gauss', 'Prince of Mathematicians') # any iterable can be joined
'Name name, Rank rank'.format(name='Archimedes', rank=3)
'Hello my name is {0}'.format('Doug')
```

### Conversions
```python
int('10')
str(10)
```
```python
ord('a') # 97
chr(97) # 'a'
chr(1234) # 'Ӓ'
```

### Lists
```python
[3, 5, 7, 11]
[1] + [0] * 10
list(range(100))
A[inclusive_start:exclusive_end:step]
A[-1] # last element
a in A # O(n)
len(A)
min(A)
max(A)
```
```python
A.append(42)
A.remove(value) # throws ValueError if not found
A.insert(i, 28) # O(n)
A.pop() # O(1), from end
A.pop(i) # O(n)
del A[i]
```
```python
sorted(A, key=lambda o: o.name, reverse=False) # new primitives, shallow objects
reversed(A) # returns an iterator
A.sort() # in-place
A.reverse() # in-place
grades = [50, 60, 70, 80, 90]
```
```python
bisect.bisect_left(grades, 60) # 1, O(logn)
bisect.bisect_right(grades, 60) # 2, same as bisect()
bisect.insort_left(grades, 60) # inserts into 1
bisect.insort_right(grades, 60) # inserts into 2, same as insort()
```
```python
B = A # assign reference
B = list(A) # new primitives, shallow objects
copy.copy(A) # shallow copy
copy.deepcopy(A) # deep copy
```
```python
[x**2 for x in range(6)]
[x**2 for x in range(6) if x % 2 == 0]
[(x, y) for x in [1, 2, 3] for y in [7, 8, 9]] # (1, 7), (1, 8), (1, 9), etc
```

### Stacks
```python
stk = []
que.append(6); que.append(5); que.append(4)
stk.pop() # 4, O(1)
```

### Queues
```python
import collections
que = collections.deque()
que.append(6); que.append(5); que.append(4)
que.popleft() # 6, O(1)
que.pop() # 4, O(1)
```

### Heaps
```python
import heapq
hep = []
heapq.heappush(hep, 6); heapq.heappush(hep, 5); heapq.heappush(hep, 4)
heapq.heappop(hep) # 4
heapq.heappushpop(hep, 7) # 5
heapq.nlargest(2, hep) # [7, 6]
heapq.nsmallest(1, hep) # [6]
```
```python
# mutiply key by -1 for max-heap
# keys in tuple and list are [0], [1], ... [-1]
# supporting priority changes:
#   1. entry = [priority, count, task]
#   2. use a dict to locate entries
#   3. use an incrementing counter to track insertion order
#   4. mark old entry[-1] as 'REMOVED'
#   5. add new entry with new priority 
```

### Dictionaries
```python
h = {}
h = {1: 'abc', 3: 'xyz'}
for k in h: ... # keys
h.items() # key-value tuples
h.values()
del h[1]
```

### Sets
```python
s = set()
s = {1, 2, 3}
s.add(4)
s.remove(4)
s.update([4, 5])
s - {2} # {1, 3, 4, 5}
{4, 5} < s # subset
```

### Random
```python
random.randrange(30) # [0, max-1)
random.randint(min, max) # [min, max]
random.random() # [0.0, 1.0)
random.shuffle(A) # in-place
random.choice(A) # returns random element
```

### Iterators
```python
it = iter([5, 6, 7, 8, 9])
next(it) # 5
for x in it: print(x) # 6, 7, 8, 9
```
