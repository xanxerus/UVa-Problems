#!/usr/bin/env python3

def isCarmichael(n):
	return n in {561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973}

while True:
	q = int(input())
	if q == 0:
		break

	if isCarmichael(q):
		print("The number %d is a Carmichael number." % q)
	else:
		print("%d is normal." % q)

