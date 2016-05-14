#############   CONFIG  ##########
input = 'input'
output = 'output'
##################################

IN = open(input, 'r')
OUT = open(output, 'w')

def readLineRaw():
    return IN.readline().rstrip('\n')

def readLine():
    return IN.readline().strip()

def readInt():
    return int(readLine())

def readIntArr():
    return [int(i) for i in readLine().split(' ')]

def readStringArr():
    return [i for i in readLine().split(' ')]

def write(data):
    OUT.write(str(data))

def writeLine(data):
    write(str(data) + "\n")

def done():
    IN.close()
    OUT.close()