package za.co.wethinkcode.royalAirServices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        if (args.length == 1) {
            correctFormat(args);
        } else {
            wrongFormat(args);
        }
    }

    private static void correctFormat(String[] args) {
        try {
            File scenarioFile = new File(args[0]);
            FileWriter simulationFile = new FileWriter("simulation.txt");
            Scanner scenarioReader = new Scanner(scenarioFile);

            try {
                simulationFile.write("Something");
                simulationFile.close();
                System.out.println("file created and written into successfully");
            } catch (IOException err) {
                err.getMessage();
            }

            while (scenarioReader.hasNextLine()) {
                String scenarioText = scenarioReader.nextLine();
                System.out.println(scenarioText);
            }
            scenarioReader.close();
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
}