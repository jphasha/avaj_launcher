package za.co.wethinkcode.royalAirServices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    public static List<String> scenario = new ArrayList<>();
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
            writeSimulation();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
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
            System.out.println("you need to have 1 argument when running this program\nPreferrably a file named'scenario.txt'.");
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
            for (String content : scenario) {
                simulationFile.write(content);
                // simulationFile.newLine();
                simulationFile.append("\n");
                System.out.println(content);
            }
            simulationFile.close();
            System.out.println("file created and written into successfully");
        } catch (IOException err) {
            err.getMessage();
        }
    }
}