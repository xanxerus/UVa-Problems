#!/usr/bin/env python3
from operator import mul
from functools import reduce

T = [1]*301
for x in range(2, 301):
	T[x] = sum(T[x-k-1]*T[k] for k in range(x))


def factorial(n):
	if n <= 1:
		return 1
	else:
		return reduce(mul, range(1, n+1))

def fun(q):
	return T[q] * factorial(q)

while True:
	q = int(input())
	if q == 0:
		break
	else:
		print(fun(q))
