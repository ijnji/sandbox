import fileinput

f = fileinput.input()
T = int(f.readline())
for case in range(1, T + 1):
  C, F, X = [float(x) for x in f.readline().split()]
  rate = 2
  t = 0
  while True:
    t_req = t + X / rate
    t_req_farm = t + C / rate + X / (rate + F)
    if t_req_farm < t_req:
      t +=  C / rate
      rate += F
    else: break
  print('Case #{0}: {1:.7f}'.format(case, t_req))