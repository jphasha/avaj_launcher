package = za/co/wethinkcode/royalAirServices/

OBJ = $(package)Simulator.class

SRC = $(package)Simulator.java

all: run
	@cat -e simulation.txt

run: $(OBJ)
	@java $(package)Simulator scenario.txt

$(OBJ): find
	@javac @sources.txt

find: $(SRC)
	@find -name *.java > sources.txt

clean:
	@rm simulation.txt

fclean: clean
	@rm $(package)*.class sources.txt

re: fclean all