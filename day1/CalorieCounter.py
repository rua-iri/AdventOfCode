#Solution to the Day 1 problem of advent of code


#open file store it's data to a variable
with open("./input.txt", "r") as inputFile:
    calData = inputFile.readlines()


#create new list for each elf and a variable for the ammount of calories they are carrying
elfList = []
calsCarried = 0

#iterate through each line of the file
for ln in calData:

    #add up the calories for each elf and separate them on each newline
    if ln=="\n":
        elfList.append(calsCarried)
        calsCarried = 0
    else:
        calsCarried += int(ln)



#iterate through each elf and find which is carrying the most calories

mostCalories = 0
strongestElf = 0

for i in range(len(elfList)):
    if elfList[i]>mostCalories:
        mostCalories = elfList[i]
        strongestElf = i


print(strongestElf)
print(mostCalories)