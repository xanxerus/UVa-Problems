#!/usr/bin/env python3

while True:
	n = int(input())
	if n == 0:
		break
	
	start = int(input())-1
	
	arr = {x:(set(), set()) for x in range(n)}
	# x : ( {parents}, {children} )
	
	
	while True:
		a, b = map(int, input().strip().split())
		if (a, b) == (0, 0):
			break
		
		arr[a-1][1].add(b-1)
		arr[b-1][0].add(a-1)
	
	#Topological sort

	starti = 0
	L = []
	S = set(x for x in range(n) if not arr[x][0]) #s with no parent
	while S:
		n = S.pop()
		if n == start:
			starti = len(L)-1
		L.append([n, 0])
		for m in arr[n][1]:
			arr[m][0].remove(n)
			if not arr[m][0]:
				S.add(m)
	
	mostLen = 0
	mostEnd = 0
	L[starti][1] = 1;
	for x in range(starti+1, len(L)):
		for child in arr[L[x][0]][1]:
			L[child][1] += L[x][1]
			if L[child][1] > mostLen:
				mostLen = L[child][1]
			if L[child][1] == mostLen and L[child][0] < mostEnd:
				mostEnd = L[child][0]
	
	print("The longest path from %d has length %d, finishing at %d.\n" % (start+1, mostLen, mostEnd+1))

