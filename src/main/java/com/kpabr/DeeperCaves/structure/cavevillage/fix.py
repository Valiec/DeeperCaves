for i in range(29):
	print "Processing CaveVillage"+str(i).zfill(3)+".java..."
	f = open("CaveVillage"+str(i).zfill(3)+".java", "r")
	lines = f.readlines()
	newlines = []
	doors = []
	ladders = []
	f.close()
	for line in lines:
		#if "grass" in line or "dirt" in line:
		#	print "line \""+line+"\" found."
		#	lines.remove(line)
		isDoor = False
		if "wool, 1" in line:
			print "line \""+line+"\" found."
			line = line.replace("wool, 1", "air, 0")
		if "wool, " in line:
			print "line \""+line+"\" found."
			line = line.replace("wool, 2", "wheat, 0")
		if "wool, " in line:
			print "line \""+line+"\" found."
			line = line.replace("wool, 9", "farmland, 0")
		if "farmland, 0" in line:
			print "line \""+line+"\" found."
			line = line.replace("farmland, 0", "farmland, 7")
		'''if "door" in line:
			print "line \""+line+"\" found."
			doors.append(line)'''
		if "ladder" in line:
			print "line \""+line+"\" found."
			ladders.append(line)
			isDoor = True
		if not isDoor:
			newlines.append(line)
	newlines.extend(doors)
	newlines.extend(ladders)
	data = "".join(newlines)

	f = open("CaveVillage"+str(i).zfill(3)+".java", "w")
	f.write(data)
	f.close()
