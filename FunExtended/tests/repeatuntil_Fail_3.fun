# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for repeat-until with nested repeat-until command -- failure

proc main() :
    int count = 0
    int x = 0
    repeat:
        repeat:
            write(x)
            x = x + 1
        until x + 2 .           # type error
        count = count + 1
    until count == 5 .
.
