# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for repeat-until with boolean value -- running

proc main() :
    bool flag = false
    repeat:
        flag = not flag
        if flag:
            write(1)
        else:
            write(0) .
    until flag .
.
