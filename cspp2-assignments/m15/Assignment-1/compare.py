file1  = open("output001.txt","r")
file2 = open("o.txt","r")

d1 = file1.read().splitlines()
d2 = file2.read().splitlines()

for i in range(len(d1)):
	if(d1[i] != d2[i]):
		print(i)
		print(d1[i])
		print(d2[i])
# print(file1.read())
