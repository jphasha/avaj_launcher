package royal_air_services;

// java.io.*; can easily solve my problems below but i chose to call these methods individually to familiarise myself with this class.
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

// buffered reader above can also do it but to hell with it. what else can do it?
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        // let us start reading our standard input
        InputStreamReader myInput = new InputStreamReader(System.in);

        // buffering the input
        BufferedReader myBufferedInput = new BufferedReader(myInput);

        // read line from our buffered input. i.e. put in string format
        String inputString = myBufferedInput.readLine();

        // now the read from the text file part.
        // first define the file to be read:
        File someTextFile = new File("/goinfre/jphasha/Desktop/thisFile.txt");

        // now read it using Scanner
        Scanner fileContent = new Scanner(someTextFile);

        // print the input to the standard
        System.out.println(inputString);
        while (fileContent.hasNext()) {
            System.out.println(fileContent.nextLine());
        }
    }
}