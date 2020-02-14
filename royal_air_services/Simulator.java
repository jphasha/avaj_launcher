package royal_air_services;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;

public class Simulator {
    public static void main(String[] args) {

        // let us start reading our standard input
        InputStreamReader myInput = new InputStreamReader(System.in);

        // buffering the input
        BufferedReader myBufferedInput = new BufferedReader(myInput);

        // read line from our buffered input. i.e. put in string format
        String inputString = myBufferedInput.readLine();

        // print the input to the standard
        System.out.println(inputString);
    }
}