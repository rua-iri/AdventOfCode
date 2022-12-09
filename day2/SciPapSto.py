#solution to day two's problem


#function to calculate the score achieved by a given move
def calcMoveScore(mve):
    if mve=="X":
        return 1
    elif mve=="Y":
        return 2
    elif mve=="Z":
        return 3


#function to calculate the score that results from the outcome of the game
def calcGameScore(opMove, myMove):

    #convert letters to ascii value
    opMove = ord(opMove) - 64
    myMove = ord(myMove) - 87

    #calculate a numerical value for the game's outcome
    gameOutcome = opMove - myMove

    #determine game's score based on outcome
    if gameOutcome==0:
        return 3
    elif gameOutcome==-1 or gameOutcome==2:
        return 6
    else:
        return 0


#function for calculating the real score after the strategy is fully decoded
def calcRealScore(myMove, opMove):
    score = 0

    if myMove=="X":
        score += 0
    elif myMove=="Y":
        score += 3
    elif myMove=="Z":
        score += 6

    score += whichMove(myMove, opMove)

    return score



def whichMove(myMove, opMve):

    winDict = {
        "A": 2,
        "B": 3,
        "C": 1
    }

    loseDict ={
        "A": 3,
        "B": 1,
        "C": 2
    }
    
    if myMove=="Y":
        return ord(opMve) - 64
    elif myMove=="X":
        return loseDict[opMve]
    elif myMove=="Z":
        return winDict[opMve]
    



#load data from the file
with open("./input.txt") as stratFile:
    gameStrategy = stratFile.readlines()


totalScore = 0
realScore = 0

#iterate through each round of the game
for ln in gameStrategy:
    opChoice, myChoice = ln.split(" ")
    myChoice = myChoice.strip()

    totalScore += calcGameScore(opChoice, myChoice)
    totalScore += calcMoveScore(myChoice)

    realScore += calcRealScore(myChoice, opChoice)



print("Part One solution:")
print(totalScore)



print("\nPart Two solution:")
print(realScore)




