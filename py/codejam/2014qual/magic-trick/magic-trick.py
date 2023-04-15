import fileinput

f = fileinput.input()
T = int(f.readline())
for case in range(1, T + 1):
  a_ans = int(f.readline())
  for i in range(4):
    row = [int(x) for x in f.readline().split()]
    if i == a_ans - 1: s = set(row)
  nums = []
  b_ans = int(f.readline())
  for i in range(4):
    row = [int(x) for x in f.readline().split()]
    if i == b_ans - 1:
      for r in row:
        if r in s: nums.append(r)
  if len(nums) > 1: res = 'Bad magician!'
  elif len(nums) == 1: res = nums[0]
  else: res = 'Volunteer cheated!'
  print('Case #{0}: {1}'.format(case, res))