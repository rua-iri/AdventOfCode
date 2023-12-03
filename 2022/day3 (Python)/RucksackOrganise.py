# solution to day 3 of the advent of code


def priorityCalc(chr):

    if chr.isupper():
        return (ord(chr) - 38)
    elif chr.islower():
        return (ord(chr) - 96)



#read the input file and save the data to a variable
with open("./input.txt") as inputFile:
    rucksackData = inputFile.readlines()


totalPriority = 0


gTotalPriority = 0
groupCounter = 0
groupList = []


#iterate through each bag 
for bag in rucksackData:
    compartOne = bag[:(len(bag)//2)]
    compartTwo = bag[(len(bag)//2):]

    sharedChar = ""
    groupChar = ""

    for i in range(len(compartOne)):
        for x in range(len(compartTwo)):

            if compartOne[i]==compartTwo[x]:
                sharedChar = compartOne[i]

    totalPriority += priorityCalc(sharedChar)


    #determine the shared letter in each group
    groupCounter+=1
    groupList.append(bag.strip())


    if groupCounter==3:

        for i in range(len(groupList[0])):

            if groupList[0][i] in groupList[1]:
                if groupList[0][i] in groupList[2]:
                    groupChar = groupList[0][i]
                    gTotalPriority += priorityCalc(groupChar)
                    break
        
        groupCounter = 0
        groupList = []




print("Part One Solution:")
print(totalPriority)

print("\nPart Two Solution:")
print(gTotalPriority)
