# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for switch with integer case -- failure

proc main() :
    int x = 2
    switch x
        case 1: write(1)
        case 1: write(2)     # same case integer value error
        case 3: write(3)
        default: write(0) .
.