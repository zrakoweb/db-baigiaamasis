package lt.codeacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface ConsoleMenu {

    public void printMenu();

    default String readInput() throws IOException {
        System.out.print("jusu pasirinkimas: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }
}
