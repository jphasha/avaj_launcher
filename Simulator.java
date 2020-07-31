import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        if (args.length == 1) {
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
        } else if (args.length > 1) {
            System.out.println("this program only accepts one argument, Prefeably a file named 'scenario.txt'");
        } else {
            System.out.println("you need to have 1 argument when running this program\nPreferrably a file named'scenario.txt'.");
        }
    }
}