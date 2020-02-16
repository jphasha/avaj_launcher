package royal_air_services;

// java.io.*; can easily solve my problems below but i chose to call these methods individually to familiarise myself with this class.
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

// buffered reader above can also do it but to hell with it. what else can do it?
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// write into a file
import java.io.FileWriter;

public class Simulator {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        // let us start reading our standard input
        InputStreamReader myInput = new InputStreamReader(System.in);

        // buffering the input
        BufferedReader myBufferedInput = new BufferedReader(myInput);

        // read line from our buffered input. i.e. put in string format
        String inputString = myBufferedInput.readLine();

        // you can also create this file with code:
        try {
            File fileCreator = new File("/goinfre/jphasha/Desktop/createdFile.txt");

            if (fileCreator.createNewFile()) {
                System.out.println("succesfully created file");
            } else {
                System.out.println("file already exists");
            }
        } catch (IOException err) {
            System.out.println("an error has occured");
            err.printStackTrace();
        }

        // now that we have a file, let's write into it.
        try {
            FileWriter ourWriter = new FileWriter("/goinfre/jphasha/Desktop/createdFile.txt");
            ourWriter.write("you see?\n it is very much possible to do this thing");
            ourWriter.close();
            System.out.println("well done, you ha written into a file");
        } catch (IOException error) {
            System.out.println("well! that is kapoots");
            error.printStackTrace();
        }
        // now the read from the text file part.
        // define the file to be read:
        File someTextFile = new File("/goinfre/jphasha/Desktop/thisFile.txt");

        // now read it using Scanner
        Scanner fileContent = new Scanner(someTextFile);

        // print the input to the standard
        System.out.println(inputString);
        while (fileContent.hasNext()) {
            System.out.println(fileContent.nextLine());
        }

        // delete file(s)
        File delFile = new File("/goinfre/jphasha/Desktop/createdFile.txt");
        if (delFile.delete()) {
            System.out.println("that file is outta here");
        } else {
            System.out.println("Listen, that file is so far gone.\nIt is outta here");
        }
    }
}