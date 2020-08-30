package = za/co/wethinkcode/royalAirServices/

OBJ = $(package)Simulator.class \
	$(package)interfaces/Flyable.class \
	$(package)tower/Tower.class \
	$(package)tower/weather/WeatherProvider.class \
	$(package)tower/weather/WeatherTower.class \
	$(package)aircraftFactory/Aircraft.class \
	$(package)aircraftFactory/AircraftFactory.class \
	$(package)aircraftFactory/Coordinates.class \
	$(package)aircraftFactory/aircrafts/Baloon.class \
	$(package)aircraftFactory/aircrafts/Helicopter.class \
	$(package)aircraftFactory/aircrafts/JetPlane.class \
	$(package)exceptions/CustomException.class

SRC = $(package)Simulator.java \
	$(package)interfaces/Flyable.java \
	$(package)tower/Tower.java \
	$(package)tower/weather/WeatherProvider.java \
	$(package)tower/weather/WeatherTower.java \
	$(package)aircraftFactory/Aircraft.java \
	$(package)aircraftFactory/AircraftFactory.java \
	$(package)aircraftFactory/Coordinates.java \
	$(package)aircraftFactory/aircrafts/Baloon.java \
	$(package)aircraftFactory/aircrafts/Helicopter.java \
	$(package)aircraftFactory/aircrafts/JetPlane.java \
	$(package)exceptions/CustomException.java

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
	@find -name *.class > objects.txt
	@rm @objects.txt
	@rm sources.txt objects.txt

re: fclean all