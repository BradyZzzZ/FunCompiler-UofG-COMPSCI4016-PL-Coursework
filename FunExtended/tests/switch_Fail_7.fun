# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for switch with undeclared var  -- running

proc main() :
    switch x + 1                   # undeclare error
        case 1: write(11)
        case 2: write(22)
        case 3: write(33)
        case 4: write(44)
        default: write(0) .
.