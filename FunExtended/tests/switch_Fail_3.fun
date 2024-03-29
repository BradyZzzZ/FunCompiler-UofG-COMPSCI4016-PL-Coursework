# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for switch overlap range value -- failure

proc main() :
    int x = 2
    switch x
        case 1..4: write(1)
        case 3..5: write(2)     # range overlap with the existing range error
        default: write(0) .
.