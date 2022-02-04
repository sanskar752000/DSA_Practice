def Euclidgcd(a, b):
	if b == 0:
		return a
	else:
		a1 = a % b
		# print(a1)
	return Euclidgcd(b, a1)

gcd = Euclidgcd(357, 234)
print(gcd)