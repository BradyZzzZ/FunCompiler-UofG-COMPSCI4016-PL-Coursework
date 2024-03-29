# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for switch with nested switch commands -- failure

proc main() :
    int x = 1
    bool y = true
    switch x
        case 1..3: 
            switch y
                case true: write(1)
                case 2: write(2)            # type error
                default: write(0) .
        case true:                          # type error
            switch y
                case true: write(3)
                case false: write(4)
                default: write(0) .
        case 3..5: write(5)                 # range overlap error
        default: write(0) 
    .
.