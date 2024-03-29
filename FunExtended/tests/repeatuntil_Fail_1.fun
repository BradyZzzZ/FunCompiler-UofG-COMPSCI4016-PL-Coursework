# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for repeat-until with integer value -- failure

proc main() :
    int count = 0
    repeat:
        write(count)
        count = count + 1
    until count + 5 .        # type error
.