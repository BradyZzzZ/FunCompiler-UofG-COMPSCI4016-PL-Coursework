# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for switch with bool case -- failure

proc main() :
    int x = 2
    switch x == 2
        case true: write(1)
        case false: write(2)     
        case false: write(3)        # same case bool value error
        default: write(0) .
.