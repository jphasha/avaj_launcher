# avaj_launcher
applying what we learned in java now. Here we go.

-to run this program. just use the Makefile.

//COMPILE, RUN AND INSPECT OUTCOME
type (1)"make" in the command line.

-"make re" if you wish to recompile program.

-this will save you some time.

//OLD WAY OF DOING THINGS
-otherwise just go with stone age commands (type in the command line):

//COMPILATION
(1)"find -name *.java > sources.txt".
(2)"javac -sourcepath @sources.txt" OR "javac @sources.txt". (not sure why yet but my machine only allows the latter command).

//RUN PROGRAM
(3)"java za.co.wethinkcode.Simulation scenario.txt".

//INSPECT OUTCOME
(4)"cat -e simulation.txt".

-Tweak the contents of the scenario.txt file to see different outcomes of different scenarios.
