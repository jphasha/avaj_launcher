# avaj_launcher
applying what we learned in java now. Here we go.

-to run this program. just use the Makefile.

//COMPILE AND RUN
type (1)"make" in the command line.

//INSPECT OUTCOME
to see the outcome of the program. type (2)"cat -e simulation.txt".

-"make re" if you wish to recompile program.

-this will save you some time.

-otherwise just go with stone age commands (type in the command line):

//COMPILATION
(1)"find -name *.java > sources.txt".
(2)"javac -sourcepath @sources.txt" OR "javac @sources.txt". (not sure why yet but my machine only allows the latter command).

//RUN PROGRAM
(3)"java za.co.wethinkcode.Simulation scenario.txt"

//INSPECT OUTCOME
(4)"cat -e simulation.txt"

Also you are welcome to edit the scenario file once you understand what is going on.
