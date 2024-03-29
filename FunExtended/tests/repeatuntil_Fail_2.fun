# Name: Bin Zhang
# Student ID: 2941833z
# Date: 14th May 2024

## EXTENSION: Test for repeat-until with undeclared var -- failure

proc main() :
    repeat:
        write(1)
    until undelcount == 10 .      # undeclare error
.