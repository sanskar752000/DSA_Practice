def Naivegcd(a,b):
	
	best = 0
	for d in range(1,a+b):
		if d/a and d/b:
			best = d
	return best

Naivegcd(10, 4)