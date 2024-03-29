# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for switch with overlap range value -- failure

proc main() :
    int x = 3
    switch x
        case 1: write(1)
        case 2: write(2)
        case 2..5: write(3)     # range overlap with the existing value error
        default: write(0) .
.