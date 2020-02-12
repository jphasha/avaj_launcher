package = ./royal_air_services/

SOURCES = $(package)Aircraft.java $(package)Coordinates.java $(package)Helicopter.java \

OBJECTS = $(package)Aircraft.class $(package)Coordinates.class $(package)Helicopter.class \

all: $(OBJECTS)

$(OBJECTS): $(SOURCES)
	javac $(package)Aircraft.java

re: fclean alll

clean:

fclean: