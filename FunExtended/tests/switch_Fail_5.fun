# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for switch with not-matched case value type -- failure

proc main() :
    bool x = true
    switch x
        case true: write(1)     
        case 2: write(2)       # type error
        case 3: write(3)       # type error
        default: write(0) .
.