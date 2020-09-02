package za.co.wethinkcode.royalAirServices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import za.co.wethinkcode.royalAirServices.aircraftFactory.AircraftFactory;
import za.co.wethinkcode.royalAirServices.exceptions.CustomException;
import za.co.wethinkcode.royalAirServices.interfaces.Flyable;
import za.co.wethinkcode.royalAirServices.logBook.LogBook;
import za.co.wethinkcode.royalAirServices.tower.weather.WeatherTower;

public class Simulator {

    public static List<String> scenario = new ArrayList<>();
    public static int simulations = 0;
    public static List<Flyable> aircrafts = new ArrayList<>();
    public static void main(String[] args) {
        if (args.length == 1) {
            correctFormat(args);
        } else {
            wrongFormat(args);
        }
    }

    private static void correctFormat(String[] args) {
        try {
            readScenario(args);
            parseScenario();
            simulate();
            writeSimulation();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        } catch (CustomException err) {
            System.out.println(err.getMessage());
        }
    }
    private static void wrongFormat(String[] args) {
        if (args.length > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("ERROR!!\nYou have given the program too many arguments. You should consider using only one of:");

            for (int i = 0; i < args.length; i++) {
                sb.append("\n" + args[i]);
            }
            sb.append("\nAs your argument(Provided that they are txt files). Otherwise use 'scenario.txt' as your argument");
            int pos = sb.indexOf(". You should");
            sb.insert(pos, ", " + args.length + " to be exact");
            System.out.println(sb.toString());
        } else {
            System.out.println("you need to have 1 argument when running this program\nPreferrably a file named 'scenario.txt'.");
        }
    }

    private static void readScenario(String[] args) throws IOException {
        File scenarioFile = new File(args[0]);
        BufferedReader scenarioReader = new BufferedReader(new FileReader(scenarioFile));
        String scenarioLine = null;

        while ((scenarioLine = scenarioReader.readLine()) != null) {
            scenario.add(scenarioLine);
        }
        scenarioReader.close();
    }

    private static void writeSimulation() throws IOException {
        BufferedWriter simulationFile = new BufferedWriter(new FileWriter("simulation.txt"));

        try {
            for (String content : LogBook.logs) {
                simulationFile.write(content);
                simulationFile.append("\n");
            }
            simulationFile.close();
        } catch (IOException err) {
            err.getMessage();
        }
    }

    private static void parseScenario() throws CustomException {
        if (scenario.size() < 2) {
            throw new CustomException("Wrong format", "you need more than one line");
        }
        for (String scenarioLine : scenario) {
            if (scenario.indexOf(scenarioLine) != 0) {
                parseAircrafts(scenarioLine);
            } else {
                parseSimulationsNumber(scenarioLine);
            }
        }
    }

    private static void simulate() {
        WeatherTower weatherTower = new WeatherTower();

        for (Flyable flyable : aircrafts) {
            flyable.registerTower(weatherTower);
        }

        for (int log = 0; log < simulations; log++) {
            weatherTower.checkWeather();
        }
    }

    private static void parseAircrafts(String scenarioLine) throws CustomException {
        String[] aircraftDetails;
        List<String> craftDetails = new ArrayList<>();

        aircraftDetails = null;
        aircraftDetails = scenarioLine.split(" ");
        for (String splitDetail : aircraftDetails) {
            if (!splitDetail.isEmpty()) {
                craftDetails.add(splitDetail);
            }
        }
        if (craftDetails.size() == 5) {
            registerAircraft(craftDetails);
        } else {
            throw new CustomException("All lines save for the number of simulations line needs 5 parts/words", scenarioLine + " has " + craftDetails.size());
        }
    }

    private static void parseSimulationsNumber(String scenarioLine) throws CustomException {
        try {
            simulations = Integer.valueOf(scenario.get(0));
            if (simulations < 1) {
                throw new CustomException("Simulation must be run atleast once", scenario.get(0) + " will not do.");
            }
        } catch (NumberFormatException err) {
            throw new CustomException("The number of simulations must be a number(integer), and not", scenario.get(0), err);
        }
    }

    private static void registerAircraft(List<String> craftDetails) throws CustomException {
        try {
            if (Integer.valueOf(craftDetails.get(2)) >= 0 && Integer.valueOf(craftDetails.get(3)) >= 0 && Integer.valueOf(craftDetails.get(4)) >= 0) {
                if (craftDetails.get(0).equalsIgnoreCase("Helicopter") || craftDetails.get(0).equalsIgnoreCase("Baloon") || craftDetails.get(0).equalsIgnoreCase("Jetplane")) {
                    aircrafts.add(AircraftFactory.newAircraft(craftDetails.get(0), craftDetails.get(1), Integer.valueOf(craftDetails.get(2)), Integer.valueOf(craftDetails.get(3)), Integer.valueOf(craftDetails.get(4))));
                } else {
                    throw new CustomException("Invalid craft type", craftDetails.get(0) + " is wrong");
                }
            }
        } catch(NumberFormatException er) {
            throw new CustomException("Latitude, Longitude and height are all expected to be positive numbers", "See anything wrong here?: " + craftDetails.get(0) + " " + craftDetails.get(1) + " " + craftDetails.get(2) + " " + craftDetails.get(3) + " " + craftDetails.get(4));
        }
        craftDetails.clear();
    }
}